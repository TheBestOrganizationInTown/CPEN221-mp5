package ca.ece.ubc.cpen221.mp5;

// TODO: Use this class to represent a Yelp user.

public class User {
    private final String userID;
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
 * @param userID
 * @param name
 * @param url
 * @param reviewCount
 * @param averageStars
 * @param funnyVotes
 * @param coolVotes
 * @param usefulVotes
 */
    public User(String userID, String name, String url, Integer reviewCount, Double averageStars, Integer funnyVotes,
            Integer coolVotes, Integer usefulVotes) {
        this.userID = userID;
        this.name = name;
        this.url = url;
        this.reviewCount = reviewCount;
        this.averageStars = averageStars;
        this.funnyVotes = funnyVotes;
        this.coolVotes = coolVotes;
        this.usefulVotes = usefulVotes;
    }

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
