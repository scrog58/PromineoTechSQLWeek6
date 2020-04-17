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
	private final String NEW_RESTAURANT_NAME_STATE_QUERY = "INSERT INTO restaurants(name, state) VALUES(?,?)";
	private final String DELETE_RESTAURANT_BY_ID = "INSERT INTO restaurants(name, state) VALUES(?,?)";
	private final String UPDATE_RESTAURANT_NAME_BY_ID = "INSERT INTO restaurants(name, state) VALUES(?)";
	
	public RestaurantDao() {
		connection = DBConnection.getConnection();
		restaurantCategoryDAO = new RestaurantCategoryDao();
	}
	public List<Restaurants> getRestaurant() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_RESTAURANT_QUERY).executeQuery();
		List<Restaurants> restaurants = new ArrayList<Restaurants>();
		
		while(rs.next()) {
			restaurants.add(listRestaurants(rs.getInt(1), rs.getString(2)));
		}
		return restaurants;
		
	}
	
	public Restaurants getRestaurantById(int restaurantId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_RESTAURANT_BY_ID);
		ps.setInt(1, restaurantId);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		return listRestaurants(rs.getInt(1), rs.getString(2));
	}
	
	private Restaurants listRestaurants(int restaurantId, String restaurantName) throws SQLException {
		return new Restaurants(restaurantId, restaurantName);
	}
	
	private Restaurants listRestaurantCategory(int restaurantId, String restaurantName) throws SQLException {
		return new Restaurants(restaurantId, restaurantName,restaurantCategoryDAO.setGetCategoryByRestaurantId(restaurantId));
	}
	
	public void newRestaurant(String restaurantName, String restaurantState, String userName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(NEW_RESTAURANT_NAME_STATE_QUERY);
		ps.setString(1, restaurantName);
		ps.setString(2, restaurantState);
		ps.executeUpdate();
		
	}
	
	public void deleteRestaurant(int restaurantId) throws SQLException {
		//restaurantCategoryDAO.removeCategoryRestaurant(restaurantId);
		PreparedStatement ps = connection.prepareStatement(DELETE_RESTAURANT_BY_ID);
		ps.setInt(1, restaurantId);
		ps.executeUpdate();
		
	}
	
	public void updateRestaurantName(int restaurantId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RESTAURANT_NAME_BY_ID);
		ps.setInt(2, restaurantId);
		ps.executeUpdate();
		
	}

}
