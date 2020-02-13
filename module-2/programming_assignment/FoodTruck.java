//Mike Harvey
//CSCI165 - Module 2 Food Truck POS
//2/9/2020


// let's import some libraries

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;


public class FoodTruck{

	//get menu items method

	static void getMenu(String[] menuItems){

		try{

		File menuFile = new File("menu.txt"); //creates a file instance for the menu file
		Scanner menuScanner = new Scanner(menuFile); // creates a scanner to read the file

		

		

			int index = 0; //initialize index counter

		while (menuScanner.hasNextLine()){			

			menuItems[index] = menuScanner.nextLine(); //add item to array

			index +=1; //increment the counter

		}//end while loop

		menuScanner.close();
		}//end try

		catch (FileNotFoundException e){

			System.out.println("oops file not found");
		}//end catch

		
	}//end getmenu method



	//getPrices method

	static void getPrices(double[] prices){

		try{

		File priceFile = new File("prices.txt"); //creates file instance of price file
		Scanner priceScanner = new Scanner(priceFile); //scanner to read price file

		

		int index = 0;



		while (priceScanner.hasNextDouble()){

			prices[index] = priceScanner.nextDouble(); //add price to array

			index +=1; //increment the counter

		}//end while loop

		priceScanner.close();

		}//end try

		catch (FileNotFoundException e){

			System.out.println("oops file not found");

		}//end catch

		
	}//end getPrices method

	//get invoice number method

	static String getInvoiceNum(String name, LocalDateTime currentDateTime){

		String first_initials = name.substring(0,2); //get first two letters of first name

		int index = name.indexOf(" "); //get index number of space

		String last_initials = name.substring(index + 1, index + 3);// get first two letters of last name

		int initials_math = ((int)name.charAt(0) + (int)name.charAt(index + 1)) * name.length(); //convert initials to integer values add and multiply by length of name

		String invoice = String.format("%S%S%d%tm%td%tH%tM",first_initials, last_initials, initials_math, currentDateTime, currentDateTime, currentDateTime, currentDateTime);

		return invoice;


	}//end invoice number method

	//get invoice method -- builds the invoice

	static void getInvoice(String[] menuItems, String[] invoice, int [] quantity, double[] prices, String invoiceNumber, char dollar_sign, LocalDateTime currentDateTime){

		double salesTax = 6.25;
		char percent = '%';
		double subTotal = 0;
		double total = 0;
		String pattern = "##.##"; //pattern for decimal formatter
		DecimalFormat price_format = new DecimalFormat(pattern);
		

		String format = "%-30s%10d%10c%.2f%10c%.2f";

		invoice[0] = String.format("Invoice Number: %32s",invoiceNumber);
		invoice[1] = String.format("Date: %28tm%c%td%c%tY", currentDateTime, '/', currentDateTime,'/', currentDateTime);
		invoice[2] = String.format("Time: %34tT%n", currentDateTime, currentDateTime);
		invoice[3] = " ";
		invoice[4] = String.format("%-30s%10s%14s%14s", "Item", "Quantity", "Price", "Total");
		invoice[5] = " ";
		invoice[6] = String.format("=====================================================================");
		invoice[7] = " ";

		//loop to print the receipt portion

		int y = 0;

		for (int x = 8; x < 14; x++){

			total = quantity[y] * prices[y];
			subTotal+=total;

			invoice[x] = String.format(format, menuItems[y], quantity[y],dollar_sign, prices[y], dollar_sign, total);

			x+=1;

			invoice[x] = " ";

			y+=1;
		}//end for loop

		double tax = subTotal * (salesTax / 100);
		double grandTotal = subTotal + tax;

		invoice[14] = invoice[6];
		invoice[15] = " ";
		invoice[16] = String.format("%-30s%34c%s","Subtotal:",dollar_sign, price_format.format(subTotal));
		invoice[17] = " ";
		invoice[18] = String.format("%s%c%59c%s",price_format.format(salesTax), percent,dollar_sign, price_format.format(tax));
		invoice[19] = String.format("%70s","-------");
		invoice[20] = String.format("Total: %57c%s",dollar_sign, price_format.format(grandTotal));



	}//end getInvoice method



	public static void main(String[] args){

		//declare arrays

		String[] menuItems = new String[3];
		double[] prices = new double[3];
		int [] quantity = new int[3];
		String [] invoice = new String[21];
		char dollar_sign = '$';

		LocalDateTime currentDateTime = LocalDateTime.now();

		Scanner input = new Scanner(System.in); //create the input scanner

		getMenu(menuItems);//call method to get menu items
		getPrices(prices);//call method to get prices


		System.out.println("\nWelcome to the CS food truck. (If you're lucky Colin is cooking)");
		System.out.print("\nEnter your name (First and last): ");//get users name 

		String name = input.nextLine();//store name

		String invoiceNumber = getInvoiceNum(name, currentDateTime);//get and store invoice number


		System.out.print("\nEnter quantity of each item. (Enter 0 for none)\n");
		System.out.println("\n================================================================");
		System.out.println();

		//get user quantities input

		for (int x = 0; x < 3; x++){

			String format = "%-30s %c%-10.2f  Enter Quantity: ";
			String line = String.format(format,menuItems[x], dollar_sign, prices[x]);
			System.out.print(line);
			quantity[x] = input.nextInt();
			
		}//end for loop for input

		getInvoice(menuItems, invoice, quantity, prices, invoiceNumber, dollar_sign, currentDateTime); //calls method to build the invoice

		System.out.printf("\n%40s\n","INVOICE");
		System.out.printf("%40s\n", "=======");
		System.out.println(" ");

		//print/write receipt

		try{

		String file = invoiceNumber + ".txt";//set name of invoice file to write to

		BufferedWriter buffer_invoice = new BufferedWriter(new FileWriter(file));//create the buffer and file writer

		for (int i = 0; i < 21; i++){

			System.out.println(invoice[i]);//output line to screen
			buffer_invoice.write(invoice[i]);//write line to buffer
			buffer_invoice.newLine();//move buffer to next line

		}//end for print loop

		buffer_invoice.flush();//print buffer to file
		buffer_invoice.close();//close buffer
		}//end try

		catch (IOException e){

			System.out.println("Oops there was a problem with the write to file.");
		}//end of catch

	}//end main

}//end public class