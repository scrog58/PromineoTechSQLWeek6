package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Animals;
import entity.CustomerPurchases;

public class CustomerPurchaseDao {

	private Connection connection;
	private final String GET_ALL_PURCHASES_QUERY = "SELECT * from customer_purchase";
	private final String GET_PERCHASES_BY_CUSTOMER_QUERY = "SELECT * from customer_purchase WHERE customer_id = ?";
	
	
	public CustomerPurchaseDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<CustomerPurchases> showPurchases() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ALL_PURCHASES_QUERY).executeQuery();
		List<CustomerPurchases> customerPurchases = new ArrayList<CustomerPurchases>();
		
		while (rs.next()) {
			customerPurchases.add(populatePurchases(rs.getInt(1), rs.getInt(2), rs.getString(3)));
		} return customerPurchases;
	}
	
	public CustomerPurchases getPurchasesByCustomer(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PERCHASES_BY_CUSTOMER_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePurchases(rs.getInt(1), rs.getInt(2), rs.getString(3));
	}
	
	
	
	private CustomerPurchases populatePurchases(int id, int customerId, String purchaseDate) {
		return new CustomerPurchases(id, customerId, purchaseDate);
	}
	
	
}
