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
		this.adjacentStations = new TreeSet<AdjacentStation>();	// use tree set to visit stations in time ascending order
	}
}

class SearchResult {
	boolean routesExists;
	int time;
	int stop;
	String errorMessage;
	
	SearchResult() {
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
	
	SearchResult search(String startingStationName, String endingStationName) {
		SearchResult result = new SearchResult();
		if (startingStationName == null || startingStationName == "" || !stationMap.containsKey(startingStationName)) {
			result.errorMessage = "starting station doesn't exist.";
			return result;
		}
		
		if (endingStationName == null || endingStationName == "" || !stationMap.containsKey(endingStationName)) {
			result.errorMessage = "ending station doesn't exist.";
			return result;
		}
		
		if (startingStationName.equalsIgnoreCase(endingStationName)) {
			result.errorMessage = "starting station and ending station are same.";
			return result;
		}
		
		Station startingStation = stationMap.get(startingStationName);
		searchRecursive(startingStation, endingStationName, new HashSet<String>(), 0, result);

		return result;
	}
	
	void searchRecursive(Station currentStation, String endingStationName, Set<String> visitedSet, int accumulatedTime, SearchResult result) {
		// if shorter time already exists in result, no need to find the routes
		if (accumulatedTime > result.time) {
			return;
		}
		
		// mark visited
		visitedSet.add(currentStation.name);
		
		// if reaches ending station, put result data and return
		if (currentStation.name.equalsIgnoreCase(endingStationName)) {
			result.stop = visitedSet.size() - 2;
			result.time = accumulatedTime;
			if (!result.routesExists) {
				result.routesExists = true;	
			}
			return;
		}
		
		// iterate all adjacent stations in time ascending order
		Iterator<AdjacentStation> iterator = currentStation.adjacentStations.iterator();
		while (iterator.hasNext()) {
			AdjacentStation adjacentStation = iterator.next();
			// skip already visited station
			if (visitedSet.contains(adjacentStation.name)) {
				continue;
			}
			// should pass new set as each route should have its own set to track visited station
			searchRecursive(stationMap.get(adjacentStation.name), endingStationName, new HashSet<String>(visitedSet), accumulatedTime + adjacentStation.time, result);
		}
	}
}

public class CreaCodeChallenge {
	
	public static void main(String[] args) {
		TrainRoutes trainRoutes = new TrainRoutes();
		BufferedReader csvReader;
		String filePath = "routes.csv";
		if (args.length > 0 && args[0] != "") {
			filePath = args[0];
		}
		try {
			csvReader = new BufferedReader(new FileReader(filePath));
			String row;
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    if (data.length != 3) {
			    		System.out.println(String.format("Incorrect format of data: %s", row));
			    		continue;
			    }
			    
			    String startingStation = data[0];
		    		if (startingStation == null || startingStation == "") {
		    			System.out.println(String.format("Incorrect format of starting station: %s", startingStation));
			    		continue;
		    		}
		    		
		    		String endingStation = data[1];
		    		if (endingStation == null || endingStation == "") {
		    			System.out.println(String.format("Incorrect format of ending station: %s", endingStation));
			    		continue;
		    		}
		    		
			    try {
			    		int time = Integer.valueOf(data[2]);
				    if (time < 0) {
			    			System.out.println(String.format("Incorrect format of time: %d", time));
				    		continue;
				    }
				    trainRoutes.addRelation(startingStation, endingStation, time);
			    } catch (NumberFormatException e) {
			    		System.out.println(String.format("Incorrect format of time: %s", data[2]));
			    }
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
    			System.out.println(String.format("File doesn't exists: %s", filePath));
    			return;
		} catch (IOException e) {
			System.out.println(String.format("error occured while reading file: %s", filePath));
			return;
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
			System.out.println("error occured while running application");
		}
	}
}

