package ca.ece.ubc.cpen221.mp5.statlearning;

import ca.ece.ubc.cpen221.mp5.Restaurant;

public class Location {
	private final double latitude;
	private final double longitude;
	
	public Location(Restaurant restaurant){
		this.latitude = restaurant.getLatitude();
		this.longitude = restaurant.getLongitude();
	}
	
	public Location(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude(){
		return new Double(this.latitude);
	}
	
	public double getLongitude(){
		return new Double(this.longitude);
	}
}
