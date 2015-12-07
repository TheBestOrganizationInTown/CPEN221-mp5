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
		List<Restaurant> restaurantList = new ArrayList<Restaurant>(db.getRestaurants);

		Map<Integer, Location> seedMap = initializeSeeds(k, restaurantList);
		
		List<Set<Restaurant>> clusterList = new ArrayList<Set<Restaurant>>();
		boolean sameAsBefore = false;
		
		clusterList = updateClusters(restaurantList, seedMap);
		
		do{
		if(seedMap.equals(updateCentroids(clusterList)))
				sameAsBefore = true;

		seedMap = updateCentroids(clusterList);
		clusterList = updateClusters(restaurantList, seedMap);
		}while(!sameAsBefore);
		
		return clusterList;
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

	/**
	 * Returns a map of all the restaurants and their locations given by
	 * restaurantList
	 * 
	 * @param restaurantList
	 * @return
	 */
	private static Map<Restaurant, Location> populateMap(List<Restaurant> restaurantList) {
		Map<Restaurant, Location> restaurantMap = new HashMap<Restaurant, Location>();
		Location currentLocation;
		Iterator<Restaurant> restaurantIterator = restaurantList.iterator();

		while (restaurantIterator.hasNext()) {
			Restaurant currentRestaurant = restaurantIterator.next();
			currentLocation = new Location(currentRestaurant);
			restaurantMap.put(currentRestaurant, currentLocation);
		}

		return new HashMap<Restaurant, Location>(restaurantMap);
	}

	/**
	 * 
	 * @param k
	 * @param restaurantList
	 * @return
	 */
	private static Map<Integer, Location> initializeSeeds(int k, List<Restaurant> restaurantList) {
		Map<Integer, Location> seedMap = new HashMap<Integer, Location>();
		List<Restaurant> listCopy = new LinkedList<Restaurant>(restaurantList);
		Random randomizer = new Random();
		int randomIndex;
		Location randomLocation;

		for (int i = 0; i < k; i++) {
			randomIndex = randomizer.nextInt(listCopy.size());
			randomLocation = new Location(listCopy.get(randomIndex));
			listCopy.remove(randomIndex);
			seedMap.put(i, randomLocation);
		}

		return new HashMap<Integer, Location>(seedMap);
	}

	/**
	 * 
	 * @param restaurantList
	 * @param seedMap
	 * @return
	 */
	private static List<Set<Restaurant>> updateClusters(List<Restaurant> restaurantList, Map<Integer,Location> seedMap) {
		
		List<Set<Restaurant>> clusterList = new ArrayList<Set<Restaurant>>();
		Iterator<Restaurant> restaurantIterator = restaurantList.iterator();
		
		Restaurant restaurantToBeAssigned;
		int assignmentNumber;
		while(restaurantIterator.hasNext()){
			restaurantToBeAssigned = restaurantIterator.next();
			assignmentNumber = calculateClosestSeed(seedMap, restaurantToBeAssigned);
			
			clusterList.get(assignmentNumber).add(restaurantToBeAssigned);
		}
		
		return clusterList;
	}

	/**
	 * 
	 * @param seedMap
	 * @param restaurant
	 * @return
	 */
	private static Integer calculateClosestSeed(Map<Integer, Location> seedMap, Restaurant restaurant) {
		int closestSeed = 0;
		Location restaurantLocation = new Location(restaurant);
		double currentClosestDistance = calculateDistance(seedMap.get(0), restaurantLocation);

		double distanceToCompare;
		for (int i = 1; i < seedMap.size(); i++) {
			distanceToCompare = calculateDistance(seedMap.get(i), restaurantLocation);
			if (distanceToCompare < currentClosestDistance) {
				currentClosestDistance = distanceToCompare;
				closestSeed = i;
			}
		}
		return new Integer(closestSeed);
	}

	/**
	 * Returns the euclidean distance between locationA and locationB
	 * 
	 * @param locationA
	 * @param locationB
	 * @return double
	 */
	private static Double calculateDistance(Location locationA, Location locationB) {

		double euclideanDistance;
		double distanceX;
		double distanceY;

		distanceX = locationB.getLatitude() - locationA.getLatitude();
		distanceY = locationB.getLongitude() - locationA.getLongitude();
		
		// sqrt(distanceX^2 + distanceY^2)
		euclideanDistance = Math.pow(Math.pow(distanceX, 2) + Math.pow(distanceY, 2), 1 / 2); 

		return new Double(euclideanDistance);
	}

	/**
	 * 
	 * @param clusterGroupList
	 * @return Msp<Integer, Location>
	 */
	private static Map<Integer, Location> updateCentroids(List<Set<Restaurant>> clusterList) {
		Map<Integer, Location> seedMap = new HashMap<Integer, Location>();
		int seedQuantity = clusterList.size();

		for (int i = 0; i < seedQuantity; i++) {
			Location newCentroid = calculateCentroid(clusterList.get(i));
			seedMap.put(i, newCentroid);
		}

		return new HashMap<Integer, Location>(seedMap);
	}

	/**
	 * 
	 * @param clusterGroup
	 * @return
	 */
	private static Location calculateCentroid(Set<Restaurant> clusterGroup) {
		double totalX = 0;
		double totalY = 0;
		double averageX;
		double averageY;

		Restaurant currentRestaurant;
		int clusterSize = new Integer(clusterGroup.size() + 1);

		Iterator<Restaurant> clusterIterator = clusterGroup.iterator();

		while (clusterIterator.hasNext()) {
			currentRestaurant = clusterIterator.next();
			totalX += currentRestaurant.getLatitude();
			totalY += currentRestaurant.getLongitude();
		}

		averageX = totalX / clusterSize;
		averageY = totalY / clusterSize;

		Location centroidLocation = new Location(averageX, averageY);
		return centroidLocation;
	}

}