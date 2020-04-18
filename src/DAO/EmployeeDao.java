package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import entity.Employee;

public class EmployeeDao {
    private Connection connection;
    private final String CREATE_NEW_EMPLOYEE_QUERY = "INSERT INTO employees(restaurantid, first_name, last_name, title, address, city, state) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_ALL_EMPLOYEES_QUERY = "SELECT * FROM employees";
    private final String SELECT_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM employees WHERE id = ?";
    private final String UPDATE_EXISTING_EMPLOYEE_NAME = "UPDATE employees SET first_name = ?, last_name = ? WHERE id = ?";
    private final String REMOVE_EMPLOYEE_QUERY = "DELETE FROM employees WHERE id = ?";
    private final String REMOVE_ALL_EMPLOYEE_QUERY_RESTID = "DELETE FROM employees WHERE restaurantid = ?";

    public EmployeeDao() {
        connection = DBConnection.getConnection();
    }

    public void createNewEmployee(
        int restaurantid,
        String first_name, String last_name, String title, 
        String address, String city, String state 
        ) throws SQLException {
            PreparedStatement prepState = connection.prepareStatement(CREATE_NEW_EMPLOYEE_QUERY);
            prepState.setInt(1, restaurantid);
            prepState.setString(2, first_name);
            prepState.setString(3, last_name);
            prepState.setString(4, title);
            prepState.setString(5, address);
            prepState.setString(6, city);
            prepState.setString(7, state);
            prepState.executeUpdate();
    }
    
    public void removeEmployee(int empId) throws SQLException {
        PreparedStatement prepState = connection.prepareStatement(REMOVE_EMPLOYEE_QUERY);
        prepState.setInt(1, empId);
        prepState.executeUpdate();
    }
    
    public void removeAllEmployeesbyRestuarantID(int restID) throws SQLException {
    	 PreparedStatement prepState = connection.prepareStatement(REMOVE_ALL_EMPLOYEE_QUERY_RESTID);
         prepState.setInt(1, restID);
         prepState.executeUpdate();
    }

    public List<Employee> getEmployees() throws SQLException {
        ResultSet resultSet = connection.prepareStatement(SELECT_ALL_EMPLOYEES_QUERY)
            .executeQuery();
        List<Employee> employees = new ArrayList<Employee>();
        while (resultSet.next()) {
            employees.add(
                populateEmployees(
                 resultSet.getInt(1),
                 resultSet.getInt(2), 
                 resultSet.getString(3),
                 resultSet.getString(4),
                 resultSet.getString(5),
                 resultSet.getString(6),
                 resultSet.getString(7),
                 resultSet.getString(8),
                 resultSet.getString(9)
                )
            );
        }
        return employees;
    }

    public Employee getEmployeeById(int empId) throws SQLException {
        PreparedStatement prepState = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID_QUERY);
        prepState.setInt(1, empId);
        ResultSet resultSet = prepState.executeQuery();
        resultSet.next();
        return populateEmployees(
            resultSet.getInt(1), 
            resultSet.getInt(2), 
            resultSet.getString(3),
            resultSet.getString(4),
            resultSet.getString(5),
            resultSet.getString(6),
            resultSet.getString(7),
            resultSet.getString(8),
            resultSet.getString(9)
        );
    }

    public void editExistingEmployeeName(int empId, String first_name, String last_name) throws SQLException {
        PreparedStatement prepState = connection.prepareStatement(UPDATE_EXISTING_EMPLOYEE_NAME);
        prepState.setInt(3, empId);
        prepState.setString(1, first_name);
        prepState.setString(2, last_name);
        prepState.executeUpdate();
    }

    public Employee populateEmployees(
        int empId, int restaurantid,
        String first_name, String last_name, String title, 
        String address, String city, String state, String hire_date 
        ) {
            return new Employee(
                empId, restaurantid,
                first_name, last_name, title, 
                address, city, state, hire_date
            );
    }

}
