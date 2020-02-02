//Mike Harvey
//CSCI 165 Module 1: Problem 10
//1/27/2020


public class shapes{

	//triangle print method
	static void triangle(){
		for (int i = 0; i < 5; i++){

			for (int z = 0; z < 5 - i; z++){

				System.out.print("*");
			}//end print loop

			System.out.print("\n");
		}//number of lines loop

		System.out.println(" ");
	}//end method


	//circle print method
	static void circle(){
		for (int i = 0; i < 5; i++){

			if (i == 0 || i == 4){

				System.out.println("*****");
			}//end if

			else{
				System.out.println("*   *");
			}///end else
		}//end loop

		System.out.println(" ");
	}//end method

	//hourglass print method
	static void hourglass(){

		for (int i = 0; i < 5; i++){

			if (i == 0 || i == 4){

				System.out.println("*****");
			}//end of if

			else if (i == 1 || i == 3){

				System.out.println(" *** ");
			}//end of elif

			else{

				System.out.println("  *  ");
			}//end else
		}//end of for loop

		System.out.println(" ");
	}//end of method



	public static void main(String[] args){

		if (args.length == 0){



		triangle();
		circle();
		hourglass();

		}//end no args if

		else{

			for (String s : args){

				if (s.equals("circle")){

					circle();
				}//end circle if

				else if (s.equals("triangle")){

					triangle();
				}//ed triangle if

				else if (s.equals("hourglass")){

					hourglass();
				}//end hourglass if

				else{

					System.out.println("Sorry, I don't know that shape.");
					System.out.println(" ");
				}//else 
			}//end args for loop
		}//end args else
	}//end of main


}//end of class