import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;


public class Address {
	
	//define variables
	
	private String street;
	private String city;
	private String state;
	private int zip;
	
	public static ArrayList<ZipData> zip_database = new ArrayList<ZipData>();
	
	//static block to fill zip_database array
	
	static {
		fillList();
	}//end static block
	
	private static void fillList() {
		
		try {
			
			File zip_file = new File("zip_code_database.csv");
			BufferedReader buff_zip_read = new BufferedReader(new FileReader(zip_file));
			
			String line;
			String headers = buff_zip_read.readLine();//reads header line
			
			while ((line = buff_zip_read.readLine()) != null){
				
				String[] values = line.split(",");
				
				int zip_code = Integer.parseInt(values[0]);
				String cities = values[2];
				String states = values[3];
				
				ZipData zip_db = new ZipData(zip_code, cities, states);
				
				zip_database.add(zip_db);
								
			}//end while loop
			
			buff_zip_read.close();
			
		}//end try
		
		catch(IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//end fillList
	
	public static ZipData locate(int zip) {
		 int count = 0;
		 
		for (ZipData zd : zip_database) {
			
			if (zd.getZip() == zip) {
				break;
			}
			
			count ++;
		}//end for loop
		
		return zip_database.get(count);
		
	}//end locate method
	
	//constructor methods
	
	//default
	
	public Address(){}
	
	//with street and zip constructor
	
	public Address(String street, int zip) {
		
		this.street = street;
		this.zip = zip;
		
		ZipData zd = locate(zip);
		
		this.city = zd.getCity();
		this.state = zd.getState();
			
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
