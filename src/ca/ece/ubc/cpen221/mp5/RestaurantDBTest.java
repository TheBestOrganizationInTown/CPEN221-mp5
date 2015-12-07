package ca.ece.ubc.cpen221.mp5;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class RestaurantDBTest {
    String restaurantFile = "/Users/danger/Documents/workspace/CPEN221-mp5/data/restaurants.json";
    String reviewFile = "/Users/danger/Documents/workspace/CPEN221-mp5/data/reviews.json";
    String userFile = "/Users/danger/Documents/workspace/CPEN221-mp5/data/users.json";

    @Test

    public void shouldCreateUsers() {

        RestaurantDB database = new RestaurantDB(restaurantFile, reviewFile, userFile);
        ArrayList<User> users = database.getUsers();

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getName().equals("Keno F.")) {
                assert(users.get(i).getFunnyVotes() == 3);
                assert(users.get(i).getCoolVotes() == 0);
                assert(users.get(i).getUsefulVotes() == 10);
                assert(users.get(i).getAverageStars() == 3.0);
                assert(users.get(i).getReviewCount() == 9);
                assert(users.get(i).getURL().equals("http://www.yelp.com/user_details?userid=klPQS2Scpq-jLFdLKKlsBQ"));
                assert(users.get(i).getUserID().equals("klPQS2Scpq-jLFdLKKlsBQ"));
            }
        }
        assert(users.get(0).getName().equals("Chris M."));
        assert(users.get(0).getFunnyVotes() == 35);
        assert(users.get(0).getUsefulVotes() == 21);
        assert(users.get(0).getCoolVotes() == 14);
        assert(users.get(0).getAverageStars() == 3.89655172413793);
        assert(users.get(0).getReviewCount() == 29);
        assert(users.get(0).getURL().equals("http://www.yelp.com/user_details?userid=_NH7Cpq3qZkByP5xR4gXog"));
        assert(users.get(0).getUserID().equals("_NH7Cpq3qZkByP5xR4gXog"));

        assert(users.get(8537).getName().equals("Garry S."));
        assert(users.get(8537).getFunnyVotes() == 1);
        assert(users.get(8537).getUsefulVotes() == 11);
        assert(users.get(8537).getCoolVotes() == 5);
        assert(users.get(8537).getAverageStars() == 3.94444444444444);
        assert(users.get(8537).getReviewCount() == 18);
        assert(users.get(8537).getURL().equals("http://www.yelp.com/user_details?userid=jTmBLesNgGzPy9qA9m6vfA"));
        assert(users.get(8537).getUserID().equals("jTmBLesNgGzPy9qA9m6vfA"));

        assert(users.get(8555).getName().equals("Alex M."));
        assert(users.get(8555).getFunnyVotes() == 11);
        assert(users.get(8555).getCoolVotes() == 7);
        assert(users.get(8555).getUsefulVotes() == 24);
        assert(users.get(8555).getAverageStars() == 3.47727272727273);
        assert(users.get(8555).getReviewCount() == 44);
        assert(users.get(8555).getURL().equals("http://www.yelp.com/user_details?userid=CmAd1cga_XQKdn1onMHtmQ"));
        assert(users.get(8555).getUserID().equals("CmAd1cga_XQKdn1onMHtmQ"));
    }

    @Test
    public void shouldCreateRestaurants() {

        RestaurantDB database = new RestaurantDB(restaurantFile, reviewFile, userFile);
        ArrayList<Restaurant> restaurants = database.getRestaurants();

        for (int i = 0; i < restaurants.size(); i++) {

            if (restaurants.get(i).getName().equals("The Little Dipper Chocolate Company")) {
                assert(restaurants.get(i).getOpen());
                assert(restaurants.get(i).getURL()
                        .equals("http://www.yelp.com/biz/the-little-dipper-chocolate-company-berkeley"));
                assert(restaurants.get(i).getBusinessID().equals("EAafCOFtOjTDq7WNwHFn7A"));
                assert(restaurants.get(i).getCategories().size() == 4);
                assert(restaurants.get(i).getCategories().get(0).equals("Food"));
                assert(restaurants.get(i).getCategories().get(1).equals("Desserts"));
                assert(restaurants.get(i).getCategories().get(2).equals("Food Stands"));
                assert(restaurants.get(i).getCategories().get(3).equals("Restaurants"));
                assert(restaurants.get(i).getLatitude() == 37.868725);
                assert(restaurants.get(i).getLongitude() == -122.2591719);
                assert(restaurants.get(i).getNeighborhoods().size() == 2);
                assert(restaurants.get(i).getNeighborhoods().get(0).equals("Telegraph Ave"));
                assert(restaurants.get(i).getNeighborhoods().get(1).equals("UC Campus Area"));
                assert(restaurants.get(i).getState().equals("CA"));
                assert(restaurants.get(i).getStars() == 3.5);
                assert(restaurants.get(i).getCity().equals("Berkeley"));
                assert(restaurants.get(i).getAddress().equals("Bancroft and Telegraph\nTelegraph Ave\nBerkeley, CA 94704"));
                assert(restaurants.get(i).getPhotoURL().equals(
                        "http://s3-media1.ak.yelpcdn.com/assets/2/www/img/924a6444ca6c/gfx/blank_biz_medium.gif"));
                assert(restaurants.get(i).getSchools().size() == 1);
                assert(restaurants.get(i).getSchools().get(0).equals("University of California at Berkeley"));
                assert(restaurants.get(i).getPrice() == 1);
                assert(restaurants.get(i).getReviewCount() == 3);

            }

            if (restaurants.get(i).getName().equals("Cheese 'N' Stuff")) {
                assert(restaurants.get(i).getOpen());
                assert(restaurants.get(i).getURL().equals("http://www.yelp.com/biz/cheese-n-stuff-berkeley"));
                assert(restaurants.get(i).getBusinessID().equals("o0KC5k-7fXH8LHf75Icfuw"));
                assert(restaurants.get(i).getCategories().size() == 3);
                assert(restaurants.get(i).getCategories().get(0).equals("Delis"));
                assert(restaurants.get(i).getCategories().get(1).equals("Sandwiches"));
                assert(restaurants.get(i).getCategories().get(2).equals("Restaurants"));
                assert(restaurants.get(i).getLatitude() == 37.8677205);
                assert(restaurants.get(i).getLongitude() == -122.2595445);
                assert(restaurants.get(i).getNeighborhoods().size() == 2);
                assert(restaurants.get(i).getNeighborhoods().get(0).equals("Telegraph Ave"));
                assert(restaurants.get(i).getNeighborhoods().get(1).equals("UC Campus Area"));
                assert(restaurants.get(i).getState().equals("CA"));
                assert(restaurants.get(i).getStars() == 4.0);
                assert(restaurants.get(i).getCity().equals("Berkeley"));
                assert(restaurants.get(i).getAddress().equals("2442 Durant Ave\nTelegraph Ave\nBerkeley, CA 94704"));
                assert(restaurants.get(i).getPhotoURL()
                        .equals("http://s3-media2.ak.yelpcdn.com/bphoto/nw7klTdCtY0cuDCf7hYScw/ms.jpg"));
                assert(restaurants.get(i).getSchools().size() == 1);
                assert(restaurants.get(i).getSchools().get(0).equals("University of California at Berkeley"));
                assert(restaurants.get(i).getPrice() == 1);
                assert(restaurants.get(i).getReviewCount() == 161);
            }
        }

        assert(restaurants.get(0).getName().equals("Cafe 3"));
        assert(restaurants.get(0).getOpen());
        assert(restaurants.get(0).getURL().equals("http://www.yelp.com/biz/cafe-3-berkeley"));
        assert(restaurants.get(0).getBusinessID().equals("gclB3ED6uk6viWlolSb_uA"));
        assert(restaurants.get(0).getCategories().size() == 2);
        assert(restaurants.get(0).getCategories().get(0).equals("Cafes"));
        assert(restaurants.get(0).getCategories().get(1).equals("Restaurants"));
        assert(restaurants.get(0).getLatitude() == 37.867417);
        assert(restaurants.get(0).getLongitude() == -122.260408);
        assert(restaurants.get(0).getNeighborhoods().size() == 2);
        assert(restaurants.get(0).getNeighborhoods().get(0).equals("Telegraph Ave"));
        assert(restaurants.get(0).getNeighborhoods().get(1).equals("UC Campus Area"));
        assert(restaurants.get(0).getState().equals("CA"));
        assert(restaurants.get(0).getStars() == 2.0);
        assert(restaurants.get(0).getCity().equals("Berkeley"));
        assert(restaurants.get(0).getAddress().equals("2400 Durant Ave\nTelegraph Ave\nBerkeley, CA 94701"));
        assert(restaurants.get(0).getPhotoURL()
                .equals("http://s3-media1.ak.yelpcdn.com/bphoto/AaHq1UzXiT6zDBUYrJ2NKA/ms.jpg"));
        assert(restaurants.get(0).getSchools().size() == 1);
        assert(restaurants.get(0).getSchools().get(0).equals("University of California at Berkeley"));
        assert(restaurants.get(0).getPrice() == 1);
        assert(restaurants.get(0).getReviewCount() == 9);

        assert(restaurants.get(77).getName().equals("Ramona's Caf\u00e9"));
        assert(restaurants.get(77).getOpen());
        assert(restaurants.get(77).getURL().equals("http://www.yelp.com/biz/ramonas-caf%C3%A9-berkeley-2"));
        assert(restaurants.get(77).getBusinessID().equals("8oUiRpdbLzqNKrBTGyBkZw"));
        assert(restaurants.get(77).getCategories().size() == 4);
        assert(restaurants.get(77).getCategories().get(0).equals("Food"));
        assert(restaurants.get(77).getCategories().get(1).equals("Coffee & Tea"));
        assert(restaurants.get(77).getCategories().get(2).equals("Sandwiches"));
        assert(restaurants.get(77).getCategories().get(3).equals("Restaurants"));
        assert(restaurants.get(77).getLatitude() == 37.8705256863629);
        assert(restaurants.get(77).getLongitude() == -122.254925966263);
        assert(restaurants.get(77).getNeighborhoods().size() == 1);
        assert(restaurants.get(77).getNeighborhoods().get(0).equals("UC Campus Area"));
        assert(restaurants.get(77).getState().equals("CA"));
        assert(restaurants.get(77).getStars() == 3.0);
        assert(restaurants.get(77).getCity().equals("Berkeley"));
        assert(restaurants.get(77).getAddress()
                .equals("UC Berkeley Campus\nWurster Hall\nUC Campus Area\nBerkeley, CA 94720"));
        assert(restaurants.get(77).getPhotoURL()
                .equals("http://s3-media2.ak.yelpcdn.com/bphoto/ecHj_-2xQjtzhBB5opKAoQ/ms.jpg"));
        assert(restaurants.get(77).getSchools().size() == 1);
        assert(restaurants.get(77).getSchools().get(0).equals("University of California at Berkeley"));
        assert(restaurants.get(77).getPrice() == 1);
        assert(restaurants.get(77).getReviewCount() == 15);

        assert(restaurants.get(134).getName().equals("La Fiesta Mexican Restaurant"));
        assert(restaurants.get(134).getOpen());
        assert(restaurants.get(134).getURL().equals("http://www.yelp.com/biz/la-fiesta-mexican-restaurant-berkeley"));
        assert(restaurants.get(134).getBusinessID().equals("zqcTeWwRe7HjbwDaWJGjCw"));
        assert(restaurants.get(134).getCategories().size() == 2);
        assert(restaurants.get(134).getCategories().get(0).equals("Mexican"));
        assert(restaurants.get(134).getCategories().get(1).equals("Restaurants"));
        assert(restaurants.get(134).getLatitude() == 37.865831);
        assert(restaurants.get(134).getLongitude() == -122.25802);
        assert(restaurants.get(134).getNeighborhoods().size() == 2);
        assert(restaurants.get(134).getNeighborhoods().get(0).equals("Telegraph Ave"));
        assert(restaurants.get(134).getNeighborhoods().get(1).equals("UC Campus Area"));
        assert(restaurants.get(134).getState().equals("CA"));
        assert(restaurants.get(134).getStars() == 4.0);
        assert(restaurants.get(134).getCity().equals("Berkeley"));
        assert(restaurants.get(134).getAddress().equals("2506 Haste Street\nTelegraph Ave\nBerkeley, CA 94704"));
        assert(restaurants.get(134).getPhotoURL()
                .equals("http://s3-media4.ak.yelpcdn.com/bphoto/Oc_K478igogZHKwvBjBc8g/ms.jpg"));
        assert(restaurants.get(134).getSchools().size() == 1);
        assert(restaurants.get(134).getSchools().get(0).equals("University of California at Berkeley"));
        assert(restaurants.get(134).getPrice() == 1);
        assert(restaurants.get(134).getReviewCount() == 6);

    }

    @Test

    public void shouldMakeCopy() {
        RestaurantDB database = new RestaurantDB(restaurantFile, reviewFile, userFile);
        System.out.println(database.getRestaurants() + "test");

    }
}
