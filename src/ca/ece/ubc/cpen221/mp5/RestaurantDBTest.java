package ca.ece.ubc.cpen221.mp5;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class RestaurantDBTest {

    @Test
    public void shouldCreateUser() {

        ArrayList<User> list = RestaurantDB
                .processUserFile("/Users/danger/Documents/workspace/CPEN221-mp5/data/users.json");

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getName().equals("Keno F.")) {
                assert(list.get(i).getFunnyVotes() == 3);
                assert(list.get(i).getCoolVotes() == 0);
                assert(list.get(i).getUsefulVotes() == 10);
                assert(list.get(i).getAverageStars() == 3.0);
                assert(list.get(i).getReviewCount() == 9);
                assert(list.get(i).getURL().equals("http://www.yelp.com/user_details?userid=klPQS2Scpq-jLFdLKKlsBQ"));
                assert(list.get(i).getUserID().equals("klPQS2Scpq-jLFdLKKlsBQ"));
            }
        }
        assert(list.get(0).getName().equals("Chris M."));
        assert(list.get(0).getFunnyVotes() == 35);
        assert(list.get(0).getUsefulVotes() == 21);
        assert(list.get(0).getCoolVotes() == 14);
        assert(list.get(0).getAverageStars() == 3.89655172413793);
        assert(list.get(0).getReviewCount() == 29);
        assert(list.get(0).getURL().equals("http://www.yelp.com/user_details?userid=_NH7Cpq3qZkByP5xR4gXog"));
        assert(list.get(0).getUserID().equals("_NH7Cpq3qZkByP5xR4gXog"));

        assert(list.get(8537).getName().equals("Garry S."));
        assert(list.get(8537).getFunnyVotes() == 1);
        assert(list.get(8537).getUsefulVotes() == 11);
        assert(list.get(8537).getCoolVotes() == 5);
        assert(list.get(8537).getAverageStars() == 3.94444444444444);
        assert(list.get(8537).getReviewCount() == 18);
        assert(list.get(8537).getURL().equals("http://www.yelp.com/user_details?userid=jTmBLesNgGzPy9qA9m6vfA"));
        assert(list.get(8537).getUserID().equals("jTmBLesNgGzPy9qA9m6vfA"));

        assert(list.get(8555).getName().equals("Alex M."));
        assert(list.get(8555).getFunnyVotes() == 11);
        assert(list.get(8555).getCoolVotes() == 7);
        assert(list.get(8555).getUsefulVotes() == 24);
        assert(list.get(8555).getAverageStars() == 3.47727272727273);
        assert(list.get(8555).getReviewCount() == 44);
        assert(list.get(8555).getURL().equals("http://www.yelp.com/user_details?userid=CmAd1cga_XQKdn1onMHtmQ"));
        assert(list.get(8555).getUserID().equals("CmAd1cga_XQKdn1onMHtmQ"));

    }
}
