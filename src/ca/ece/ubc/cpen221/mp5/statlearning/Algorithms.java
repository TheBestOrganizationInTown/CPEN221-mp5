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
		List<Restaurant> restaurantList = new ArrayList<Restaurant>(db.getRestaurants());
		List<Set<Restaurant>> clusterList = new ArrayList<Set<Restaurant>>();

		Map<Integer, Location> seedMap = initializeSeeds(k, restaurantList);
		Map<Integer, Location> updatedSeeds;
		boolean sameAsBefore;
		clusterList = updateClusters(restaurantList, seedMap);
		do {
			sameAsBefore = true;
			updatedSeeds = updateCentroids(clusterList);

			for (int i = 0; i < seedMap.size(); i++) {
				Double latitude = seedMap.get(i).getLatitude();
				double updatedLatitude = updatedSeeds.get(i).getLatitude();
				Double longitude = seedMap.get(i).getLongitude();
				double updatedLongitude = updatedSeeds.get(i).getLongitude();
				if (!latitude.equals(updatedLatitude)) {
					sameAsBefore = false;
				}
				if (!longitude.equals(updatedLongitude)) {
					sameAsBefore = false;
				}
			}

			seedMap = new HashMap<Integer, Location>(updatedSeeds);
			clusterList = updateClusters(restaurantList, seedMap);
		} while (!sameAsBefore);

		return clusterList;
	}

	public static String convertClustersToJSON(List<Set<Restaurant>> clusters) {
		String stringJSON = new String();
		Restaurant restaurantItem;

		stringJSON = stringJSON.concat("[");
		for (int i = 0; i < clusters.size(); i++) {
			Iterator<Restaurant> setIterator = clusters.get(i).iterator();
			while (setIterator.hasNext()) {
				restaurantItem = setIterator.next();

				stringJSON = stringJSON.concat("{\"x\": " + restaurantItem.getLatitude() + ", ");
				stringJSON = stringJSON.concat("\"y\": " + restaurantItem.getLongitude() + ", ");
				stringJSON = stringJSON.concat("\"name\": \"" + restaurantItem.getName() + "\", ");
				stringJSON = stringJSON.concat("\"cluster\": " + i + ", ");
				stringJSON = stringJSON.concat("\"weight\": " + 2.0 + "}, ");
			}
		}
		stringJSON = stringJSON.concat("]");
		return stringJSON;
	}

	public static LinearRegressionFunction getPredictor(User u, RestaurantDB db, MP5Function featureFunction) {
		String UserID = u.getUserID();
		List<Review> reviews = db.getReviews();
		List<Restaurant> restaurants = db.getRestaurants();

		List<Double> inputs = new ArrayList<Double>();
		List<Double> outputs = new ArrayList<Double>();

		Map<String, Restaurant> restaurantIDs = mapIDs(restaurants);

		Iterator<Review> reviewIterator = reviews.iterator();

		while (reviewIterator.hasNext()) {
			Review currentReview = reviewIterator.next();
			if (currentReview.getUserID().equals(UserID)) {
				inputs.add(featureFunction.f(restaurantIDs.get(currentReview.getBusinessID()), db));
				outputs.add((double) currentReview.getStars());
			}
		}

		LinearRegressionFunction linearRegression = new LinearRegressionFunction(inputs, outputs, featureFunction);
		return linearRegression;
	}

	public static MP5Function getBestPredictor(User u, RestaurantDB db, List<MP5Function> featureFunctionList) {
		MP5Function currentFeature = featureFunctionList.get(0);
		LinearRegressionFunction currentLinearRegression = getPredictor(u, db, currentFeature);
		LinearRegressionFunction comparedRegression;

		double currentR2 = currentLinearRegression.getR2();
		double r2Compared;

		for (int i = 1; i < featureFunctionList.size(); i++) {
			comparedRegression = getPredictor(u, db, featureFunctionList.get(i));
			r2Compared = comparedRegression.getR2();

			if (r2Compared > currentR2) {
				currentR2 = new Double(r2Compared);
				currentFeature = featureFunctionList.get(i);
			}
		}
		return currentFeature;
	}

	/**
	 * Returns a map of all the restaurants and their business IDs given by
	 * restaurantList
	 * 
	 * @param restaurantList
	 * @return
	 */
	private static Map<String, Restaurant> mapIDs(List<Restaurant> restaurantList) {
		Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
		String currentID;
		Iterator<Restaurant> restaurantIterator = restaurantList.iterator();

		while (restaurantIterator.hasNext()) {
			Restaurant currentRestaurant = restaurantIterator.next();
			currentID = currentRestaurant.getBusinessID();
			restaurantMap.put(currentID, currentRestaurant);
		}

		return new HashMap<String, Restaurant>(restaurantMap);
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
		List<Location> currentLocations = new LinkedList<Location>();

		Random randomizer = new Random();
		int randomIndex;
		Location randomLocation;
		for (int i = 0; i < k; i++) {
			if (i < restaurantList.size()) {
				randomIndex = randomizer.nextInt(listCopy.size());
				randomLocation = new Location(listCopy.get(randomIndex));

				assert (!currentLocations.contains(randomLocation));
				currentLocations.add(randomLocation);

				listCopy.remove(randomIndex);
				seedMap.put(i, randomLocation);
			}
		}

		return new HashMap<Integer, Location>(seedMap);
	}

	/**
	 * 
	 * @param restaurantList
	 * @param seedMap
	 * @return
	 */
	private static List<Set<Restaurant>> updateClusters(List<Restaurant> restaurantList,
			Map<Integer, Location> seedMap) {

		List<Set<Restaurant>> clusterList = new ArrayList<Set<Restaurant>>();
		Iterator<Restaurant> restaurantIterator = restaurantList.iterator();
		Set<Restaurant> emptySet = new HashSet<Restaurant>();
		for (int i = 0; i < seedMap.size(); i++) {
			emptySet = new HashSet<Restaurant>();
			clusterList.add(i, emptySet);
		}
		Restaurant restaurantToBeAssigned;
		int assignmentNumber;
		while (restaurantIterator.hasNext()) {
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
		euclideanDistance = Math.pow(Math.pow(distanceX, 2.0) + Math.pow(distanceY, 2.0), 1.0 / 2.0);

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
		double clusterSize = new Integer(clusterGroup.size());

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