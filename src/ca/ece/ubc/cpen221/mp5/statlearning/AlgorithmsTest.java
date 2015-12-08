package ca.ece.ubc.cpen221.mp5.statlearning;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgorithmsTest {
<<<<<<< HEAD
    String restaurantFile = "/Users/RCastro/workspace/CPEN221-mp5/data/restaurants.json";
    String reviewFile = "/Users/RCastro/workspace/CPEN221-mp5/data/reviews.json";
    String userFile = "/Users/RCastro/workspace/CPEN221-mp5/data/users.json";
	RestaurantDB db = new RestaurantDB(restaurantFile, reviewFile, userFile);

	@Test
	public void printTest() {
		List<Set<Restaurant>> clusters = Algorithms.kMeansClustering(100, db);
		System.out.println(Algorithms.convertClustersToJSON(clusters));
=======

	@Test
	public void test() {
		fail("Not yet implemented");
>>>>>>> cc211a2da043e2a0497ac5b0937604c790992808
	}
	
	@Test
	public void predictorTest() {
		
	}
	
	@Test
	public void bestPredictorTest() {
		
	}

}
