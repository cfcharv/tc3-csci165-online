//Mike Harvey
//CSCI165 Module 2 Initials
//2/3/2020

import java.util.Scanner;

public class Initials{

	public static void main(String[] args){

		String line;
		int index = 0;
		char firstInitial;
		char secondInitial;
		int totalInitials;
		String bothInitials;

		Scanner input = new Scanner(System.in);

		System.out.print("Enter your first name: ");

		line = input.next();

		

		System.out.print("Enter your last name: ");

		line = line + " " + input.next();

		firstInitial = line.charAt(0);

		index = line.indexOf(" ");

		secondInitial = line.charAt(index + 1);

		totalInitials = (int)firstInitial + (int)secondInitial;

		bothInitials = String.valueOf(firstInitial) + String.valueOf(secondInitial);

		System.out.print("\n");

		System.out.println(firstInitial + "  Numeric value = " + (int)firstInitial);
		System.out.println(secondInitial + "  Numeric value = " + (int)secondInitial);
		System.out.println(totalInitials );
		System.out.println(bothInitials);



	}
}
