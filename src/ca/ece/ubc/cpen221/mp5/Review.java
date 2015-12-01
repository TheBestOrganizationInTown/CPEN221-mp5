package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;

// TODO: Use this class to represent a Yelp review.

public class Review {
    private String type = "review";
    private Integer funnyVotes = 0;
    private Integer coolVotes = 0;
    private Integer usefulVotes = 0;
    private String text;
    private double stars;
    private String userID;
    private final String businessID;
    private String date;
    private final String reviewID;


    public Review(String reviewID, String businessID) {
        this.reviewID = reviewID;
        this.businessID = businessID;
    }

    public void setFunnyVotes(Integer funnyVotes) {
        this.funnyVotes = funnyVotes;
    }

    public void setCoolVotes(Integer coolVotes) {
        this.coolVotes = coolVotes;
    }

    public void setUsefulVotes(Integer usefulVotes) {
        this.usefulVotes = usefulVotes;
    }

    public void setText(String text) {

    }

    public void setStars(double stars) {

    }

    public void setUserID(String userID) {

    }

    public void setDate(String date) {

    }

}
