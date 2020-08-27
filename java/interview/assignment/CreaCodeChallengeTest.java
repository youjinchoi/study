package interview.assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreaCodeChallengeTest {
	TrainRoutes trainRoutes = new TrainRoutes();

	@BeforeEach
	void setUp() throws Exception {
		trainRoutes = new TrainRoutes();
	}

	@Test
	void should_return_shortest_time_routes() {
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
		
		SearchResult result;
		result = trainRoutes.search("A", "B");
		assertEquals(result.stop, 0);
		assertEquals(result.time, 5);
		
		result = trainRoutes.search("A", "C");
		assertEquals(result.stop, 1);
		assertEquals(result.time, 10);
		
		result = trainRoutes.search("E", "J");
		assertEquals(2, result.stop);
		assertEquals(result.time, 30);
		
		result = trainRoutes.search("A", "D");
		assertEquals(result.stop, 0);
		assertEquals(result.time, 15);
		
		result = trainRoutes.search("A", "J");
		assertFalse(result.routesExists);
	}
	
	@Test
	void routes_shouldnt_exists_when_data_is_empty() {
		SearchResult result = trainRoutes.search("A", "B");
		assertFalse(result.routesExists);
	}
	
	@Test
	void should_return_error_message_when_starting_or_ending_station_doesnt_exist() {
		trainRoutes.addRelation("A", "B", 5);
		trainRoutes.addRelation("B", "C", 5);
		trainRoutes.addRelation("C", "D", 7);
		trainRoutes.addRelation("A", "D", 15);
		
		SearchResult result;
		result = trainRoutes.search("Z", "B");
		assertFalse(result.routesExists);
		assertEquals("starting station doesn't exist.", result.errorMessage);
		
		result = trainRoutes.search("A", "Z");
		assertFalse(result.routesExists);
		assertEquals("ending station doesn't exist.", result.errorMessage);
		
		result = trainRoutes.search(null, "B");
		assertFalse(result.routesExists);
		assertEquals("starting station doesn't exist.", result.errorMessage);
		
		result = trainRoutes.search("A", "");
		assertFalse(result.routesExists);
		assertEquals("ending station doesn't exist.", result.errorMessage);
	}
	
	@Test
	void should_take_only_first_input_when_routes_are_duplicate() {
		trainRoutes.addRelation("A", "B", 5);
		trainRoutes.addRelation("A", "B", 4);
		trainRoutes.addRelation("B", "A", 3);
		trainRoutes.addRelation("B", "A", 2);
		
		SearchResult result = trainRoutes.search("A", "B");
		assertEquals(result.stop, 0);
		assertEquals(result.time, 5);
	}
	
	@Test
	void should_return_error_message_when_starting_and_ending_station_are_same() {
		trainRoutes.addRelation("A", "B", 5);
		
		SearchResult result = trainRoutes.search("A", "A");
		assertEquals("starting station and ending station are same.", result.errorMessage);
	}
}
