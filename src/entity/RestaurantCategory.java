package entity;

public class RestaurantCategory {
	private int restaurantCategoryId;
	private int getRestaurantId;
	private String categoryName;
	//need to make sure you are listing categories with commas not list format
	
	public RestaurantCategory(int restaurantCategoryId, int getRestaurantId, String categoryName) {
		this.setRestaurantCategoryId(restaurantCategoryId);
		this.setGetRestaurantId(getRestaurantId);
		this.setCategoryName(categoryName);
	}
	
	public RestaurantCategory(int restaurantCategoryId, String categoryName) {
		this.setRestaurantCategoryId(restaurantCategoryId);
		this.setCategoryName(categoryName);
	}


	public int getRestaurantCategoryId() {
		return restaurantCategoryId;
	}

	public void setRestaurantCategoryId(int restaurantCategoryId) {
		this.restaurantCategoryId = restaurantCategoryId;
	}

	public int getGetRestaurantId() {
		return getRestaurantId;
	}

	public void setGetRestaurantId(int getRestaurantId) {
		this.getRestaurantId = getRestaurantId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	

}
