
public class Customer {
	
	//define variables
	
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	
	
	//constructor methods
	
	//default constructor
	
	public Customer() {
		
	}//end default constructor
	
	//full load constructor
	
	public Customer(String firstName, String lastName, String email, Address address) {
		
		Address cloned_address = new Address(address);
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = cloned_address;
		
	}//end loaded constructor
	
	//name only constructor
	public Customer(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		
	}//end name only constructor

	//clone constructor
	
	public Customer(Customer toClone) {
		
		this.firstName = toClone.firstName;
		this.lastName = toClone.lastName;
		this.email = toClone.email;
		this.address = toClone.address;
		
	}//end cloner
	
	//class methods
	
	// setName method
	
	public void setName(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		
	}//end setName method
	
	//setEmail method
	
	public void setEmail(String email) {
		
		this.email = email;
		
	}//end setEmail
	
	//getEmail method
	
	public String getEmail() {
		
		return email;
		
	}//end getEmail
	
	//getName method
	
	public String getName() {
		
		return this.getFirstName() + " " + this.getLastName();
		
	}//end getName
	
	//getFirstname method
	
	public String getFirstName() {
		
		return firstName;
		
	}//end getFirstName method
	
	//getLastName method
	
	public String getLastName() {
		
		return lastName;
		
	}//end getLastName
	
	//setAddress method
	
	public void setAddress(Address addy) {
		
		Address cloned_addy = new Address(addy);
		this.address = cloned_addy;
		
	}//end setAddress method
	
	//getAddress method
	
	public Address getAddress() {
		
		Address clone = new Address(this.address);
		return clone;
		
	}//end getAddress
	
	//equals method
	
	public boolean equals(Customer otherCustomer) {
		
		return this.firstName.equals(otherCustomer.firstName) &&
				this.lastName.equals(otherCustomer.lastName) &&
				this.email.equals(otherCustomer.email) &&
				this.address == null ? null : this.address.equals(otherCustomer.address);
	}//end equals method
	
	//toString method
	
	public String toString() {
		
		String addressString = address == null ? null : address.toString();
		
		return String.format("Name: %s\nEmail: %s\nAddress: %s\n", getName(), getEmail(), addressString);
	}
	
}//end class
