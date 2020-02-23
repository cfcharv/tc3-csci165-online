import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrixStuff {
	
	//fill the matrix method
	
	public static void fillArrayRowMajor(int[][] matrix) {
		
		try {
			
			BufferedReader buff_input_reader = new BufferedReader(new FileReader("number_list.txt"));//create filereader
			
			for (int row = 0; row < 50; row++) { //row counter
				
				for(int column = 0; column < 20; column++) {//column counter
					
					matrix[row][column] = Integer.parseInt(buff_input_reader.readLine());//add value to matrix
					
				}//end column loop
			}//end row for loop
			
			buff_input_reader.close();//close reader
			
			
		}//end try
		
		catch(IOException e) {
			System.out.println("oops something went wrong"); //catch any errors
		}//end catch
		
	}//end fill matrix method
	
	//find max method
	
	public static int findMax(int[][] matrix) {
		
		int max = 0;
		
		for (int row = 0; row < 50; row++) {
			
			for( int column = 0; column < 20; column++) {
				
				if (matrix[row][column] > max) {
					 max = matrix[row][column]; //keep running value of max 
				}//end if
			}//end column loop
		}//end row loop
		
		return max; // return max value
	}//end findMax method
	
	//find min method
	
	public static int findMin(int[][] matrix) {
		
		int min = matrix[0][0];
		
		for (int row = 0; row < 50; row++) {
			
			for (int column = 0; column < 20; column++) {
				 if (matrix[row][column] < min) {
					 min = matrix[row][column];
				 }//end if
			}//end column loop
		}//end row loop
		
		return min;
		
	}//end min method
	
	//findMaxRow method
	
	public static int findMaxOfRow(int[][] matrix, int row_num) {
		
		int max = 0;
		int row = row_num;
		
		for (int column = 0; column < 20; column++) {
			
			if ( matrix[row][column] > max) {
				
				max = matrix[row][column];
			}//end if
		}//end for loop
		
		return max;
	}//end findMaxRow method
	
	//findMinRow method
	
	public static int findMinOfRow(int[][] matrix, int row_num) {
		
		int row = row_num;
		int min = matrix[row][0];
		
		for (int column = 0; column < 20; column++) {
			
			if (matrix[row][column] < min) {
				
				min = matrix[row][column];
				
			}//end if
		}//end for loop
		
		return min;
	}//end findMinRow method
	
	//findMaxColumn method
	
	public static int findMaxOfColumn(int [][] matrix, int col_num) {
		
		int column = col_num;
		int max = 0;
		
		for (int row = 0; row < 50; row++) {
			
			if( matrix[row][column] > max) {
				
				max = matrix[row][column];
			}//end if
		}//end for loop
		
		return max;
	}//end max column method
	
	//find minColumn method
	
	public static int findMinOfColumn(int [][] matrix, int col_num) {
		
		int column = col_num;
		int min = matrix[0][column];
		
		for (int row = 0; row < 50; row++) {
			
			if (matrix[row][column] < min) {
				
				min = matrix[row][column];
			}//end if
		}//end for loop
		
		return min;
		
	}//end method
	
	//fillArrayColumnMajor method
	
	public static void fillArrayColumnMajor(int[][] matrix) {
		
		try {
			
			BufferedReader buff_input_reader = new BufferedReader(new FileReader("number_list.txt"));//create filereader
			
			for (int column = 0; column < 20; column++) { //row counter
				
				for(int row = 0; row < 20; row++) {//column counter
					
					matrix[row][column] = Integer.parseInt(buff_input_reader.readLine());//add value to matrix
					
				}//end column loop
			}//end row for loop
			
			buff_input_reader.close();//close reader
			
			
		}//end try
		
		catch(IOException e) {
			System.out.println("oops something went wrong"); //catch any errors
		}//end catch
				
	}//end fill column major method
	
	//printRow method
	
	public static void printRow(int[][] matrix, int row_num, int num_cols) {
		
		int row = row_num;
		
		for (int column = 0; column < num_cols; column++) {
			
			System.out.printf("%5d", matrix[row][column]);
			
		}//end for loop
		
	}//end printrow method
	
	//smallestChage in a row method
	
	public static int smallestChange(int[][] matrix) {
		
		int row_index = 0;
		int min_change_amount = Integer.MAX_VALUE;
		int change_amount = 0;
		
		for (int row = 0; row < 50; row++) {
			
			change_amount = 0;
			
			for (int column = 0; column < 19; column++) {
				
				change_amount += (matrix[row][column] - matrix[row][column + 1]);
			}//end column loop
			
			if (change_amount < min_change_amount) {
				
				min_change_amount = change_amount;
				row_index = row;
			}//end if			
			
		}//end row loop
		
		return row_index;
		
	}//end smallestChange method
	
	
	
	public static void main(String[] args) {
		
		int [][] matrix = new int [50][20];
		
		for ( int times = 0; times < 2; times++) {// to run main twice in both row and column major forms
			
		if ( times == 0) {
		
		fillArrayRowMajor(matrix); //fill matrix (row major)
		
		System.out.println("Results with row major matrix fill\n\n");
		}//end if
		
		else {
			fillArrayColumnMajor(matrix);
			System.out.println("\n\nResults with column major fill.\n\n");
		}//end else
		
		
		//loop to print filled matrix and row max/min
		
		for (int i = 0; i < 50; i++) {
			
			printRow(matrix, i, 20);
			
			System.out.printf("\t%s %d  %s %d \n", "Row Max:",findMaxOfRow(matrix, i)," Row Min:", findMinOfRow(matrix, i));
			
		}//end print loop
		
		//print column max an mins
		
		for (int i = 0; i < 20; i++) {
			
			System.out.printf("%5d", findMaxOfColumn(matrix, i));
			
		}//end for loop
		
		System.out.printf("\t%s\n", "Column Max Values");
		
		for (int j = 0; j < 20; j++) {
			
			System.out.printf("%5d", findMinOfColumn(matrix, j));
			
		}//end for loop
		
		System.out.printf("\t%s\n", "Column Min Values");
		
		
		System.out.printf("%s %d \n"," The row with the smallest change is: ", smallestChange(matrix));
		
		
		}//end times loop	
	}//end main
	
	

}//end class
