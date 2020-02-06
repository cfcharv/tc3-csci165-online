//Mike Harvey
//CSCI165 Java Primitives Discussion
//2/1/2020

import java.util.Scanner;
import java.lang.Math;


public class Primitives{


	public static void main(String[] args){


		// #1 defining and initializing each variable

		byte bite = 12; //byte - 8-bit

		short small = 34; //short integer - 16 bit

		int integer = 2; //integer - 32 bit

		long large = 32987; //long integer - 64 bit

		float points = 3; //floating point number - 32 bit

		double bigPoints = 12.32434; //larger floating point number - 64 bit

		char letter = 'd'; // char value defined with a character

		char code = '\u0065'; // char value with unicode definition

		boolean isDone = true;

		double answer = large / (double)integer; //widening cast

		int narrowCast = (int)bigPoints; //narrowing cast

		//lets print them out

		System.out.printf("byte = %d \n",bite);
		System.out.printf("short integer = %d, integer = %d, long integer = %d \n", small, integer, large);
		System.out.printf("float = %f, double = %f, Widecast double = %.4f, Narrow casted integer = %d \n", points, bigPoints,answer,narrowCast);
		System.out.printf("character value (literal) = %C \n", letter); //outputs capitalized version of character
		System.out.printf("character value (unicode) = %c \n", code);
		System.out.printf("boolean =%b", isDone);

		System.out.printf("\n -----------------\n");

		//#2 asing for input and processing it in the Math class

		Scanner input = new Scanner(System.in); //create the input scanner

		int value = 0; //declare the variable to hold the input
		double total = 0;

		System.out.print("Enter an integer: ");

		value = input.nextInt();


		for (int x = 2; x < 5; x++){

			total = Math.pow((double)value, (double)x);

			System.out.printf("Your input to the power of %d",x);
			System.out.print(" = ");
			System.out.print(total);
			System.out.print("\n");
		}//end loop


		//#3 Max and min integer values and compare and compareUnsigned


		System.out.println("------------------");

		int lowest = Integer.MIN_VALUE;
		int highest = Integer.MAX_VALUE;

		System.out.println("Integer max value = " + highest + "  Integer min Value = " + lowest);

		System.out.println("--------------------");

		System.out.println("Comparing " + small + " and " + integer + " The result is: " + Integer.compare(small, integer));
		System.out.println("Comparing " + lowest + " and " + integer + " The result is " + Integer.compare(lowest, integer));
		System.out.println("Comparing 5 and 5. The result is: " + Integer.compare(5,5));
		System.out.println("Comparing 15 and -8 with compareUnsigned: " + Integer.compareUnsigned(15,-8));

		//The problem with comparing signed and unsigned values is because of how negative numbers are stored
		//-8 converted to an unsigneed variable is not 8 it is 4294967288 which is much larger than 15.


		System.out.println("--------------------------");

		//#4 Using floor

		System.out.println("Let's check out floor methods.");
		System.out.println("Please enter a dividend and divisor (integers) separated by a space: ");

		int dividend = input.nextInt();
		int divisor = input.nextInt();

		double quotient = (double)dividend / divisor;
		double modulus = (double)dividend % divisor;

		System.out.printf("Let's get the result using regular division: %.4f \n", quotient);
		System.out.printf("Lets get that same result using floor: %f \n", Math.floor(quotient));
		System.out.printf("Here's the answer using modulus division: " + modulus + "\n");
		System.out.printf("Here's the answer using floor with modulus: " + Math.floor((double)dividend % divisor) + "\n");






	}//end of main

	


}//end of class