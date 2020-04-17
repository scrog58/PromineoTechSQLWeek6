package app;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import DAO.RestaurantDao;
import entity.RestaurantCategory;
import DAO.RestaurantCategoryDao;
import entity.Restaurants;
import entity.RestaurantCategory;

public class RestaurantOptions {
	private Scanner scanner = new Scanner(System.in);
	private RestaurantDao restaurantDao = new RestaurantDao();
	private RestaurantCategoryDao restaurantCategoryDao = new RestaurantCategoryDao();
	private List<String> options = Arrays.asList(
			"List All Restaurants and Info"
			, "List Restaurant with Category"
			, "New Restaurant"
			, "Edit Restaurant Name"
			, "Delete Restaurant"
			, "New Category"
			, "Delete Category"
			 );
	
	public void start() {
		String makeSelection = "";
		
		while(!makeSelection.equals("0")) {
			showListOfOptions();
			makeSelection = scanner.nextLine();
			try {
				if(makeSelection.equals("1")){
					listRestaurantsAllInfo();
				} else if(makeSelection.equals("2")){
					listRestaurantAndCategories();
				} else if(makeSelection.equals("3")){
					//newRestaurant();
				} else if(makeSelection.equals("4")){
					//editRestaurantName();
				} else if(makeSelection.equals("5")){
					//deleteRestaurant();
				} else if(makeSelection.equals("6")){
					//dnewCategory();
				} else if(makeSelection.equals("7")){
					//deleteCategory();
				} else if(makeSelection.equals("0")){
					break;
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("Press enter to continue.........");
			scanner.nextLine();
		}
			

		
	}
	
	private void showListOfOptions() {
		System.out.println("Select number from below options: \n");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i+1+". "+ options.get(i));
		}
		System.out.println("-------------------Press 0 to exit-------------------");
	}
	
	private void listRestaurantsAllInfo() throws SQLException {
		List<Restaurants> restAllInfo = restaurantDao.getRestaurant();
		for(Restaurants rest : restAllInfo) {
			System.out.println(rest.getRestaurantId() + ") {Name:"+ rest.getRestaurantName()+ ",Address: "+ rest.getRestaurantAddress()+ ",City: "+rest.getRestaurantCity()+ ",State: "+rest.getRestaurantState()+ "}");
		}
		
	}
	
	private void listRestaurantAndCategories() throws SQLException {
		System.out.println("Enter Restaurant id: ");
		int restId = Integer.parseInt(scanner.nextLine());
		Restaurants rest = restaurantDao.getRestaurantById(restId);
		System.out.println(rest.getRestaurantId() + ": "+ rest.getRestaurantName());
		for(RestaurantCategory restCat: rest.getRestaurantCategory()) {
			System.out.print("Id: "+ restCat.getRestaurantCategoryId()+", Category : "+ restCat.getCategoryName()+"\n");
		}

	}
	
	

}
