package entity;

public class MenuItem {
    private int menuItemId; //primary key
    private int restaurantId; //foreign key
    private int price;
    private String itemName; //"item" in sql table

    public MenuItem(
        int menuItemId, int restaurantId,
        int price, String itemName
        ) {
            this.setMenuItemId(menuItemId);
            this.setRestaurantId(restaurantId);
            this.setPrice(price);
            this.setItemName(itemName);
    }
    
    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

}