package ca.ece.ubc.cpen221.mp5.statlearning;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class PriceScaleFeature implements MP5Function {

	@Override
	public double f(Restaurant yelpRestaurant, RestaurantDB db) {
		long price = yelpRestaurant.getPrice();
		System.out.println(yelpRestaurant.getCategories());
		return price;
	}

}
