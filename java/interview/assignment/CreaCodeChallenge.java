package interview.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

class AdjacentStation implements Comparable<AdjacentStation> {
	String name;
	int time;
	
	AdjacentStation(String name, int time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public int compareTo(AdjacentStation target) {
		if (this.name.equalsIgnoreCase(target.name)) {
			return 0;
		}
		if (this.time == target.time) {
			return this.name.compareTo(target.name);
		}
		return this.time - target.time;
	}
}

class Station {
	String name;
	Set<AdjacentStation> adjacentStations;
	
	Station(String name) {
		this.name = name;
		this.adjacentStations = new TreeSet<AdjacentStation>();
	}
}

class SearchResult {
	String startingStation;
	String endingStation;
	boolean routesExists;
	int time;
	int stop;
	String errorMessage;
	
	SearchResult(String startingStation, String endingStation) {
		this.startingStation = startingStation;
		this.endingStation = endingStation;
		this.routesExists = false;
		this.time = Integer.MAX_VALUE;
		this.stop = -1;
	}
}

class TrainRoutes {
	Map<String, Station> stationMap;
	
	TrainRoutes() {
		stationMap = new HashMap<String, Station>();
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
		SearchResult result = new SearchResult(startingStation, endingStation);
		if (!stationMap.containsKey(startingStation)) {
			result.errorMessage = "starting station doesn't exist.";
			return result;
		}
		
		if (!stationMap.containsKey(endingStation)) {
			result.errorMessage = "ending station doesn't exist.";
			return result;
		}
		
		Station starting = stationMap.get(startingStation);
		searchRecursive(starting, endingStation, new HashSet<String>(), 0, result);

		return result;
	}
	
	void searchRecursive(Station startingStation, String endingStationName, Set<String> visitedSet, int accumulatedTime, SearchResult tempResult) {
		if (accumulatedTime > tempResult.time) {
			return;
		}
		
		visitedSet.add(startingStation.name);
		
		if (startingStation.name.equalsIgnoreCase(endingStationName)) {
			tempResult.stop = visitedSet.size() - 2;
			tempResult.time = accumulatedTime;
			if (!tempResult.routesExists) {
				tempResult.routesExists = true;	
			}
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
	
	public static void main(String[] args) {
		TrainRoutes trainRoutes = new TrainRoutes();
		BufferedReader csvReader;
		String filePath = "/Users/youjin/git/study/java/interview/assignment/routes.csv";	// /Users/youjin/git/study/java/interview/assignment/routes.csv
		if (args.length > 0) {
			filePath = args[0];
		}
		try {
			csvReader = new BufferedReader(new FileReader(filePath));
			String row;
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    if (data.length != 3) {
			    		System.out.println(String.format("Incorrect format of data: %s to %s", row));
			    		continue;
			    }
			    try {
			    		int time = Integer.valueOf(data[2]);
				    if (time < 0) {
			    			System.out.println(String.format("Incorrect format of data: %s to %s", row));
				    		continue;
				    }
				    trainRoutes.addRelation(data[0], data[1], time);
			    } catch (NumberFormatException e) {
			    		System.out.println(String.format("Incorrect format of data: %s to %s", row));
			    }
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
    			System.out.println(String.format("File doesn't exists:", filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String startingStation = null, endingStation = null;
		try {
			System.out.println("What station are you getting on the train?");
			startingStation = reader.readLine();
			
			System.out.println("What station are you getting off the train?");
			endingStation = reader.readLine();
			
			SearchResult result = trainRoutes.search(startingStation, endingStation);
			
			if (result.errorMessage != null) {
				System.out.println(result.errorMessage);
			} else if (!result.routesExists) {
				System.out.println(String.format("No Routes from %s to %s", startingStation, endingStation));
			} else {
				System.out.println(String.format("Your trip from %s to %s includes %d stops and will take %d minutes.", startingStation, endingStation, result.stop, result.time));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

