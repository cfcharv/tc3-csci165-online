import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;


public class AccountDriver {
	
	
	public static void main(String[] args) {
		
		//create customer array
		Customer[] customers = new Customer[1000];
		
		
		//read customer file
		try {
			int index = 0; //index number for customer array
			Address address = new Address(); //create address object to use to for customer creation
			
			File customer_file = new File("customers.txt");	
			BufferedReader buff_cust_read = new BufferedReader(new FileReader(customer_file));
			
			String line;
			 while ((line = buff_cust_read.readLine()) != null) {
				 
				 String[] values = line.split("\t");
				 
				 String fName = values[0];
				 String lName = values[1];
				 String email = values[2];
				 String street = values[3] + " " + values[4] + " " + values[5];
				 int zip = Integer.parseInt(values[6]);
				 
			
				 
				 address = new Address(street, zip);
				 
				 customers[index]= new Customer(fName, lName, email, address);
				 
				 index++;
				
				 
			 }//end while
			 
			 buff_cust_read.close();
			
			
		}//end try
		
		catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		
		//print customers with bail option
		
		Scanner input = new Scanner(System.in);
		
		String line = " ";
		int count = 0;
		
		while (! line.toLowerCase().equals("stop")){
			
			System.out.println("");
			System.out.println(customers[count].toString());
			System.out.println(" ");
			
			System.out.println("Press enter to continue or enter 'stop' to end");
			line = input.nextLine();
			count ++;
			
			if (count == 1000) {
				System.out.println("That was the last record");
				line = "stop";
			}//end if
			
		}//end loop
		
	
		
		//now let's make and then print the account array
		
		Account[] accounts = new Account[1000];
		Random rand = new Random();
		double balance;
		double creditLimit;
		
		
		for (int index = 0; index < 1000; index++) {
			
			balance = rand.nextInt(10000);
			creditLimit = balance / 2.0;
			
			accounts[index] = new Account(customers[index], balance, creditLimit);
			
		}//end for loop
		
		
		line = " ";
		count = 0;
		
		while ( ! line.toLowerCase().contentEquals("stop")) {
			
			System.out.println("");
			System.out.println(accounts[count].toString());
			System.out.println(" ");
			
			System.out.println("Press enter to continue or enter 'stop' to end");
			line = input.nextLine();
			count ++;
			
			if (count == 1000) {
				System.out.println("That was the last record");
				line = "stop";
			}//end if
			
		}//end while loop
		
		input.close();
		
	}//end main

}//end class
