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
			System.out.println("Id: "+ restCat.getRestaurantCategoryId()+ "\nCategory: " + restCat.getCategoryName()+", ");
		}
	}
	
//	private void newTrainer() throws SQLException {
//		System.out.println("Entering a new Trainer. First please list your First Name:");
//		String firstName = scanner.nextLine();
//		System.out.println("Please enter Last Name:");
//		String lastName = scanner.nextLine();
//		System.out.println("Please enter a username:");
//		String userName = scanner.nextLine();
//		
//		trainerDao.newTrainer(firstName, lastName, userName); 
//		
//	}
	
//	private void newPokemon() throws SQLException {
//		System.out.println("Enter Trainer Id:");
//		int trainerId = Integer.parseInt(scanner.nextLine());
//		System.out.println("Entering a new Pokemon:");
//		String pokemonName = scanner.nextLine();
//		String checkPokemonSQLName = pokemonsDao.checkPokemonName(pokemonName);
//
//		if(pokemonName.equals(checkPokemonSQLName)) {
//			Pokemons getPokemonId = pokemonsDao.getPokemonIdByName(pokemonName);
//			pokemonsDao.addTrainerPokemonIds(trainerId,getPokemonId.getPokemonId());
//		} else {
//		
//		pokemonsDao.getNewPokemon(pokemonName); 
//		Pokemons getPokemonId = pokemonsDao.getPokemonIdByName(pokemonName);
//		pokemonsDao.addTrainerPokemonIds(trainerId,getPokemonId.getPokemonId());
//		}
//		
//	}
	
//	private void editTrainerUserName() throws SQLException {
//		System.out.println("Enter New UserName:");
//		String userName = scanner.nextLine();
//		System.out.println("Enter Trainer Id:");
//		int trainerId = Integer.parseInt(scanner.nextLine());
//		
//		trainerDao.updateTrainerUserName(userName, trainerId);
//	}
//	
//	
//	private void deleteTrainerandPokemons() throws SQLException {
//		System.out.println("Enter Trainer Id:");
//		int trainerId = Integer.parseInt(scanner.nextLine());
//		trainerDao.deleteTrainer(trainerId);
//	}
	

}
