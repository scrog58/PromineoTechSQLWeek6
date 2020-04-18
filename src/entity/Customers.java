package entity;

public class Customers {
	private int id;
	private int restaurantId;
	private String name;
	private String birthdate; //not sure if String is correct data type here
	private String city;
	private String state;
	
	public Customers(int id, int restaurantId, String name, String birthdate, String city, String state) {
		this.setId(id);
		this.setRestaurantId(restaurantId);
		this.setName(name);
		this.setBirthdate(birthdate);
		this.setCity(city);
		this.setState(state);
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
