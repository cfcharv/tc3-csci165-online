//Mike Harvey
//CSCI165 Mod 2 discuss GMT
//2/3/2020

import java.util.Scanner;

public class GMT{

	public static void main(String[] args){

		long milliseconds = 0;
		long seconds = 0;
		long minutes = 0;
		long hours = 0;
		double offsetHours = 0;
		double offset = 0;

		Scanner input = new Scanner(System.in);

		System.out.print("Enter your GMT time zone offset in hours: ");

		offsetHours = input.nextDouble();
		

		offset =(offsetHours * 3600) * 1000;


		long time = System.currentTimeMillis();

		time = time + (long)offset;

		milliseconds = time % 1000;
		seconds = (time / 1000) % 60;
		minutes = (time / (1000 * 60))% 60;
		hours = (time / (1000 * 60 * 60)) % 24;


		System.out.printf("%02d:%02d:%02d.%d", hours, minutes, seconds, milliseconds);



	}
}