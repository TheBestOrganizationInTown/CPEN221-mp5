package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;
import java.util.List;

// TODO: Use this class to represent a restaurant.
// State the rep invariant and abs

public class Restaurant {
    private String business_id;
    private String name;
    private boolean open;
    private String url;
    private List<String> categories = new ArrayList<String>();
    private double latitude;
    private double longitude;
    private List<String> neighborhoods = new ArrayList<String>();
    private String state;
    private double stars;
    private String city;
    private String address;
    private long reviewCount;
    private String photoURL;
    private List<String> schools = new ArrayList<String>();
    private long price;
    private String type = "business";

    /**
     * Constructs a Restaurant object.
     * 
     * @param business_id
     * @param name
     * @param open
     * @param url
     * @param categories
     * @param latitude
     * @param longitude
     * @param neighborhoods
     * @param state
     * @param stars
     * @param city
     * @param address
     * @param reviewCount
     * @param photoURL
     * @param schools
     * @param price
     * 
     * @rep invariant: none of the fields change except review count, which only
     *      increases when a new review is added
     * @abs contains private fields for each parameter
     */

    public Restaurant(String business_id, String name, boolean open, String url, List<String> categories,
            double latitude, double longitude, List<String> neighborhoods, String state, double stars, String city,
            String address, long reviewCount, String photoURL, List<String> schools, long price) {
        this.business_id = business_id;
        this.name = name;
        this.open = open;
        this.url = url;
        this.categories = categories;
        this.latitude = latitude;
        this.longitude = longitude;
        this.neighborhoods = neighborhoods;
        this.state = state;
        this.stars = stars;
        this.city = city;
        this.address = address;
        this.reviewCount = reviewCount;
        this.photoURL = photoURL;
        this.schools = schools;
        this.price = price;

    }

    // getter methods

    public String getBusinessID() {
        return new String(business_id);
    }

    public String getName() {
        return new String(name);
    }

    public boolean getOpen() {
        return open;
    }

    public String getURL() {
        return new String(url);
    }

    public List<String> getCategories() {
        return new ArrayList<String>(categories);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<String> getNeighborhoods() {
        return new ArrayList<String>(neighborhoods);
    }

    public String getState() {
        return new String(state);
    }

    public double getStars() {
        return new Double(stars);
    }

    public String getCity() {
        return new String(city);
    }

    public String getAddress() {
        return new String(address);
    }

    public long getReviewCount() {
        return reviewCount;
    }

    public String getPhotoURL() {
        return new String(photoURL);
    }

    public List<String> getSchools() {
        return new ArrayList<String>(schools);
    }

    public long getPrice() {
        return price;
    }

    public String getType() {
        return new String(type);
    }
    // methods for editing

    public void addReviewCount() {
        reviewCount++;
    }

}
