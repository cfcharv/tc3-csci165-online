


public class Driver {
	
	//initializing and setting some values for the arrays
	
	private static int[] numerators = {1,2,3,4,11,6,7,8,13};
	private static int[] denominators = {2,5,4,6,3,8,21,13,5};
	
	
	

	public static void main(String[] args) {
		
		Fraction[] fractions = new Fraction[9]; //initialize the array of fractions
		
		
		//for loop to populate fractions array
		
		for (int i = 0; i < 9; i++) {
			
			fractions[i] = new Fraction(numerators[i], denominators[i]);
			
		}//end for loop
		
		//for loop to reduce and print the fractions in the array
		
		System.out.println("List of reduced fractions");
		
		
		for (int i = 0; i < 9; i++)
		{
			fractions[i].reduce();//reduce the fraction actually changing the values in the object
			
			System.out.println(fractions[i].toString());
			
		}//end printing and reducing for loop
		
		//for loop to find and output the smallest and lowest fractions
		
		//initialize some variables to find largest and smallest
		
		int largest_index = 0;
		int smallest_index = 0;
		double largest = 0;
		double smallest = fractions[0].toDecimal();//sets the value of smallest to the first fraction of the array
		
		for (int i = 0; i < 9; i++) {
			
			if (fractions[i].toDecimal() < smallest) {
				
				smallest = fractions[i].toDecimal();
				smallest_index = i;
			}//end find smallest if
			
			if (fractions[i].toDecimal() > largest) {
				
				largest = fractions[i].toDecimal();
				largest_index = i;
			}//end find largest if
				
		}//end find largest/smallest loop
		
		System.out.println(" ");
		System.out.println("The largest fraction in the list is: " + fractions[largest_index]);
		System.out.println("The smallest fraction is: " + fractions[smallest_index]);
		
		//lets list the fractions as decimals
		
		System.out.println(" ");
		System.out.println("Let's see the list as decimals");
		
		for (int i = 0; i < 9; i++) {
			
			System.out.println(fractions[i].toDecimal());
		}//end for loop
		
		//ok lets run some test output
		
		//testing the constructor with negative values and a zero denominator
		
		Fraction test = new Fraction(-2,-3);
		Fraction test1 = new Fraction(2,0);
		
		System.out.println(" ");
		System.out.println("Final output of fractions constructed with (-2,-3) and (2,0) respectively: " + test.toString() + " and " + test1.toString());
		
		System.out.println(" ");
		System.out.println("Ok, Let's add, subtract, multiply and divide the first two fractions of our list 1/2 and 2/5");
		System.out.println("Add: " + fractions[0].add(fractions[1]));
		System.out.println("Subtract: " + fractions[0].subtract(fractions[1]));
		System.out.println("Multiply: " + fractions[0].multiply(fractions[1]));
		
		System.out.println(" ");
		System.out.println("Ok lets compare some fractions. 0 means they are equal, 1 means the first is greater than the second and -1 means the first is less than the second.");
		
		//create the fraction objects to test
		
		Fraction f = new Fraction(1,2);
		Fraction f1 = new Fraction(2,3);
		Fraction f2 = new Fraction(4,6);
		
		//now let's compare them and show the results
		
		System.out.println("1/2 vs. 2/3 returns: " + f.compareTo(f1));
		System.out.println("2/3 vs. 1/2 returns: " + f1.compareTo(f));
		System.out.println("2/3 vs. 4/6 returns: " + f1.compareTo(f2));
		
		//Finally let's check the copy constructor
		
		Fraction original = new Fraction(7,8);//create the original
		
		Fraction clone = new Fraction(original);//make the clone
		
		System.out.println(" ");
		System.out.println("Let's see what happens when we do a shallow and deep comparison of our clone and original.");
		System.out.println("The result of original == clone is: " + (original == clone));
		System.out.println("The result of original.equals(clone) is : " + original.equals(clone));
		
		
		
		
	}//end main

}//end class
