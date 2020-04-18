package app;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import DAO.RestaurantDao;
import entity.CustomerPurchases;
import entity.Customers;
import entity.RestaurantCategory;
import DAO.CustomerPurchaseDao;
import DAO.RestaurantCategoryDao;
import entity.Restaurants;
import entity.RestaurantCategory;
import DAO.CustomersDao;

public class RestaurantOptions {
	private Scanner scanner = new Scanner(System.in);
	private RestaurantDao restaurantDao = new RestaurantDao();
	private RestaurantCategoryDao restaurantCategoryDao = new RestaurantCategoryDao();
	private CustomerPurchaseDao customerPurchaseDao = new CustomerPurchaseDao();
	private CustomersDao customersDao = new CustomersDao();
	private List<String> options = Arrays.asList(
			"List All Restaurants and Info"
			, "List Restaurant with Category"
			, "New Restaurant"
			, "Edit Restaurant Name"
			, "Delete Restaurant"
			, "New Category"
			, "Delete Category"
			, "List all Purchases"
			, "List Purchases by Customer"
			, "Show All Customers"
			, "Show Customers at a Restaurant"
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
					getNewRestaurant();
				} else if(makeSelection.equals("4")){
					editResturantName();
				} else if(makeSelection.equals("5")){
					deleteRestaurantandCategory();
				} else if(makeSelection.equals("6")){
					getNewCategory();
				} else if(makeSelection.equals("7")){
					deleteCategory();
				} else if (makeSelection.equals("8")) {
					displayCustomerPurchases();
				} else if (makeSelection.equals("9")) {
					showWhatCustomerBought();
				} else if (makeSelection.equals("10")) {
					displayCustomers();
				} else if (makeSelection.equals("11")) {
					showCustomersAtRestaurant();
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
			System.out.println(rest.getRestaurantId() + ") {Name:"+ rest.getRestaurantName()+ " ,Address: "+ rest.getRestaurantAddress()+ " ,City: "+rest.getRestaurantCity()+ " ,State: "+rest.getRestaurantState()+ "}");
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
	
	private void getOneRestaurantAndCategories(int restId) throws SQLException {
		Restaurants rest = restaurantDao.getRestaurantById(restId);
		System.out.println(rest.getRestaurantId() + ": "+ rest.getRestaurantName());
		for(RestaurantCategory restCat: rest.getRestaurantCategory()) {
			System.out.print("Id: "+ restCat.getRestaurantCategoryId()+", Category : "+ restCat.getCategoryName()+"\n");
		}

	}
	
	private void getNewRestaurant() throws SQLException {
		String getStateName = "";
		System.out.println("Enter new Restaurant Name:");
		String name = scanner.nextLine();
		System.out.println("Enter Restaurant State Location: (only two letters)");
		String state = scanner.nextLine();
		if(state.length() > 2) {
			getStateName = "AZ";
		} else {
			getStateName = state;
		}
		restaurantDao.newRestaurant(name,getStateName); 
	}
	
	private void getNewCategory() throws SQLException {
		System.out.println("Enter Restaurant Id:");
		int restId = Integer.parseInt(scanner.nextLine());
		System.out.println("Entering a new Category:");
		String category = scanner.nextLine();
		restaurantCategoryDao.newCategory(restId, category); 		
	}
	
	private void editResturantName() throws SQLException {
		System.out.println("Enter Restaurant Id:");
		int restId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter New Restaurant Name:");
		String restName = scanner.nextLine();
		restaurantDao.updateRestaurantName(restId, restName);
	}
	
	
	private void deleteRestaurantandCategory() throws SQLException {
		System.out.println("Enter Restaurant Id:");
		int restId = Integer.parseInt(scanner.nextLine());
		restaurantDao.deleteRestaurant(restId);
	}
	
	private void deleteCategory()  throws SQLException {
		System.out.println("Enter Restaurant Id:");
		int restId = Integer.parseInt(scanner.nextLine());
		getOneRestaurantAndCategories(restId);
		
		System.out.println("Enter Category Id:");
		int restCatId = Integer.parseInt(scanner.nextLine());
		restaurantCategoryDao.removeCategoryByIdandRestId(restId,restCatId) ;
	}
	
	private void displayCustomerPurchases() throws SQLException {
		List<CustomerPurchases> customerpurchases = customerPurchaseDao.showPurchases();
		for(CustomerPurchases customerpurchase : customerpurchases) {
			System.out.println(customerpurchase.getId() + customerpurchase.getCustomerId() + customerpurchase.getPurchaseDate());
		}
	}
	
	private void showWhatCustomerBought() throws SQLException {
		System.out.println("Enter Customer ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		CustomerPurchases customerpurchases = customerPurchaseDao.getPurchasesByCustomer(id);
		System.out.println(customerpurchases.getId() + customerpurchases.getPurchaseDate());
		
	}
	
	private void displayCustomers() throws SQLException {
		List<Customers> customers = customersDao.showCustomers();
		for(Customers customer : customers) {
			System.out.println(customer.getId() + customer.getRestaurantId() + customer.getName() + customer.getBirthdate() + customer.getCity() + customer.getState());
		}
	}
	
	private void showCustomersAtRestaurant() throws SQLException {
		System.out.println("Enter Restaurant ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Customers customers = customersDao.showCustomersByRestaurant(id);
		System.out.println(customers.getId() + customers.getName() + customers.getState());
	}
	
	
	
}
