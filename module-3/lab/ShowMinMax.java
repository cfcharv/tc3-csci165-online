import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;





	
	

	class ShowMinMax extends JPanel {

	    private static final long serialVersionUID = 1L;
	    private JFrame window = new JFrame();

	    public ShowMinMax() {
	        initUI();
	    }

	    private void initUI() {
	        window.add(this);
	        window.setTitle("2D Drawing");
	        window.setSize(500, 500);
	        window.setLocationRelativeTo(null);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setVisible(true);
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        doDrawing(g);
	    }

		// add your own drawing intructions in this method
	    private void doDrawing(Graphics g) {

	        /*
	            RGB Colors:
	            ================================================
	            Black       => (0, 0, 0)        => low elevation
	            Mid Grey    => (128, 128, 128)  => mid elevation
	            White       => (255, 255, 255)  => high elevation

	            Grey Scale colors are scaled in matching set of 3 numeric values
	        */

	        Graphics2D g2d = (Graphics2D) g;

	        //<====> ADD YOUR DRAWING CODE HERE <==========>//
	        
	        //create and fill matrix
	        
	        int [][] matrix = new int[50][20];
	        
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
	        
	        //loops to find min/max and draw grid
	        int x = 10, y = 10;
	        
	        for (int row = 0; row < 50; row++) {
	        	int row_min = matrix[row][0];
	        	int row_max = matrix[row][0];;
	        	int max_col = 0;
	        	int min_col = 0;
	        	
	        	for (int column = 0; column < 20; column++) {
	        		
	        		if (matrix[row][column] < row_min) {
	        			min_col = column;
	        			row_min = matrix[row][column];
	        		}
	        		
	        		if (matrix[row][column] > row_max) {
	        			max_col = column;
	        			row_max = matrix[row][column];
	        		}
	        	}//end column loop for min max determination
	        	
	        	for (int column = 0; column < 20; column++) {
	        		
	        		//if else statements to determine color of rect
	        		
	        		if(column == max_col) {
	        			g2d.setColor(Color.RED);
	        		}//end if
	        		
	        		else if(column == min_col) {
	        			g2d.setColor(Color.GREEN);
	        		}//end elif
	        		
	        		else {
	        			g2d.setColor(new Color(128,128,128));
	        		}//end else
	        		
	        		g2d.fillRect(x,y,10,10);
	        		x+=10;
	        		
	        	
	        	}//end column for loop for drawing
	        	
	        	y += 10;
	        	x = 10;
	        			
	        }//end row loop

	       
	    }
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() { 
	                ShowMinMax ex = new ShowMinMax();
	                ex.setVisible(true);
	            }
	        });
	    } // end main
	} // end class



