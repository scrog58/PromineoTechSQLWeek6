package entity;

import java.util.List;

public class Restaurants {
	private int restaurantId;
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantCity;
	private String restaurantState;
	private List<RestaurantCategory> restaurantcategory;
	
	public Restaurants(int restaurantId, String restaurantName, List<RestaurantCategory> restaurantcategory) {
		this.setRestaurantId(restaurantId);
		this.setRestaurantName(restaurantName);
		this.setRestaurantcategory(restaurantcategory);
		
	}
	
	
	public Restaurants(int restaurantId, String restaurantName, String restaurantState) {
		this.setRestaurantId(restaurantId);
		this.setRestaurantName(restaurantName);
		this.setRestaurantState(restaurantState);
		
	}
	

	
	public Restaurants(int restaurantId, String restaurantName) {
		this.setRestaurantId(restaurantId);
		this.setRestaurantName(restaurantName);
		
	}
	
	public Restaurants(int restaurantId, String restaurantName,String  restaurantAddress, String restaurantCity, String restaurantState) {
		this.setRestaurantId(restaurantId);
		this.setRestaurantName(restaurantName);
		this.setRestaurantAddress(restaurantAddress);
		this.setRestaurantCity(restaurantCity);
		this.setRestaurantState(restaurantState);
		
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getRestaurantCity() {
		return restaurantCity;
	}

	public void setRestaurantCity(String restaurantCity) {
		this.restaurantCity = restaurantCity;
	}

	public String getRestaurantState() {
		return restaurantState;
	}

	public void setRestaurantState(String restaurantState) {
		this.restaurantState = restaurantState;
	}
	
	public List<RestaurantCategory> getRestaurantCategory() {
		return restaurantcategory;
	}

	public void setRestaurantcategory(List<RestaurantCategory> restaurantcategory) {
		this.restaurantcategory = restaurantcategory;
	}

}
