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

public class RestaurantDBTest {

    @Test
    public void shouldCreateUser() {
       User user = new User("_NH7Cpq3qZkByP5xR4gXog", "Chris M.", "http://www.yelp.com/user_details?userid=_NH7Cpq3qZkByP5xR4gXog", 29, 3.89655172413793, 35, 14, 21);
       Map<String, User> map = processUserFile("/Users/RCastro/workspace/CPEN221-mp5/data/users.json");
       assert(user == map.get("_NH7Cpq3qZkByP5xR4gXog"));
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

