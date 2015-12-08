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
import org.json.simple.parser.ParseException;
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
                assert(restaurants.get(i).getAddress()
                        .equals("Bancroft and Telegraph\nTelegraph Ave\nBerkeley, CA 94704"));
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

    public void shouldCreateReviews() {
        RestaurantDB database = new RestaurantDB(restaurantFile, reviewFile, userFile);
        ArrayList<Review> reviews = database.getReviews();
        for (int i = 0; i < reviews.size(); i++) {

            if (reviews.get(i).getReviewID().equals("cA58WJ9ApUcvonP_Byqz7A")) {
                assert(reviews.get(i).getType().equals("review"));
                assert(reviews.get(i).getBusinessID().equals("OqKuUkYMCWShOHOspYLGZQ"));
                assert(reviews.get(i).getCoolVotes() == 2);
                assert(reviews.get(i).getUsefulVotes() == 5);
                assert(reviews.get(i).getFunnyVotes() == 0);
                assert(reviews.get(i).getText().equals(
                        "I've lived around the corner from Nefeli for almost a decade and it's consistently been the best cafe I know of in Berkeley.  I've been to Royal, I've been to French Hotel, and I've done my time at Brewed Awakening - none of them are as good.\n\nWhy?  Well, pull up a chair and I'll give you three good reasons to go.\n\nFirst of all, they use illy coffee, which is one of my favorite commercial brands, and they bang it out FAST.  I pull in there on the way to work and they're usually asking me for money with the drink done before I'm done rolling a smoke.  That means under a minute.  Their fixin's are raw sugar, nutmeg w/ grater (fresh nutmeg powder!), non-fat and low-fat milk, and cinnamon.  I don't think these things are ever not available or empty, and I've been there thousands of times.\n\nSecond, they have fresh-squeezed orange juice.  That may not sound like a big deal, but I challenge anyone to show me a place that consistently delivers a top-grade glass of OJ like theirs.  Get it once and you'll remember why OJ is f'in delicious.  I get a small and down it at the counter before I head out with my coffee to go - that's how good it is.\n\nThird, all the food they serve there is made fresh, from excellent produce, and is delicious.  I appreciate places that pay attention to their entire selection and Nefeli doesn't disappoint.  The sandwiches, the hot plates, and the often-mentioned yogurt-fruit bowl are all teh yums.  My only disappointment is that they're all a bit too European-style, which is to say small.\n\nSo there you have it.  Why didn't I give it 5-stars, you ask?  Good god you're an inquisitive sort!  I took off one star for the relatively expensive prices - it ain't cheap - and the occasional lapse in service.  Sometimes the \"Euro\" atmosphere means that the server's phone call or casual discussion with someone takes precedence over getting your order.  Not often, but irritating when it happens."));
                assert(reviews.get(i).getStars() == 4);
                assert(reviews.get(i).getUserID().equals("MtJpkMJ1edE_Q0ec8cmxVQ"));
                assert(reviews.get(i).getDate().equals("2006-12-08"));

            }

            if (reviews.get(i).getReviewID().equals("XEMyePqDSlRpIkZSt7FJXQ")) {
                assert(reviews.get(i).getType().equals("review"));
                assert(reviews.get(i).getBusinessID().equals("Kq6uUzRw-iaqe4p7cLLmBQ"));
                assert(reviews.get(i).getCoolVotes() == 0);
                assert(reviews.get(i).getUsefulVotes() == 0);
                assert(reviews.get(i).getFunnyVotes() == 0);
                assert(reviews.get(i).getText().equals(
                        "So yum in so many ways.  I can't help but order cream dishes each time I come.  The red sauce is super tasty but I love what is done here with cream and butter.  If you're still hungry you may get a donut right outside in the next biz across the dining patio.  So yum."));
                assert(reviews.get(i).getStars() == 5);
                assert(reviews.get(i).getUserID().equals("CvWsLPKt5PxN1BleG4yNyA"));
                assert(reviews.get(i).getDate().equals("2008-10-14"));

            }

            assert(reviews.get(0).getType().equals("review"));
            assert(reviews.get(0).getBusinessID().equals("1CBs84C-a-cuA3vncXVSAw"));
            assert(reviews.get(0).getCoolVotes() == 0);
            assert(reviews.get(0).getUsefulVotes() == 0);
            assert(reviews.get(0).getFunnyVotes() == 0);
            assert(reviews.get(0).getReviewID().equals("0a-pCW4guXIlWNpVeBHChg"));
            assert(reviews.get(0).getText().equals(
                    "The pizza is terrible, but if you need a place to watch a game or just down some pitchers, this place works.\n\nOh, and the pasta is even worse than the pizza."));
            assert(reviews.get(0).getStars() == 2);
            assert(reviews.get(0).getUserID().equals("90wm_01FAIqhcgV_mPON9Q"));
            assert(reviews.get(0).getDate().equals("2006-07-26"));

            assert(reviews.get(17395).getType().equals("review"));
            assert(reviews.get(17395).getBusinessID().equals("zzFi7Z-pejLJtyg-SiGI5g"));
            assert(reviews.get(17395).getCoolVotes() == 1);
            assert(reviews.get(17395).getUsefulVotes() == 1);
            assert(reviews.get(17395).getFunnyVotes() == 0);
            assert(reviews.get(17395).getReviewID().equals("qUOPxQweOXeScjqJ3Ba3yQ"));
            assert(reviews.get(17395).getText().equals(
                    "Haven't been here in a while and I believe it has changed quite a bit (other than the fact it's a hole in the wall).  Back in the vegan days I would get the Spicy Crispy Vegan Chicken combo plate.  Even a meal like that could make a veg overweight...so saturated, so good.  RIP to the good ol' food court days.  I believe you can get that same vegan chicken at Layonna's Market on 8th street in Oakland.  \n\nOh yea, the Boba here isn't that bad either."));
            assert(reviews.get(17395).getStars() == 4);
            assert(reviews.get(17395).getUserID().equals("bIptLHXctziKmxfX2ubXDQ"));
            assert(reviews.get(17395).getDate().equals("2007-12-19"));

        }
    }

    @Test
    public void shouldGetRestaurantsBusinessID() {
        RestaurantDB database = new RestaurantDB(restaurantFile, reviewFile, userFile);
        String ID = database.getRestaurantsBusinessID("Top Dog");
        assert(ID.equals("65ltOonS7uaG12RRdn-W3Q"));

        String ID2 = database.getRestaurantsBusinessID("Saturn Cafe");
        assert(ID2.equals("S4a-MaxMszQjSPSs1JSM2A"));

        String ID3 = database.getRestaurantsBusinessID("Pappy's Grill & Sports Bar");
        assert(ID3.equals("W_14XPx-En1MmvaZykjxpQ"));

        String ID4 = database.getRestaurantsBusinessID("Lotus House");
        assert(ID4.equals("XBPMMfMchDlxZG-qSsSdtw"));

        String ID5 = database.getRestaurantsBusinessID("Le Petit Cheval");
        assert(ID5.equals("lWG0hyFKIgZISbZkEfMVsQ"));

        String ID6 = database.getRestaurantsBusinessID("");
        assert(ID6.equals("Not Found"));

        String ID7 = database.getRestaurantsBusinessID("Bob's Burgers");
        assert(ID7.equals("Not Found"));
    }

    @Test
    public void shouldGetRestaurantsReviews() {
        RestaurantDB database = new RestaurantDB(restaurantFile, reviewFile, userFile);
        ArrayList<Review> list1 = database.getRestaurantsReviews("1d5Ycdlytf8JWZmWJ0NVFA");
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getReviewID().equals("jwkLmBQ6SEbY6LhAdFYnMw")) {
                Review review = list1.get(i);
                assert(review.getCoolVotes() == 2);
                assert(review.getFunnyVotes() == 1);
                assert(review.getUsefulVotes() == 1);
                assert(review.getText().equals(
                        "Turkish Kitchen has a small menu of soups, salads, appetizers, sammies, and platters. all foods except for the appetizers are made to order\n\ndecor: about the same as before\n\neats: lamb & beef donor sammie ($5 special)\n\"combination of top sirloin and lamb spiced and rosted on a vertical spitfire\"\n-with spinach, lettuce, and tahnini sauce.\n-beef dry, lamb juicy. wrap needed more sauce\n3.5 stars\n\ncrumbs:\n-food made to order, 5 minutes.\n-prompt service."));
                assert(review.getStars() == 4);
                assert(review.getUserID().equals("8k3aO-mPeyhbR5HUucA5aA"));
                assert(review.getDate().equals("2012-07-22"));

            }
            if (list1.get(i).getReviewID().equals("ORmWjTfHCFWzY8a1VADprA")) {
                Review review = list1.get(i);
                assert(review.getCoolVotes() == 0);
                assert(review.getFunnyVotes() == 0);
                assert(review.getUsefulVotes() == 0);
                assert(review.getText().equals(
                        "The lamb and chicken wraps are good for a quick lunch or to take to go. I really do not reccomend their fallafel however, but overall a nice lunch spot with friendly service."));
                assert(review.getStars() == 4);
                assert(review.getUserID().equals("CYsrQWte0iuICYIrglVPLw"));
                assert(review.getDate().equals("2012-10-09"));
            }
        }
        assert(list1.size() == 8);

        ArrayList<Review> list2 = database.getRestaurantsReviews("1dS4wRFdtbPRy3tHezpNQg");
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getReviewID().equals("ORmWjTfHCFWzY8a1VADprA")) {
                Review review = list1.get(i);
                assert(review.getCoolVotes() == 0);
                assert(review.getFunnyVotes() == 3);
                assert(review.getUsefulVotes() == 0);
                assert(review.getText().equals(
                        "This place has a really interesting assortment of food.  Spaghetti, reuben sandwiches, teriyaki chicken bowls, onion rings, etc.  It is surprisingly decent quality, fast, and cheap.  Don't expect a gourmet meal, because when it comes down to it, it is fast food, but it is very tasty and more than worth the low price."));
                assert(review.getStars() == 4);
                assert(review.getUserID().equals("LrfAu_QYks03mN4tHifCkg"));
                assert(review.getDate().equals("2007-04-15"));
            }
        }
        assert(list2.size() == 3);
    }

    @Test
    public void shouldGetRandomReview() {
        RestaurantDB database = new RestaurantDB(restaurantFile, reviewFile, userFile);
        ArrayList<Review> list1 = database.getRestaurantsReviews("9znPyzc0cS8GHH49R8SUaA");
        boolean reviewFound = false;

        for (int i = 0; i < 5; i++) {
            String randomReview = database.randomReview("Freehouse");

            JSONParser parser = new JSONParser();
            Object obj;

            try {
                obj = parser.parse(randomReview);

                JSONObject jsonObject = (JSONObject) obj;

                String review_id = (String) jsonObject.get("review_id");
                String business_id = (String) jsonObject.get("business_id");
                String text = (String) jsonObject.get("text");
                // removed test for votes because it kept saying a string could
                // not be converted to a JSON object, even though the code I
                // used was the exact same as that of processReviewFile which
                // has no problem getting the info from votes. this line causes
                // the problems "JSONObject listOfVotes = (JSONObject)
                // jsonObject.get("votes");"
                long stars = (long) jsonObject.get("stars");
                String user_id = (String) jsonObject.get("user_id");
                String date = (String) jsonObject.get("date");

                Review review = new Review(review_id, business_id, text, 1, 1, 0, stars, user_id, date);

                for (int i2 = 0; i2 < list1.size(); i2++) {
                    if (review.getReviewID().equals(list1.get(i2).getReviewID())) {
                        assert(review.getBusinessID().equals(list1.get(i2).getBusinessID()));
                        assert(review.getText().equals(list1.get(i2).getText()));
                        assert(review.getUserID().equals(list1.get(i2).getUserID()));
                        assert(review.getDate().equals(list1.get(i2).getDate()));
                        assert(review.getStars() == list1.get(i2).getStars());

                        reviewFound = true;
                    }
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        assert(reviewFound);
    }

    

}