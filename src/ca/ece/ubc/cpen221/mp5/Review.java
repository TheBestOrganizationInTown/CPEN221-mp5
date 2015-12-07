package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;

// TODO: Use this class to represent a Yelp review.

public class Review {
    private final String review_id;
    private final String business_id;
    private String text;
    private long funnyVotes = 0;
    private long coolVotes = 0;
    private long usefulVotes = 0;
    private long stars;
    private String user_id;
    private String date;
    private String type = "review";

    /**
     * Constructs a Review object.
     * 
     * @param review_id
     * @param business_id
     * @param text
     * @param funnyVotes
     * @param coolVotes
     * @param usefulVotes
     * @param stars
     * @param user_id
     * @param date
     */
    public Review(String review_id, String business_id, String text, long funnyVotes, long coolVotes,
            long usefulVotes, long stars, String user_id, String date) {
        this.review_id = review_id;
        this.business_id = business_id;
        this.text = text;
        this.funnyVotes = funnyVotes;
        this.coolVotes = coolVotes;
        this.usefulVotes = usefulVotes;
        this.stars = stars;
        this.user_id = user_id;
        this.date = date;

    }
   
    //getter methods
    
    public String getReviewID() {
        return new String(review_id);
    }

    public String getBusinessID() {
        return new String(business_id);
    }

    public String getText() {
        return new String(text);
    }

    public long getFunnyVotes() {
        return funnyVotes;
    }

    public long getCoolVotes() {
        return coolVotes;
    }

    public long getUsefulVotes() {
        return usefulVotes;
    }

    public long getStars() {
        return stars;
    }

    public String getUserID() {
        return new String(user_id);
    }

    public String getDate() {
        return new String(date);
    }

    public String getType() {
        return new String(type);
    }

//methods for editing reviews 
    
    public void addFunnyVote() {
        funnyVotes++;
    }

    public void addCoolVote() {
        coolVotes++;
    }

    public void addUsefulVote() {
        usefulVotes++;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

}