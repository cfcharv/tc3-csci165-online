
public class Product {
	//define the variables
	
	private String name;
	private String description;
	private double price;
	
	//constructors
	
	public Product() {
		
	}//end default constructor
	
	public Product(String name, String description, double price) {
		
		this.name = name;
		this.description = description;
		this.price = price;
		
	}//end loaded constructor
	
	//setName method
	
	public void setName(String name) {
		
		this.name = name;
	}//end setName
	
	//get name method
	
	public String getName() {
		
		return name;
	}//end getName
	
	//setPrice method
	
	public void setPrice(double price) {
		
		this.price = price;
	}//end setPrice
	
	//getPrice method
	
	public double getPrice() {
		
		return price;
	}//end getPrice method
	
	//toString method
	
	public String toString() {
		
			
		 return String.format("%-35s%-40s%5.2f", name, description, price);
		
		
	}//end toString
	
	//equals method
	
	public boolean equals(Product p) {
		
		return this.name.equals(p.name) &&
				this.description.contentEquals(p.description) &&
				this.price == p.price;
	}//end equals method
	
}//end class
