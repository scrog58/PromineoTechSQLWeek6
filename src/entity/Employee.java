package entity;

public class Employee {
	private int empId;
	private String hire_date;
	private String first_name;
	private String last_name;
	private String title;
	private String address;
	private String city;
	private String state;
	
	public Employee(
		int empId, 
		String firstName, String lastName, String title, 
		String address, String city, String state,
		String hire_date
		) {
			this.setEmpId(empId);
			this.setFirstName(first_name);
			this.setLastName(last_name);
			this.setTitle(title);
			this.setAddress(address);
			this.setCity(city);
			this.setState(state);
			this.setHireDate(hire_date);
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setHireDate(String hire_date) {
		this.hire_date = hire_date;
	}
	
	public String getHireDate() {
		return hire_date;
	}
	
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	} 

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

}
