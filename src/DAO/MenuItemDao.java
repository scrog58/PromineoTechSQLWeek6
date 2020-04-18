package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import entity.MenuItem;

public class MenuItemDao {
    private Connection connection;
    private final String CREATE_NEW_MENU_ITEM = "INSERT INTO menuitems(restaurantid, item, price) VALUES (?, ?, ?)";
    private final String SELECT_MENU_ITEM_QUERY = "SELECT * FROM menuitems WHERE id = ?";
    private final String LIST_ALL_MENU_ITEMS = "SELECT * FROM menuitems";
    private final String UPDATE_EXISTING_MENU_ITEM = "UPDATE menuitems SET item = ?, price = ? WHERE id = ?";
    private final String REMOVE_MENU_ITEM = "DELETE FROM menuitems WHERE id = ?";
    private final String DELETE_ALL_MENU_ITEMS_BY_RESTID = "DELETE FROM menuitems WHERE restaurantid = ?";

    public MenuItemDao() {
        connection = DBConnection.getConnection();
    }

    public void createNewMenuItem(int restaurantid, String item, int price) throws SQLException {
        PreparedStatement prepState = connection.prepareStatement(CREATE_NEW_MENU_ITEM);
        prepState.setInt(1, restaurantid);
        prepState.setString(2, item);
        prepState.setInt(3, price);
        prepState.executeUpdate();
    }

    public void rmMenuItem(int id) throws SQLException {
        PreparedStatement prepState = connection.prepareStatement(REMOVE_MENU_ITEM);
        prepState.setInt(1, id);
        prepState.executeUpdate();
    }
    
    public void deleteALLMenuItemsByRestID(int restId) throws SQLException {
        PreparedStatement prepState = connection.prepareStatement(DELETE_ALL_MENU_ITEMS_BY_RESTID);
        prepState.setInt(1, restId);
        prepState.executeUpdate();
    }

    public List<MenuItem> getAllMenuItems() throws SQLException {
        ResultSet resultSet = connection.prepareStatement(LIST_ALL_MENU_ITEMS)
            .executeQuery();
        List<MenuItem> items = new ArrayList<MenuItem>();
        while(resultSet.next()){
            items.add(
                populateMenuItems(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                )
            );
        }
        return items; 
    }

    public MenuItem getMenuItemById(int id) throws SQLException {
        PreparedStatement prepState = connection.prepareStatement(SELECT_MENU_ITEM_QUERY);
        prepState.setInt(1, id);
        ResultSet resultSet = prepState.executeQuery();
        resultSet.next();
        return populateMenuItems(
            resultSet.getInt(1),
            resultSet.getInt(2),
            resultSet.getString(3),
            resultSet.getInt(4)
        );
    }

    public void updateExistingMenuItem(int id, String item, int price) throws SQLException {
        PreparedStatement prepState = connection.prepareStatement(UPDATE_EXISTING_MENU_ITEM);
        prepState.setInt(3, id);
        prepState.setString(1, item);
        prepState.setInt(2, price);
        prepState.executeUpdate();
    }

    public MenuItem populateMenuItems(int id, int restaurantid, String item, int price) {
        return new MenuItem(id, restaurantid, price, item);
    }

}