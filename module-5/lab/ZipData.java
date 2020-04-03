
public class ZipData {
	
	//declare the variables

	private int zip;
	private String city;
	private String state;
	
	
	//constructor
	public ZipData(int zip, String city, String state) {
		
		this.zip = zip;
		this.city = city;
		this.state = state;
		
	}//end ZipData constructor
	
	//getZip method
	
	public int getZip() {
		
		return zip;
	}//end getZip
	
	//getCity methos
	
	public String getCity() {
		
		return city;
	}//end getCity method
	
	//getState method
	
	public String getState() {
		
		return state;
	}//end getState method
	
	public boolean equals(ZipData otherZipData) {
		
		return	this.city.equals(otherZipData.city) &&
				this.state.equals(otherZipData.state) &&
				this.zip == otherZipData.zip;		
	}//end equals method
	
	//toString method
	
	public String toString() {
		
		return zip + "," + city + "," + state;
		
	}//toString method
	
}//end class
