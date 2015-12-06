package ca.ece.ubc.cpen221.mp5;

// TODO: Use this class to represent a Yelp user.

public class User {
    private final String user_id;
    private String name;
    private final String url;
    private Integer reviewCount = 0;
    private Double averageStars = 0.0;
    private Integer funnyVotes = 0;
    private Integer coolVotes = 0;
    private Integer usefulVotes = 0;
    private String type = "user";

    /**
     * Constructs a user object.
     * 
     * @param user_id
     * @param name
     * @param url
     * @param reviewCount
     * @param averageStars
     * @param funnyVotes
     * @param coolVotes
     * @param usefulVotes
     */
    public User(String user_id, String name, String url, Integer reviewCount, Double averageStars, Integer funnyVotes,
            Integer coolVotes, Integer usefulVotes) {
        this.user_id = user_id;
        this.name = name;
        this.url = url;
        this.reviewCount = reviewCount;
        this.averageStars = averageStars;
        this.funnyVotes = funnyVotes;
        this.coolVotes = coolVotes;
        this.usefulVotes = usefulVotes;
    }
    
    //getter methods
    
    public String getUserID() {
        return new String(user_id);
    }

    public String getName() {
        return new String(name);
    }

    public String getURL() {
        return new String(url);
    }

    public Integer getReviewCount() {
        return new Integer(reviewCount);
    }

    public Double getAverageStars() {
        return new Double(averageStars);
    }

    public Integer getFunnyVotes() {
        return new Integer(funnyVotes);
    }

    public Integer getCoolVotes() {
        return new Integer(coolVotes);
    }

    public Integer getUsefulVotes() {
        return new Integer(usefulVotes);
    }

    public String getType() {
        return new String(type);
    }
    
    //methods for editing a user
    
    public void addFunnyVote() {
        funnyVotes++;
    }

    public void addCoolVote() {
        coolVotes++;
    }

    public void addUsefulVote() {
        usefulVotes++;
    }

    public void increaseReviewCount() {
        reviewCount++;
    }

    /**
     * Calculates the new value for averageStars. Must be done before the new
     * review is added to the reviewCount. Does not modify reviewCount.
     * 
     * @param rating
     *            The rating given in the new review
     * @modifies averageStars: calculates the new averageStars and replaces the
     *           old average with the new one
     */
    public void recalculateAverageStars(int rating) {
        Double totalStars = averageStars * reviewCount;
        Double newTotalStars = totalStars + rating;
        averageStars = newTotalStars / (reviewCount + 1);
    }

    public void changeName(String newName) {
        this.name = newName;

    }


}
