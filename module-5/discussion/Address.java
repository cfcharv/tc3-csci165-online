
public class Address {
	
	//define variables
	
	private String street;
	private String city;
	private String state;
	private int zip;
	
	
	//constructor methods
	
	//default
	
	public Address(){}
	
	//with street and zip constructor
	
	public Address(String street, int zip) {
		
		this.street = street;
		this.zip = zip;
			
	}//end street zip constructor
	
	//clone constructor
	
	public Address(Address toClone) {
		
		this.street = toClone.street;
		this.city = toClone.city;
		this.state = toClone.state;
		this.zip = toClone.zip;
		
	}//end cloner
	
	//class methods
	
	//setStreet method
	
	public void setStreet(String street) {
		
		this.street = street;
		
	}//end setStreet method
	
	//getStreet method
	
	public String getStreet() {
		
		return street;
		
	}//end getStreet method
	
	//setZip method
	
	public void setZip(int zip) {
		
		this.zip = zip;
		
	}//end setZip method
	
	//getZip method
	
	public int getZip() {
		
		return zip;
		
	}//end getZip method
	
	//getCity method
	
	public String getCity() {
		
		return city;
		
	}//end getCity method
	
	//getState method
	
	public String getState() {
		
		return state;
		
	}//end getState method
	
	//equals method
	
	public boolean equals(Address otherAddress) {
		
		return this.street.equals(otherAddress.street)  &&
				this.city.equals(otherAddress.city) &&
				this.state.equals(otherAddress.state) &&
				this.zip == otherAddress.zip;
		
	}// end equals method
	
	public String toString() {
		
		return street + " " + city + " " + state + ", "  + zip;
		
	}//end toString

}//end class
