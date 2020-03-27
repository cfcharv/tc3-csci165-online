
public class Driver {
	
	public static void main(String[] args) {
		
		//create original address object
		
		Address home_address = new Address("123 PCH", 90263);
		
		//create the customer object
		
		Customer iron_man = new Customer("Tony", "Stark", "tony@avengers.com", home_address);
		
		//output original customer info
		
		System.out.println("Original Customer object");
		System.out.println(iron_man.toString());
		System.out.println("");
		
		//show that the customer address object changes if we change the original address object passed in
		
		home_address.setStreet("321 PCH");
		
		System.out.println("Customer object after changing the address object after it was passed in");
		System.out.println(iron_man.toString());
		System.out.println(" ");
		
		//show I can do the same thin with an address through the setAddress method
		
		Address work_address = new Address("246 Park Ave.", 13021);
		
		iron_man.setAddress(work_address);
		
		System.out.println("Customer object with work address passed in");
		System.out.println(iron_man.toString());
		System.out.println("");
		
		work_address.setStreet("999 Meadow Drive");
		
		System.out.println("Customer object after altering the work address AFTER it was passed in");
		System.out.println(iron_man.toString());
		System.out.println("");
		
		//show I can use the getAddress method to alter the address within the customer class
		
		System.out.println("Current Customer object");
		System.out.println(iron_man.toString());
		System.out.println("");
		
		Address gotten_address = iron_man.getAddress();
		
		gotten_address.setZip(000000);
		
		System.out.println("Current Customer object after altering Zip in the gotten_address object");
		System.out.println(iron_man.toString());
		System.out.println("");
		
		System.out.println("If the output blocks are different we have a privacy leak. The only change should have occurred when the work address was passed in");
		
		
	}//end main

}//end class
