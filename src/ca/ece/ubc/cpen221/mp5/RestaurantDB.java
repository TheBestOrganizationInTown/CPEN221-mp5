package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import ca.ece.ubc.cpen221.mp5.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// TODO: This class represents the Restaurant Database.
// Define the internal representation and 
// state the rep invariant and the abstraction function.

public class RestaurantDB {
    private Map<String, User> users = new Hashtable<String, User>();
    private final Map<String, Review> reviews = new Hashtable<String, Review>();
    private final Map<String, Restaurant> restaurants = new Hashtable<String, Restaurant>();

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
    }

    public Set<Restaurant> query(String queryString) {
        // TODO: Implement this method
        // Write specs, etc.
        return null;
    }

    private Map<String, User> processUserFile(String usersJSONfilename) {
        Map<String, User> userMap = new Hashtable<String, User>();
        JSONParser parser = new JSONParser();
        
        BufferedReader userFile;
        try {
            userFile = new BufferedReader(new FileReader(usersJSONfilename));
            try {
                while(userFile.ready()){
                Object obj = parser.parse(userFile.readLine());

                JSONObject jsonObject = (JSONObject) obj;


                String userID = (String) jsonObject.get("userID");
                String name = (String) jsonObject.get("name");
                String url = (String) jsonObject.get("url");
                Integer reviewCount = (Integer) jsonObject.get("reviewCount");
                Double averageStars = (Double) jsonObject.get("averageStars");
                Integer funnyVotes = (Integer) jsonObject.get("funnyVotes");
                Integer coolVotes = (Integer) jsonObject.get("coolVotes");
                Integer usefulVotes = (Integer) jsonObject.get("usefulVotes");

                
                User user = new User(userID, name, url, reviewCount, averageStars, funnyVotes,
                        coolVotes, usefulVotes);
                userMap.put(userID, user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
        return userMap;
    }

    private User createUserFromJSONText(JSONObject text) {

        return user;

    }

    private Map<String, Review> processReviewFile(String reviewsJSONfilename) {
        Map<String, Review> reviewMap = new Hashtable<String, Review>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new BufferedReader(new FileReader(reviewsJSONfilename)).readLine());

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            String city = (String) jsonObject.get("city");
            ArrayList<String> listOfCategories = new ArrayList<String>();
            JSONArray categories = (JSONArray) jsonObject.get("categories");
            String userID = (String) jsonObject.get("userID");
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
        return reviewMap;
    }

    private Map<String, Restaurant> processRestaurantFile(String restaurantJSONfilename) {
        Map<String, Restaurant> restaurantMap = new Hashtable<String, Restaurant>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new BufferedReader(new FileReader(restaurantJSONfilename)).readLine());

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            String city = (String) jsonObject.get("city");
            JSONArray categories = (JSONArray) jsonObject.get("categories");
            String userID = (String) jsonObject.get("userID");
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
        return restaurantMap;
    }

}
