package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import ca.ece.ubc.cpen221.mp5.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// TODO: This class represents the Restaurant Database.
// Define the internal representation and 
// state the rep invariant and the abstraction function.

public class RestaurantDB {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Review> reviews = new ArrayList<Review>();
    private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    private String restaurantFile;
    private String reviewFile;
    private String userFile;

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
    public RestaurantDB(String restaurantsJSONfilename, String reviewsJSONfilename, String usersJSONfilename) {
        this.restaurantFile = restaurantsJSONfilename;
        this.reviewFile = reviewsJSONfilename;
        this.userFile = usersJSONfilename;
        users = processUserFile(usersJSONfilename);
        reviews = processReviewFile(reviewsJSONfilename);
        restaurants = processRestaurantFile(restaurantsJSONfilename);
    }

    public Set<Restaurant> query(String queryString) {
        // TODO: Implement this method
        // Write specs, etc.
        return null;
    }

    /**
     * Gets and returns the businessID of the restaurant corresponding to the
     * given name. Returns the ID of the first restaurant with this name that is
     * found in the list. Returns "Not Found" if this restaurant does not exist.
     * 
     * @param restaurantName
     * @return name the businessID of the restaurant, or "Not Found" if it
     *         doesn't exist
     */
    public String getRestaurantsBusinessID(String restaurantName) {
        String businessID = "Not Found";
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().equals(restaurantName)) {
                businessID = restaurants.get(i).getBusinessID();
                break;
            }
        }

        return businessID;
    }

    /**
     * Gets all the reviews corresponding to a certain business and puts them in
     * a list.
     * 
     * @param businessID
     * @return list of all reviews for the given business
     */
    public ArrayList<Review> getRestaurantsReviews(String businessID) {
        ArrayList<Review> list = new ArrayList<Review>();
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getBusinessID().equals(businessID)) {
                list.add(reviews.get(i));
            }
        }
        return list;
    }

    /**
     * To this request, the server should respond by providing a random review
     * (in JSON format) for the restaurant that matches the provided name. If
     * more than one restaurant matches the name then any restaurant that
     * satisfies the match can be selected.
     * 
     * @param restaurantName
     * @return a JSON formatted string containing a random review for the given
     *         restaurant. If no restaurant by this name exists, an empty review
     *         will be returned.
     */
    public String randomReview(String restaurantName) {

        Review review = new Review("empty", "empty", "empty", 0, 0, 0, 0, "empty", "empty");

        // Get the businessID corresponding to the given name
        String businessID = getRestaurantsBusinessID(restaurantName);

        // if this restaurant does not exist, return appropriate string
        if (businessID.equals("Not Found")) {
            String emptyReview = toJSONReviewString(review);
            return emptyReview;
        }

        // if business exists, get all reviews
        ArrayList<Review> list = getRestaurantsReviews(businessID);

        // get random review
        int size = list.size();
        Random random = new Random();
        int index = random.nextInt(size);
        Review randomReview = list.get(index);
        String JSONreview = toJSONReviewString(randomReview);

        return JSONreview;
    }

    public String toJSONReviewString(Review review) {
        Map<String, Object> JSONreview = new LinkedHashMap<String, Object>();
        JSONreview.put("type", review.getType());
        JSONreview.put("business_id", review.getBusinessID());
        Map<String, Object> votes = new LinkedHashMap<String, Object>();
        votes.put("cool", review.getCoolVotes());
        votes.put("useful", review.getUsefulVotes());
        votes.put("funny", review.getFunnyVotes());
        

        JSONreview.put("votes", votes);
        JSONreview.put("review_id", review.getReviewID());
        JSONreview.put("text", review.getText());
        JSONreview.put("stars", review.getStars());
        JSONreview.put("user_id", review.getUserID());
        JSONreview.put("date", review.getDate());

        String jsonText = JSONValue.toJSONString(JSONreview);
        return jsonText;

    }

    public String toJSONRestaurantString(Restaurant restaurant) {
        Map<String, Object> JSONrestaurant = new LinkedHashMap<String, Object>();
        JSONrestaurant.put("open", restaurant.getOpen());
        JSONrestaurant.put("url", restaurant.getURL());
        JSONrestaurant.put("longitude", restaurant.getLongitude());
        JSONrestaurant.put("neighborhoods", restaurant.getNeighborhoods());
        JSONrestaurant.put("business_id", restaurant.getBusinessID());
        JSONrestaurant.put("name", restaurant.getName());
        JSONrestaurant.put("categories", restaurant.getCategories());
        JSONrestaurant.put("state", restaurant.getState());
        JSONrestaurant.put("type", restaurant.getType());
        JSONrestaurant.put("stars", restaurant.getStars());
        JSONrestaurant.put("city", restaurant.getCity());
        JSONrestaurant.put("full_address", restaurant.getAddress());
        JSONrestaurant.put("review_count", restaurant.getReviewCount());
        JSONrestaurant.put("photo_url", restaurant.getPhotoURL());
        JSONrestaurant.put("schools", restaurant.getSchools());
        JSONrestaurant.put("latitude", restaurant.getLatitude());
        JSONrestaurant.put("price", restaurant.getPrice());

        String jsonText = JSONValue.toJSONString(JSONrestaurant);

        return jsonText;
    }

    /**
     * To this request, the server should respond with the restaurant details in
     * JSON format for the restaurant that has the provided business identifier.
     * 
     * @param businessId
     * @return a JSON formatted string containing restaurant details for the
     *         given restaurant. If no restaurant by this name exists, an empty
     *         restaurant will be returned.
     */
    public String getRestaurant(String businessId) {
        Restaurant restaurant = new Restaurant("empty", "empty", false, "empty", null, 0, 0, null, "empty", 0, "empty",
                "empty", 0, "empty", null, 0);
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getBusinessID().equals(businessId)) {
                restaurant = restaurants.get(i);
            }
        }
        String correctRestaurant = toJSONRestaurantString(restaurant);
        return correctRestaurant;
    }

    /**
     * The server should add a new restaurant to the database unless a
     * restaurant with the same name and address is already in the database.
     * 
     * @param JSONrestaurant
     * @return true if the restaurant was added, false otherwise
     */
    public boolean addRestaurant(String JSONrestaurant) {
        boolean added = false;
        JSONParser parser = new JSONParser();
        Object obj;
        try {
            obj = parser.parse(JSONrestaurant);

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

            Restaurant restaurant = new Restaurant(business_id, name, open, url, listOfCategories, latitude, longitude,
                    listOfNeighborhoods, state, stars, city, address, reviewCount, photoURL, listOfSchools, price);
            // check if restaurant is already in database
            boolean restaurantAlreadyExists = false;

            for (int i = 0; i < restaurants.size(); i++) {
                if (restaurants.get(i).getName().equals(restaurant.getName())
                        && restaurants.get(i).getAddress().equals((restaurant.getAddress()))) {
                    restaurantAlreadyExists = true;
                }
            }
            if (!restaurantAlreadyExists) {
                restaurants.add(restaurant);
                added = true;
            }
        } catch (ParseException e) {
            System.out.println("Parse Exception");
            e.printStackTrace();
        }
        return added;
    }

    /**
     * The server should add a new user to the database unless that user is
     * already in the database.
     * 
     * @param JSONuser
     * @return true if the user was added, false otherwise
     */
    public boolean addUser(String JSONuser) {
        boolean added = false;
        JSONParser parser = new JSONParser();
        Object obj;
        try {
            obj = parser.parse(JSONuser);

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

            User user = new User(user_id, name, url, reviewCount, averageStars, funnyVotes, coolVotes, usefulVotes);

            // check if user is already in database
            boolean userAlreadyExists = false;

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getName().equals(user.getName())
                        && users.get(i).getUserID().equals((user.getUserID()))) {
                    userAlreadyExists = true;
                    break;
                }
            }
            if (!userAlreadyExists) {
                users.add(user);
                added = true;
            }
        } catch (ParseException e) {
            System.out.println("Parse Exception User");
            e.printStackTrace();
        }
        return added;
    }

    /**
     * The server should add a new review to the database unless that review is
     * already in the database.
     * 
     * @param JSONreview
     * @return true if the review was added, false otherwise
     */
    public boolean addReview(String JSONreview) {
        boolean added = false;
        JSONParser parser = new JSONParser();
        Object obj;
        try {
            obj = parser.parse(JSONreview);

            JSONObject jsonObject = (JSONObject) obj;

            String review_id = (String) jsonObject.get("review_id");
            String business_id = (String) jsonObject.get("business_id");
            String text = (String) jsonObject.get("text");
            JSONObject listOfVotes = (JSONObject) jsonObject.get("votes");

            long funnyVotes = (long) listOfVotes.get("funny");
            long usefulVotes = (long) listOfVotes.get("useful");
            long coolVotes = (long) listOfVotes.get("cool");

            long stars = (long) jsonObject.get("stars");
            String user_id = (String) jsonObject.get("user_id");
            String date = (String) jsonObject.get("date");

          
            
            Review review = new Review(review_id, business_id, text, funnyVotes, coolVotes, usefulVotes, stars, user_id,
                    date);
            // check if review is already in database
            boolean reviewAlreadyExists = false;
            for (int i = 0; i < reviews.size(); i++) {
                if (reviews.get(i).getReviewID().equals(review.getReviewID())) {
                    reviewAlreadyExists = true;
                    break;
                }
            }
            if (!reviewAlreadyExists) {
                reviews.add(review);
                for (int i = 0; i < users.size(); i++) {
                    // if a review is being added by a current user, that user
                    // should be updated
                    if (users.get(i).getUserID().equals(review.getUserID())) {
                        users.get(i).increaseReviewCount();
                        users.get(i).recalculateAverageStars(review.getStars());
                        users.get(i).addCoolVotes(review.getCoolVotes());
                        users.get(i).addFunnyVotes(review.getFunnyVotes());
                        users.get(i).addUsefulVotes(review.getUsefulVotes());
                    }
                }
                added = true;
            }
        } catch (ParseException e) {
            System.out.println("Parse Exception Review");
            e.printStackTrace();
        }
        return added;
    }

    /**
     * Parses a JSON file and gets all the user information from it, storing the
     * info in a list of User objects.
     * 
     * @param usersJSONfilename
     * @return a list of Users
     */
    private ArrayList<User> processUserFile(String usersJSONfilename) {
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

    /**
     * Parses a JSON file and gets all the review information from it, storing
     * the info in a list of Review objects.
     * 
     * @param usersJSONfilename
     * @return a list of Reviews
     */
    private ArrayList<Review> processReviewFile(String reviewsJSONfilename) {
        ArrayList<Review> reviewList = new ArrayList<Review>();
        JSONParser parser = new JSONParser();
        BufferedReader reviewFile;
        try {
            reviewFile = new BufferedReader(new FileReader(reviewsJSONfilename));
            try {
                while (reviewFile.ready()) {

                    Object obj = parser.parse(reviewFile.readLine());

                    JSONObject jsonObject = (JSONObject) obj;

                    String review_id = (String) jsonObject.get("review_id");
                    String business_id = (String) jsonObject.get("business_id");
                    String text = (String) jsonObject.get("text");

                    JSONObject listOfVotes = (JSONObject) jsonObject.get("votes");

                    long funnyVotes = (long) listOfVotes.get("funny");
                    long usefulVotes = (long) listOfVotes.get("useful");
                    long coolVotes = (long) listOfVotes.get("cool");
                    long stars = (long) jsonObject.get("stars");
                    String user_id = (String) jsonObject.get("user_id");
                    String date = (String) jsonObject.get("date");

                    Review review = new Review(review_id, business_id, text, funnyVotes, coolVotes, usefulVotes, stars,
                            user_id, date);
                    reviewList.add(review);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reviewFile.close();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return reviewList;
    }

    /**
     * Parses a JSON file and gets all the restaurant information from it,
     * storing the info in a list of Restaurant objects.
     * 
     * @param usersJSONfilename
     * @return a list of Restaurants
     */
    private ArrayList<Restaurant> processRestaurantFile(String restaurantJSONfilename) {
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

    /**
     * Creates a list of Restaurants from the database.
     * 
     * @return list of Restaurants in this database
     */
    public ArrayList<Restaurant> getRestaurants() {
        ArrayList<Restaurant> list = processRestaurantFile(restaurantFile);
        return list;
    }

    /**
     * Creates a list of Users from the database.
     * 
     * @return list of Users in this database
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> list = processUserFile(userFile);
        return list;
    }

    /**
     * Creates a list of Reviews from the database.
     * 
     * @return list of Reviews in this database
     */
    public ArrayList<Review> getReviews() {
        ArrayList<Review> list = processReviewFile(reviewFile);
        return list;
    }

}
