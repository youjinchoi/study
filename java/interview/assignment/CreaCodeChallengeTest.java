package interview.assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
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
		
		SearchResult resultAtoB = trainRoutes.search("A", "B");
		assertEquals(resultAtoB.stop, 0);
		assertEquals(resultAtoB.time, 5);
		
		SearchResult resultAtoC = trainRoutes.search("A", "C");
		assertEquals(resultAtoC.stop, 1);
		assertEquals(resultAtoC.time, 10);
		
		SearchResult resultEtoJ = trainRoutes.search("E", "J");
		assertEquals(resultEtoJ.stop, 2);
		assertEquals(resultEtoJ.time, 30);
		
		SearchResult resultAtoD = trainRoutes.search("A", "D");
		assertEquals(resultAtoD.stop, 0);
		assertEquals(resultAtoD.time, 15);
		
		SearchResult resultAtoJ = trainRoutes.search("A", "J");
		assertFalse(resultAtoJ.routesExists);
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
		
		SearchResult resultZtoB = trainRoutes.search("Z", "B");
		assertFalse(resultZtoB.routesExists);
		assertEquals("starting station doesn't exist.", resultZtoB.errorMessage);
		
		SearchResult resultAtoZ = trainRoutes.search("A", "Z");
		assertFalse(resultAtoZ.routesExists);
		assertEquals("ending station doesn't exist.", resultAtoZ.errorMessage);
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
}
