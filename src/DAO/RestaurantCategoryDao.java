package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.RestaurantCategory;

public class RestaurantCategoryDao {
	private Connection connection;
	private final String GET_CATEGORY_BY_RESTAURANTID = "SELECT * FROM restaurant_category RC INNER JOIN restaurants R ON RC.restaurantid = R.id WHERE RC.restaurantid = ?";
	private final String NEW_CATEGORY_QUERY = "INSERT INTO restaurant_category(restaurantid,name) VALUES(?,?)";
	private final String REMOVE_ALL_CATEGORIES_BY_RESTID = "DELETE FROM restaurant_category WHERE restaurantid = ? ";
	private final String DELETE_CATEGORY_BY_ID_AND_RESTID = "DELETE FROM restaurant_category WHERE restaurantid = ? AND id = ?";
	
	public RestaurantCategoryDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<RestaurantCategory> setGetCategoryByRestaurantId(int restId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CATEGORY_BY_RESTAURANTID);
		ps.setInt(1, restId);
		ResultSet rs = ps.executeQuery();
		List<RestaurantCategory> restCat = new ArrayList<RestaurantCategory>();
		
		while(rs.next()) {
			restCat.add(new RestaurantCategory(rs.getInt(1), rs.getString(3)));
			
		}
		
		return restCat;
	}
	
	public void newCategory(int restId, String getName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(NEW_CATEGORY_QUERY);
		ps.setInt(1, restId);
		ps.setString(2, getName);
		ps.executeUpdate();
	}
	
	public void removeAllCategoriesByRestId(int restId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(REMOVE_ALL_CATEGORIES_BY_RESTID);
		ps.setInt(1, restId);
		ps.executeUpdate();
		
	}
	
	public void removeCategoryByIdandRestId(int restId, int categoryId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CATEGORY_BY_ID_AND_RESTID);
		ps.setInt(1, restId);
		ps.setInt(2, categoryId);
		ps.executeUpdate();
		
	}


}
