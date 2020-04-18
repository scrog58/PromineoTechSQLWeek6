package entity;

public class CustomerPurchases {
	private int id;
	private int customerId;
	private String purchaseDate;
	
	
	public CustomerPurchases(int id, int customerId, String purchaseDate) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setPurchaseDate(purchaseDate);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
}
