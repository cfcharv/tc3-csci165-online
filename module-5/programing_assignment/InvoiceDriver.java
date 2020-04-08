import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class InvoiceDriver {
	
	public static Date getTodayDate(){
		
		java.util.Date today = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		String datestr = formatter.format(today);
		
		String[] array = datestr.split("/");
		
		int month = Integer.parseInt(array[0]);
		int day = Integer.parseInt(array[1]);
		int year = Integer.parseInt(array[2]);
		
		Date now = new Date(month, day, year);
		
		
		return now;
	}

	public static void main(String[] args) {
		
		//create the Customer, Account, and Product arrays
		
		//create products array
		
		Product[] products = new Product[1000];
		
		//read product file
		
		try {
			int index = 0;
			
			File product_file = new File("products.txt");
			BufferedReader buff_prod_read = new BufferedReader(new FileReader(product_file));
			
			String line;
			while ((line = buff_prod_read.readLine()) != null) {
				
				String[] values = line.split("\t");
				
				String name = values[0];
				String description = values[1];
				String price = values[2];
				
				double cost = Double.parseDouble(price);
				
				products[index] = new Product(name, description, cost);
				
				index++;
				
			}//end while
			
			buff_prod_read.close();
			
		}//end try
		
		catch(IOException e) {
			e.printStackTrace();
		}//end catch
		
		
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
				
				
				
				//now let's make the account array
				
				Account[] accounts = new Account[1000];
				Random rand = new Random();
				double balance;
				double creditLimit;
				
				
				for (int index = 0; index < 1000; index++) {
					
					balance = rand.nextInt(10000);
					creditLimit = balance / 2.0;
					
					accounts[index] = new Account(customers[index], balance, creditLimit);
					
				}//end for loop
				
				//create the invoice array
				
				Invoice[] invoices = new Invoice[100];
				
				int account_index = 0;
				int number_of_products = 0;
				int product_index = 0;
				
				for (int i = 0; i < 100; i++) {
					
					account_index = rand.nextInt(1000);
					number_of_products = rand.nextInt(19) + 1;
					
					invoices[i] = new Invoice(accounts[account_index], getTodayDate());
					
					for (int j = 0; j < number_of_products; j++) {
						
						product_index = rand.nextInt(1000);
						
						invoices[i].addProduct(products[product_index]);
						
					}//end products for loop
					
				}//end invoices for loop
				
				
				//print invoices
				Scanner input = new Scanner(System.in);
				String line = " ";
				int count = 0;
				
				while (! line.toLowerCase().equals("stop")) {
					
					System.out.println(invoices[count].toString());
					System.out.println(" ");
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println(" ");
					
					System.out.println("Press enter to continue, enter 'stop' to exit");
					line = input.nextLine();
					count ++;
					
					if (count == 100) {
						System.out.println("That was the last invoice.");
						line = "stop";
					}//end if
					
				}//end loop
				
				input.close();
				
				 
	}//end main

}//end class
