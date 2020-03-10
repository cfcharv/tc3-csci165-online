
public class Driver {
	
	public static void main (String[] args) {
		
		//create temp instances
		Temperature[] temperatures = new Temperature[5];
		
		temperatures[0] = new Temperature(0,"C");
		temperatures[1] = new Temperature(32,"F");
		temperatures[2] = new Temperature(-40,"F");
		temperatures[3] = new Temperature(100,"C");
		temperatures[4] = new Temperature(-40,"C");
		
		
		//loop to print starting values
		System.out.println("Here are the starting temp values");
		
		for (Temperature t : temperatures) {
			
			System.out.println(t.toString());
			
		}//end  print loop
		
		System.out.println(" ");
		System.out.println("Let's compare the values");
		System.out.println(" ");
		
		//loop to print comparison values
		for (int i = 0; i < 4; i++) {
			
			System.out.println(temperatures[i].toString() + " compared to " + temperatures[i +1].toString() +" results in " + temperatures[i].compareTo(temperatures[i + 1]));
		}//end compare loop
		
		//Let's see if two Temperatures equal each other
		System.out.println(" ");
		System.out.println("Let's check to see if two temps equal each other");
		System.out.println(" ");
		
		if (temperatures[0].equals(temperatures[1]))
			System.out.println("Yes " + temperatures[0].toString() + " equals " + temperatures[1].toString());
		
		else
			System.out.println("No these temps do not equal each other.");
		
		//Let's change a couple values and get the conversions from one scale to another
		
		temperatures[2].setTempValScale(98.2,"C");
		temperatures[3].setTempVal(25);
		temperatures[3].setTempScale("F");
		
		System.out.println(" ");
		System.out.println("Let's change a couple values then print some conversions");
		System.out.println(" ");
		
		System.out.println(temperatures[3].toString() + " is " + temperatures[3].getTempC() +" in Celsius.");
		System.out.println(temperatures[2].toString() + " is " + temperatures[2].getTempF() + " in Fahrenheit.");

		System.out.println(" ");
		System.out.println("Let's see what the final object values are");
		System.out.println(" ");

		for (Temperature t : temperatures){

			System.out.println(t.toString());
		}//end print for
		
		
	}//end main

}
