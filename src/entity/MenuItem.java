package entity;

public class MenuItem {
    private int id; 
    private int restaurantid; 
    private int price;
    private String itemName; 

    public MenuItem(
        int id, int restaurantid,
        int price, String item
        ) {
            this.setMenuItemId(id);
            this.setRestaurantId(restaurantid);
            this.setPrice(price);
            this.setItemName(item);
    }
    
    public void setMenuItemId(int id) {
        this.id = id;
    }

    public int getMenuItemId() {
        return id;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantid = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantid;
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