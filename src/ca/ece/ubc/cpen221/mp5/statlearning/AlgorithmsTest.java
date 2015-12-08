package ca.ece.ubc.cpen221.mp5.statlearning;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import ca.ece.ubc.cpen221.mp5.*;

public class AlgorithmsTest {
	String restaurantFile = "/Users/RCastro/workspace/CPEN221-mp5/data/restaurants.json";
	String reviewFile = "/Users/RCastro/workspace/CPEN221-mp5/data/reviews.json";
	String userFile = "/Users/RCastro/workspace/CPEN221-mp5/data/users.json";
	RestaurantDB db = new RestaurantDB(restaurantFile, reviewFile, userFile);
	List<User> userList = db.getUsers();
	List<Restaurant> restaurantList = db.getRestaurants();
	List<Review> reviewList = db.getReviews();

	@Test
	public void printTest() {
		List<Set<Restaurant>> clusters = Algorithms.kMeansClustering(100, db);
		System.out.println(Algorithms.convertClustersToJSON(clusters));
	}

	@Test
	public void bestPredictorTest() {
		User u = userList.get(8);
		
		MP5Function featureFunction1 = new PriceScaleFeature();
		MP5Function featureFunction2 = new RatingFeature();
		MP5Function featureFunction3 = new LatitudeFeature();
		MP5Function featureFunction4 = new LongitudeFeature();
		MP5Function featureFunction5 = new CategoryFeature();

		List<MP5Function> featureFunctionList = new ArrayList<MP5Function>();
		
		featureFunctionList.add(featureFunction1);
		featureFunctionList.add(featureFunction2);
		featureFunctionList.add(featureFunction3);
		featureFunctionList.add(featureFunction4);
		featureFunctionList.add(featureFunction5);
		
		MP5Function featureFunction0 = Algorithms.getBestPredictor(u, db, featureFunctionList);
		LinearRegressionFunction regression = Algorithms.getPredictor(u, db, featureFunction0);
		System.out.println(regression.getR2());
	}

	@Test
	public void predictorTest() {

		MP5Function featureFunction1 = new PriceScaleFeature();
		MP5Function featureFunction2 = new RatingFeature();
		MP5Function featureFunction3 = new LatitudeFeature();
		MP5Function featureFunction4 = new LongitudeFeature();
		MP5Function featureFunction5 = new CategoryFeature();

		User u = userList.get(8);
		LinearRegressionFunction regression = Algorithms.getPredictor(u, db, featureFunction5);
		System.out.println(regression.getR2());

	}

}
