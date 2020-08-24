package interview.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class AdjacentStation implements Comparable<AdjacentStation> {
	String name;
	int time;
	
	AdjacentStation(String name, int time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public int compareTo(AdjacentStation target) {
		return target.time - this.time;
	}
}

class Station {
	String name;
	PriorityQueue<AdjacentStation> adjacentStations;
	
	Station(String name) {
		this.name = name;
		this.adjacentStations = new PriorityQueue<AdjacentStation>();
	}
}

class SearchResult {
	String startingStation;
	String endingStation;
	int time;
	int stop;
	String errorMessage;
	
	SearchResult(String startingStation, String endingStation) {
		this.startingStation = startingStation;
		this.endingStation = endingStation;
	}
	
	String getResult() {
		if (errorMessage != null) {
			return errorMessage;
		}
		
		if (time == Integer.MAX_VALUE) {
			return String.format("No Routes from %s to %s", startingStation, endingStation);
		}
		
		return String.format("Your trip from %s to %s includes %d stops and will take %d minutes.", startingStation, endingStation, stop, time);
	}
}

class TrainRoutes {
	Map<String, Station> stationMap;
	Map<String, SearchResult> searchResultMap;
	
	TrainRoutes() {
		stationMap = new HashMap<String, Station>();
		searchResultMap = new HashMap<String, SearchResult>();
	}
	
	void addRelation(String firstStationName, String secondStationName, int time) {
		addStation(firstStationName, secondStationName, time);
		addStation(secondStationName, firstStationName, time);
	}
	
	void addStation(String stationName, String adjacentStationName, int time) {
		if (!stationMap.containsKey(stationName)) {
			stationMap.put(stationName, new Station(stationName));
		}
		stationMap.get(stationName).adjacentStations.add(new AdjacentStation(adjacentStationName, time));
	}
	
	SearchResult search(String startingStation, String endingStation) {
		SearchResult tempResult = new SearchResult(startingStation, endingStation);
		if (!stationMap.containsKey(startingStation)) {
			tempResult.errorMessage = "starting station doesn't exist.";
			return tempResult;
		}
		
		if (!stationMap.containsKey(endingStation)) {
			tempResult.errorMessage = "ending station doesn't exist.";
			return tempResult;
		}
		
		Station starting = stationMap.get(startingStation);
		tempResult.time = Integer.MAX_VALUE;
		tempResult.stop = 0;
		searchRecursive(starting, endingStation, new HashSet<String>(), 0, tempResult);
		return tempResult;
	}
	
	void searchRecursive(Station startingStation, String endingStationName, Set<String> visitedSet, int accumulatedTime, SearchResult tempResult) {
		if (accumulatedTime > tempResult.time) {
			return;
		}
		
		visitedSet.add(startingStation.name);
		
		if (startingStation.name.equalsIgnoreCase(endingStationName)) {
			tempResult.stop = visitedSet.size() - 2;
			tempResult.time = accumulatedTime;
			return;
		}
		
		Iterator<AdjacentStation> iterator = startingStation.adjacentStations.iterator();
		while (iterator.hasNext()) {
			AdjacentStation adjacentStation = iterator.next();
			if (visitedSet.contains(adjacentStation.name)) {
				continue;
			}
			searchRecursive(stationMap.get(adjacentStation.name), endingStationName, new HashSet<String>(visitedSet), accumulatedTime + adjacentStation.time, tempResult);
		}
	}
}

public class CreaCodeChallenge {
	// using external library for unit test ok?
	// about csv data, can I assume that the time between 2 stops is always positive integer number?
	// any range of csv file data? such as the number of lines of csv data is 1 < number of lines < N
	// 'No need to use any algorithm' means I shouldn't use any existing algorithm? or 
	public static void main(String[] args) {
		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader("routes.csv"));
			String row;
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    // do something with the data
			}
			csvReader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TrainRoutes trainRoutes = new TrainRoutes();
		trainRoutes.addRelation("A", "B", 5);
		trainRoutes.addRelation("B", "C", 5);
		trainRoutes.addRelation("C", "D", 7);
		trainRoutes.addRelation("A", "D", 15);
		trainRoutes.addRelation("E", "F", 5);
		trainRoutes.addRelation("F", "G", 5);
		trainRoutes.addRelation("G", "H", 10);
		trainRoutes.addRelation("H", "I", 10);
		trainRoutes.addRelation("I", "J", 5);
		trainRoutes.addRelation("G", "J", 20);
		
		SearchResult result = trainRoutes.search("A", "J");
		
		System.out.println(result.getResult());
	}

}

