package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;
import java.util.List;

// TODO: Use this class to represent a restaurant.
// State the rep invariant and abs

public class Restaurant {
    private boolean open;
    private List<String> categories = new ArrayList<String>();
    private String businessID;
    private String url;
    private double latitude;
    private double longitude;
    private List<String> neighborhoods = new ArrayList<String>();
    private String name;
    private String state;
    private String type = "business";
    private double stars;
    private String city;
    private String address;
    private int reviewCount;
    private String photoURL;
    private String schools;
    private int price;

    public void addCategory(String category) {
        categories.add(category);
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setBusinessID(String businessID) {
        this.businessID = businessID;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void addNeighborhood(String neighborhood) {
        neighborhoods.add(neighborhood);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void addReviewCount() {
        reviewCount++;
    }

    public void setPhotoUrl(String photoURL) {
        this.photoURL = photoURL;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
