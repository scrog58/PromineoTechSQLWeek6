package app;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.RestaurantDao;
<<<<<<< HEAD
=======
import entity.CustomerPurchases;
import entity.Customers;
import entity.RestaurantCategory;
import DAO.CustomerPurchaseDao;
>>>>>>> acbd7feb1d7d891cd7361b0ae7e6511bb04d837c
import DAO.RestaurantCategoryDao;
import DAO.EmployeeDao;
import DAO.MenuItemDao;
import entity.RestaurantCategory;
import entity.Restaurants;
import entity.RestaurantCategory;
<<<<<<< HEAD
import entity.Employee;
import entity.MenuItem;
=======
import DAO.CustomersDao;
>>>>>>> acbd7feb1d7d891cd7361b0ae7e6511bb04d837c

public class RestaurantOptions {
	private Scanner scanner = new Scanner(System.in);
	private RestaurantDao restaurantDao = new RestaurantDao();
	private RestaurantCategoryDao restaurantCategoryDao = new RestaurantCategoryDao();
<<<<<<< HEAD
	private EmployeeDao employeeDao = new EmployeeDao();
	private MenuItemDao itemDao = new MenuItemDao();
=======
	private CustomerPurchaseDao customerPurchaseDao = new CustomerPurchaseDao();
	private CustomersDao customersDao = new CustomersDao();
>>>>>>> acbd7feb1d7d891cd7361b0ae7e6511bb04d837c
	private List<String> options = Arrays.asList(
			"List All Restaurants and Info"
			, "List Restaurant with Category"
			, "New Restaurant"
			, "Edit Restaurant Name"
			, "Delete Restaurant"
			, "New Category"
			, "Delete Category"
<<<<<<< HEAD
			, "New Employee"
			, "List Employee By ID"
			, "List All Employees"
			, "Modify Existing Employee"
			, "Remove Employee"
			, "Add New Item"
			, "Get Item By ID"
			, "Get All Items"
			, "Modify Existing Item"
			, "Remove Item"
=======
			, "List all Purchases"
			, "List Purchases by Customer"
			, "Show All Customers"
			, "Show Customers at a Restaurant"
>>>>>>> acbd7feb1d7d891cd7361b0ae7e6511bb04d837c
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
<<<<<<< HEAD
				} else if(makeSelection.equals("8")){
					makeNewEmployee();
				} else if(makeSelection.equals("9")){
					getEmployeeById();
				} else if(makeSelection.equals("10")){
					getAllEmployees();
				} else if (makeSelection.equals("11")){
					updateEmployeeName();
				} else if (makeSelection.equals("12")){
					rmEmployee();
				} else if (makeSelection.equals("13")){
					addNewMenuItem();
				} else if (makeSelection.equals("14")){
					getItemById();
				} else if (makeSelection.equals("15")){
					getAllItems();
				} else if (makeSelection.equals("16")){
					updateItem();
				} else if (makeSelection.equals("17")){
					rmItem();
=======
				} else if (makeSelection.equals("8")) {
					displayCustomerPurchases();
				} else if (makeSelection.equals("9")) {
					showWhatCustomerBought();
				} else if (makeSelection.equals("10")) {
					displayCustomers();
				} else if (makeSelection.equals("11")) {
					showCustomersAtRestaurant();
>>>>>>> acbd7feb1d7d891cd7361b0ae7e6511bb04d837c
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
	
<<<<<<< HEAD
	private void makeNewEmployee() throws SQLException {
		System.out.println("Enter the Employee's Restaurant ID Number: ");
		int restaurantid = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter employee First Name: ");
		String first_name = scanner.nextLine();
		System.out.println("Enter employee Last Name: ");	
		String last_name = scanner.nextLine();
		System.out.println("Enter title: ");
		String title = scanner.nextLine();
		System.out.println("Enter streed address: ");	
		String address = scanner.nextLine();
		System.out.println("Enter City Name:");
		String city = scanner.nextLine();
		System.out.println("Enter Employee State Location (Two Letters): ");
		String state = scanner.nextLine();
		employeeDao.createNewEmployee(restaurantid, first_name, last_name, title, address, city, state);
	}

	private void updateEmployeeName() throws SQLException {
		System.out.println("Please Enter the ID Number of the Employee You Wish to Modify: ");
		int empId = Integer.parseInt(scanner.nextLine());
		System.out.println("Please Enter First Name Modification Below: ");
		String first_name = scanner.nextLine();
		System.out.println("Please Enter Last Name Modification Below");
		String last_name = scanner.nextLine();
		employeeDao.editExistingEmployeeName(empId, first_name, last_name);
	}

	private void rmEmployee() throws SQLException {
		System.out.println("Enter the Employee Number of the Employee you wish to remove: ");
		int empId = Integer.parseInt(scanner.nextLine());
		employeeDao.removeEmployee(empId);
	}

	private void getAllEmployees() throws SQLException {
		List<Employee> employees = employeeDao.getEmployees();
		for (Employee employee : employees) {
			System.out.println(
				   "| ID: " + employee.getEmpId()  + " | Restaurant ID: " + employee.getRestaurantId()
				+ " | Name: " + employee.getFirstName() + " " + employee.getLastName()
				+ " | Title: " + employee.getTitle() + " "
				+ " | Address: " + employee.getAddress() + " " + employee.getCity() + " " + employee.getState()
				+ " | Hire Date: " + employee.getHireDate());
		}
	}

	private void getEmployeeById() throws SQLException {
		System.out.println("Enter Employee ID Number:");
		int empId = Integer.parseInt(scanner.nextLine());
		Employee employee = employeeDao.getEmployeeById(empId);
		System.out.println(
			"ID: " + employee.getEmpId() + ": " + employee.getFirstName() + " " + employee.getLastName()
			);
	}

	private void addNewMenuItem() throws SQLException {
		System.out.println("Please Enter the Item's Restaurant's ID Number: ");
		int restaurantid = Integer.parseInt(scanner.nextLine());
		System.out.println("Please Enter the Item's Name: ");
		String item = scanner.nextLine();
		System.out.println("Please Enter the Item's Price:");
		int price = Integer.parseInt(scanner.nextLine());
		itemDao.createNewMenuItem(restaurantid, item, price);
	}

	private void getAllItems() throws SQLException {
		List<MenuItem> items = itemDao.getAllMenuItems();
		for (MenuItem item : items) {
			System.out.println(
				   "| ID: " + item.getMenuItemId() 
				+ " | Name:" + item.getItemName() 
				+ " | Price: " + item.getPrice()
			);
		}
	}

	private void getItemById() throws SQLException {
		System.out.println("Please enter the Item ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		MenuItem item = itemDao.getMenuItemById(id);
		System.out.println(
			   "| ID: " + item.getMenuItemId() 
			+ " | Name: " + item.getItemName() 
			+ " | " + item.getPrice()
			);
	}

	private void rmItem() throws SQLException {
		System.out.println("Please Enter the ID Number of the Item You Wish to Remove: ");
		int id = Integer.parseInt(scanner.nextLine());
		itemDao.rmMenuItem(id);
	}

	private void updateItem() throws SQLException {
		System.out.println("Please Enter the ID Number of the Item You Wish to Modify: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Please Enter the New Name of the Item: ");
		String item = scanner.nextLine();
		System.out.println("Please Enter the New Price of the Item: ");
		int price = Integer.parseInt(scanner.nextLine());
		itemDao.updateExistingMenuItem(id, item, price);
	}

=======
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
	
	
	
>>>>>>> acbd7feb1d7d891cd7361b0ae7e6511bb04d837c
}
