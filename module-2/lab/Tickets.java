

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Tickets{

    public static void main(String[] args){

        /* 
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt   

        */
            try{

                File ticket_file = new File("tickets.txt"); //creates the file instance for the ticket file

                Scanner ticket_scanner = new Scanner(ticket_file); //creates a scanner instance to read the ticket file object

                FileWriter valid_tix = new FileWriter("valid_tix.txt"); //create the writer to write the valid_tix file

                BufferedWriter buffer_tix = new BufferedWriter(valid_tix); //creates a buffer writer 


                //set some counters for total tickets processed and for number of valid tickets found
                int number_of_tickets = 0;
                int number_of_valid_tickets = 0;

                while (ticket_scanner.hasNextLine()){

            

                    String ticket = ticket_scanner.nextLine(); //gets the ticket number as a string. Equivalent of: String  ticket  = "123454";

                    String  last = ticket.substring(ticket.length() - 1); //gets last digit of ticket number as a string

                    int     last_digit = Integer.valueOf(last); //converts last digit string to an integer

                    String  reduced_ticket = ticket.substring(0, ticket.length() - 1); //removes the last digit from the ticket number and stores it in a new string
                    int     ticket_number = Integer.valueOf(reduced_ticket); //converts new ticket string to an integer

                    int     remainder = ticket_number % 7; //gets remainder of new ticket number divided by 7

                    boolean validity = remainder == last_digit; //checks to see if the remainder is the same as the last number of original ticket number

                    
                    String  format = "Original Ticket #: %s\nLast Digit: %d\nReduced Ticket #: %d\nRemainder: %d\nValidity: %b\n"; //sets output format of process
                    System.out.printf(format, ticket, last_digit, ticket_number, remainder, validity);//prints results of process

                    if (validity){

                        number_of_valid_tickets +=1; //counts number of valid tickets

                        buffer_tix.write(ticket); //write the valid ticket number to a file
                        buffer_tix.newLine(); //keeps valid tix file in same format as original

                    }//end of if


                 number_of_tickets +=1; //counts number of total tickets

                }//end while
                buffer_tix.flush(); //write to the file
                buffer_tix.close(); //close the buffer writer
                int invalid_tickets = number_of_tickets - number_of_valid_tickets;
                System.out.printf("Total number of tickets processed: %d \n" ,number_of_tickets);
                System.out.printf("Total number of valid tickets: %d \n",number_of_valid_tickets);
                System.out.printf("Total number of invalid tickets: %d \n" ,invalid_tickets);  

                                                                                           
            ticket_scanner.close();
            valid_tix.close();    


            }//end try

            catch (IOException e){
                System.out.println("oops there was an error with the file"); //prints an error message if there were issues
            }//end catch

      
    }//end main
}//end class