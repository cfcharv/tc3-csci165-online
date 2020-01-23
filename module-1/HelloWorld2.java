//Mike Harvey
//Module 1 HelloWorld with args CSCI 165
//1/22/2020

//file name must match public class identifier

public class HelloWorld2{

	//main method is the starting point
	public static void main(String[] args){

		System.out.print("Hello");

		//loop through the arguments
		
		for (String s : args){

			System.out.print(" " + s);

		}//end for loop

		System.out.print(". Nice work processing the arguments.");

	}//end of main
}//end of class