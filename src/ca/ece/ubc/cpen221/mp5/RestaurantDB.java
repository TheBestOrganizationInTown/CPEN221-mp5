package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import ca.ece.ubc.cpen221.mp5.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// TODO: This class represents the Restaurant Database.
// Define the internal representation and 
// state the rep invariant and the abstraction function.

public class RestaurantDB {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Review> reviews = new ArrayList<Review>();
    private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    /**
     * Create a database from the Yelp dataset given the names of three files:
     * <ul>
     * <li>One that contains data about the restaurants;</li>
     * <li>One that contains reviews of the restaurants;</li>
     * <li>One that contains information about the users that submitted reviews.
     * </li>
     * </ul>
     * The files contain data in JSON format.
     * 
     * @param restaurantJSONfilename
     *            the filename for the restaurant data
     * @param reviewsJSONfilename
     *            the filename for the reviews
     * @param usersJSONfilename
     *            the filename for the users
     */
    public RestaurantDB(String restaurantJSONfilename, String reviewsJSONfilename, String usersJSONfilename) {
        users = processUserFile(usersJSONfilename);
        reviews = processReviewFile(reviewsJSONfilename);
        restaurants = processRestaurantFile(restaurantJSONfilename);
    }

    public Set<Restaurant> query(String queryString) {
        // TODO: Implement this method
        // Write specs, etc.
        return null;
    }

    public static ArrayList<User> processUserFile(String usersJSONfilename) {
        ArrayList<User> userList = new ArrayList<User>();
        JSONParser parser = new JSONParser();

        BufferedReader userFile;
        try {
            userFile = new BufferedReader(new FileReader(usersJSONfilename));
            try {
                while (userFile.ready()) {
                    Object obj = parser.parse(userFile.readLine());

                    JSONObject jsonObject = (JSONObject) obj;

                    String user_id = (String) jsonObject.get("user_id");
                    String name = (String) jsonObject.get("name");
                    String url = (String) jsonObject.get("url");
                    long reviewCount = (long) jsonObject.get("review_count");
                    Double averageStars = (Double) jsonObject.get("average_stars");
                    JSONObject listOfVotes = (JSONObject) jsonObject.get("votes");

                    long funnyVotes = (long) listOfVotes.get("funny");
                    long usefulVotes = (long) listOfVotes.get("useful");
                    long coolVotes = (long) listOfVotes.get("cool");

                    User user = new User(user_id, name, url, reviewCount, averageStars, funnyVotes, coolVotes,
                            usefulVotes);
                    userList.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return userList;
    }

    private User createUserFromJSONText(JSONObject text) {

        User user = null;
        return user;

    }

    private ArrayList<Review> processReviewFile(String reviewsJSONfilename) {
        ArrayList<Review> reviewList = new ArrayList<Review>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new BufferedReader(new FileReader(reviewsJSONfilename)).readLine());

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            String city = (String) jsonObject.get("city");
            ArrayList<String> listOfCategories = new ArrayList<String>();
            JSONArray categories = (JSONArray) jsonObject.get("categories");
            String user_id = (String) jsonObject.get("user_id");
            String url = (String) jsonObject.get("url");
            Integer reviewCount = (Integer) jsonObject.get("reviewCount");
            Double averageStars = (Double) jsonObject.get("averageStars");
            Integer funnyVotes = (Integer) jsonObject.get("funnyVotes");
            Integer usefulVotes = (Integer) jsonObject.get("usefulVotes");
            Integer coolVotes = (Integer) jsonObject.get("coolVotes");
            String type = (String) jsonObject.get("type");

            Iterator<String> iterator = categories.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewList;
    }

    public static ArrayList<Restaurant> processRestaurantFile(String restaurantJSONfilename) {
        ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
        JSONParser parser = new JSONParser();
        BufferedReader restaurantFile;
        try {
            restaurantFile = new BufferedReader(new FileReader(restaurantJSONfilename));
            try {
                while (restaurantFile.ready()) {
                    Object obj = parser.parse(restaurantFile.readLine());

                    JSONObject jsonObject = (JSONObject) obj;

                    String business_id = (String) jsonObject.get("business_id");
                    String name = (String) jsonObject.get("name");
                    boolean open = (boolean) jsonObject.get("open");
                    String url = (String) jsonObject.get("url");
                    ArrayList<String> listOfCategories = new ArrayList<String>();
                    JSONArray categories = (JSONArray) jsonObject.get("categories");

                    @SuppressWarnings("unchecked")
                    Iterator<String> iteratorC = categories.iterator();
                    while (iteratorC.hasNext()) {
                        listOfCategories.add(iteratorC.next());
                    }

                    Double latitude = (Double) jsonObject.get("latitude");
                    Double longitude = (Double) jsonObject.get("longitude");

                    ArrayList<String> listOfNeighborhoods = new ArrayList<String>();
                    JSONArray neighborhoods = (JSONArray) jsonObject.get("neighborhoods");

                    @SuppressWarnings("unchecked")
                    Iterator<String> iteratorN = neighborhoods.iterator();
                    while (iteratorN.hasNext()) {
                        listOfNeighborhoods.add(iteratorN.next());
                    }

                    String state = (String) jsonObject.get("state");
                    Double stars = (Double) jsonObject.get("stars");
                    String city = (String) jsonObject.get("city");
                    String address = (String) jsonObject.get("full_address");
                    long reviewCount = (long) jsonObject.get("review_count");
                    String photoURL = (String) jsonObject.get("photo_url");

                    ArrayList<String> listOfSchools = new ArrayList<String>();
                    JSONArray schools = (JSONArray) jsonObject.get("schools");

                    @SuppressWarnings("unchecked")
                    Iterator<String> iteratorS = schools.iterator();
                    while (iteratorS.hasNext()) {
                        listOfSchools.add(iteratorS.next());
                    }

                    long price = (long) jsonObject.get("price");

                    Restaurant restaurant = new Restaurant(business_id, name, open, url, listOfCategories, latitude,
                            longitude, listOfNeighborhoods, state, stars, city, address, reviewCount, photoURL,
                            listOfSchools, price);
                    restaurantList.add(restaurant);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return restaurantList;
    }

}
