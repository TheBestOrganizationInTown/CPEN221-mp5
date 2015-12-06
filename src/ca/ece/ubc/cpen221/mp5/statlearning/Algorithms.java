package ca.ece.ubc.cpen221.mp5.statlearning;

import java.util.*;
import ca.ece.ubc.cpen221.mp5.*;

public class Algorithms {

	/**
	 * Use k-means clustering to compute k clusters for the restaurants in the
	 * database.
	 * 
	 * @param db
	 * @return
	 */
	public static List<Set<Restaurant>> kMeansClustering(int k, RestaurantDB db) {
		List<Restaurant> restaurantList = new ArrayList<Restaurant>(); // some observer method
		Map<Restaurant,Location> restaurantMap = populateMap(restaurantList);
		
		Random randomizer = new Random();
		
		for(int i = 0; i < k; i++){
			
		}
		
		return null;
	}

	public static String convertClustersToJSON(List<Set<Restaurant>> clusters) {
		// TODO: Implement this method
		return null;
	}

	public static MP5Function getPredictor(User u, RestaurantDB db, MP5Function featureFunction) {
		// TODO: Implement this method
		return null;
	}

	public static MP5Function getBestPredictor(User u, RestaurantDB db, List<MP5Function> featureFunctionList) {
		// TODO: Implement this method
		return null;
	}
	
	private static Map<Restaurant,Location> populateMap(List<Restaurant> restaurantList){
		Map<Restaurant, Location> restaurantMap = new HashMap<Restaurant, Location>(); 
		Location currentLocation;
		Iterator<Restaurant> restaurantIterator = restaurantList.iterator();
		
		while(restaurantIterator.hasNext()){
			Restaurant currentRestaurant = restaurantIterator.next();
			currentLocation = new Location(currentRestaurant);
			restaurantMap.put(currentRestaurant, currentLocation);
		}
		
		return new HashMap<Restaurant, Location>(restaurantMap);
	}
	
	private static Map<Integer,Location> initializeSeeds(int k, Map<Restaurant,Location> restaurantMap){
		Map<Integer, Location> seedMap = new HashMap<Integer,Location>();
		
		for(int i = 0; i < k; i++){
			
		}
		return seedMap;
	}
}