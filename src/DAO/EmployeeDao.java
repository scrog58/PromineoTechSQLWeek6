package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import entity.Employee;

public class EmployeeDao {
    private Connection connection;
    private final String CREATE_NEW_EMPLOYEE_QUERY = "INSERT INTO employees(first_name, last_name, title, address, city, state, hire_date) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_ALL_EMPLOYEES_QUERY = "SELECT * FROM employees";
    private final String SELECT_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM employees WHERE id = ?";

    public EmployeeDao() {
        connection = DBConnection.getConnection();
    }

    public void createNewEmployee(
        String first_name, String last_name, String title, 
        String address, String city, String state, 
        String hire_date) throws SQLException {
        
            PreparedStatement prepState = connection.prepareStatement(CREATE_NEW_EMPLOYEE_QUERY);
            prepState.setString(1, first_name);
            prepState.setString(2, last_name);
            prepState.setString(3, title);
            prepState.setString(4, address);
            prepState.setString(5, city);
            prepState.setString(6, state);
            prepState.setString(7, hire_date);
            
    }

}
