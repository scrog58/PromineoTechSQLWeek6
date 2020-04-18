package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Restaurants;


public class RestaurantDao {
	private Connection connection;
	private RestaurantCategoryDao restaurantCategoryDAO;
	private final String GET_RESTAURANT_QUERY = "SELECT * FROM restaurants";
	private final String GET_RESTAURANT_BY_ID = "SELECT * FROM restaurants WHERE id = ?";
	private final String NEW_RESTAURANT_NAME_STATE_QUERY = "INSERT INTO restaurants(name,state) VALUES(?,?)";
	private final String DELETE_RESTAURANT_BY_ID = "DELETE FROM restaurants WHERE id = ?";
	private final String UPDATE_RESTAURANT_NAME_BY_ID = "UPDATE restaurants SET name = ? WHERE id = ?";
	
	public RestaurantDao() {
		connection = DBConnection.getConnection();
		restaurantCategoryDAO = new RestaurantCategoryDao();
	}
	public List<Restaurants> getRestaurant() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_RESTAURANT_QUERY).executeQuery();
		List<Restaurants> restaurants = new ArrayList<Restaurants>();
		
		while(rs.next()) {
			restaurants.add(listAllInfoRestaurants(rs.getInt(1) ,rs.getString(2) ,rs.getString(3) ,rs.getString(4),rs.getString(5)));
		}
		return restaurants;
		
	}
	
	public Restaurants getRestaurantById(int restaurantId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_RESTAURANT_BY_ID);
		ps.setInt(1, restaurantId);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		return listRestaurantCategory(rs.getInt(1), rs.getString(2));
	}
	
	public void newRestaurant(String restaurantName, String restaurantState) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(NEW_RESTAURANT_NAME_STATE_QUERY);
		ps.setString(1, restaurantName);
		ps.setString(2, restaurantState);
		ps.executeUpdate();
		
	}
	
	public void deleteRestaurant(int restaurantId) throws SQLException {
		restaurantCategoryDAO.removeAllCategoriesByRestId(restaurantId);
		PreparedStatement ps = connection.prepareStatement(DELETE_RESTAURANT_BY_ID);
		ps.setInt(1, restaurantId);
		ps.executeUpdate();
		
	}
	
	public void updateRestaurantName(int restaurantId, String restName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RESTAURANT_NAME_BY_ID);
		ps.setString(1, restName);
		ps.setInt(2, restaurantId);
		ps.executeUpdate();
		
	}
	
	private Restaurants listAllInfoRestaurants(int restaurantId ,String restaurantName ,String restaurantAddress ,String restaurantCity ,String restaurantState) throws SQLException {
		return new Restaurants(restaurantId, restaurantName ,restaurantAddress ,restaurantCity ,restaurantState);
	}
	
	private Restaurants listRestaurantCategory(int restaurantId, String restaurantName) throws SQLException {
		return new Restaurants(restaurantId, restaurantName,restaurantCategoryDAO.setGetCategoryByRestaurantId(restaurantId));
	}
	

}
