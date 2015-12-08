package ca.ece.ubc.cpen221.mp5.statlearning;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;
import java.util.*;

public class CategoryFeature implements MP5Function {

	@Override
	public double f(Restaurant yelpRestaurant, RestaurantDB db) {
		Map<String, Integer> categoryMap = new HashMap<String, Integer>();
		List<Restaurant> restaurantList = db.getRestaurants();
		int categoryNumber = 0;
		Iterator<Restaurant> iterator = restaurantList.iterator();
		Restaurant currentRestaurant;
		List<String> categoryList = new ArrayList<String>();
		
		double categorySummation = 0.0;
		
		while(iterator.hasNext()){
			currentRestaurant = iterator.next();
			categoryList = currentRestaurant.getCategories();
			for(int i = 0; i < categoryList.size(); i++){
				if(!categoryMap.containsKey(categoryList.get(i)));{
					categoryMap.put(categoryList.get(i), categoryNumber);
					categoryNumber++;
				}
			}
		}
		
		categoryList = yelpRestaurant.getCategories();
		for(int i = 0; i < categoryList.size(); i++){
			categorySummation += categoryMap.get(categoryList.get(i));
		}
		
		return categorySummation;
	}

}
