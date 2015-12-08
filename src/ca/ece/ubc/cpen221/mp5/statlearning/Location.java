package ca.ece.ubc.cpen221.mp5.statlearning;

import ca.ece.ubc.cpen221.mp5.Restaurant;

public class Location {
    private final double latitude;
    private final double longitude;

    /**
     * Constructs a location object with latitude, and longitude corresponding
     * to restaurant's latitude and longitude.
     * 
     * @param restaurant
     */
    public Location(Restaurant restaurant) {
        this.latitude = restaurant.getLatitude();
        this.longitude = restaurant.getLongitude();
    }

    /**
     * Constructs a location object with latitude, and longitude corresponding
     * to given values.
     * 
     * @param latitude
     * @param longitude
     */
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Return object's latitude trait.
     * 
     * @return double
     */
    public double getLatitude() {
        return new Double(this.latitude);
    }

    /**
     * Return object's longitude trait.
     * 
     * @return double
     */
    public double getLongitude() {
        return new Double(this.longitude);
    }
}
