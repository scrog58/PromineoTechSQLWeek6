package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Customers;



public class CustomersDao {

	private Connection connection;
	private final String SHOW_ALL_CUSTOMERS_QUERY = "SELECT * FROM customers";
	private final String SHOW_ALL_CUSTOMERS_AT_RESTAURANT_QUERY = "SELECT * FROM customers WHERE restaurant_id = ?";
	
	public CustomersDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Customers> showCustomers() throws SQLException {
		ResultSet rs = connection.prepareStatement(SHOW_ALL_CUSTOMERS_QUERY).executeQuery();
		List<Customers> customers = new ArrayList<Customers>();
		
		while (rs.next()) {
			customers.add(populateCustomers(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		} return customers;
	}
	
	public Customers showCustomersByRestaurant(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(SHOW_ALL_CUSTOMERS_AT_RESTAURANT_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateCustomers(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	}
	
	

	private Customers populateCustomers(int id, int restaurantId, String name, String birthdate, String city, String state) {
		return new Customers(id, restaurantId, name, birthdate, city, state);
	}

}
	
	
