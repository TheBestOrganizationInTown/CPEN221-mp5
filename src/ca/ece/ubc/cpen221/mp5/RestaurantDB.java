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
    private ArrayList<User> users = new ArrayList<User>();
    private final ArrayList<Review> reviews = new ArrayList<Review>();
    private final ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

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

    private ArrayList<User> processUserFile(String usersJSONfilename) {
        ArrayList<User> userList = new ArrayList<User>();
        JSONParser parser = new JSONParser();
        
        BufferedReader userFile;
        try {
            userFile = new BufferedReader(new FileReader(usersJSONfilename));
            try {
                while(userFile.ready()){
                Object obj = parser.parse(userFile.readLine());

                JSONObject jsonObject = (JSONObject) obj;


                String user_id = (String) jsonObject.get("user_id");
                String name = (String) jsonObject.get("name");
                String url = (String) jsonObject.get("url");
                Integer reviewCount = (Integer) jsonObject.get("reviewCount");
                Double averageStars = (Double) jsonObject.get("averageStars");
                Integer funnyVotes = (Integer) jsonObject.get("funnyVotes");
                Integer coolVotes = (Integer) jsonObject.get("coolVotes");
                Integer usefulVotes = (Integer) jsonObject.get("usefulVotes");

                
                User user = new User(user_id, name, url, reviewCount, averageStars, funnyVotes,
                        coolVotes, usefulVotes);
                userList.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
        return userList;
    }

    private User createUserFromJSONText(JSONObject text) {

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

    private ArrayList<Restaurant> processRestaurantFile(String restaurantJSONfilename) {
        ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
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
        return restaurantList;
    }

}
