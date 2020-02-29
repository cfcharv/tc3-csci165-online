import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Scanner;
import java.util.Random;


public class elevMap extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();
    
    private int[][] elev_matrix;
    private int rows;
    private int cols;

    public elevMap(String filename) { //class constructor
        
        int index_ = filename.indexOf('_'); //index value of the underscore
        int indexx = filename.lastIndexOf('x'); // index of x between col and row ints
        int indexdot = filename.indexOf('.');//index value of the dot
        
        rows = Integer.valueOf (filename.substring(indexx + 1,  indexdot)); // slice the row and column data out of the command line argument
        cols = Integer.valueOf(filename.substring(index_+1, indexx));
        
         elev_matrix = new int[rows][cols]; //initiate matrix of elevation data
        
        try {
            
            File elev_file = new File(filename); //create file and scanner classes to read data from file
            Scanner elev_scanner = new Scanner(elev_file);
            
            
            for (int row = 0; row < rows; row++) {
                
                for (int col = 0; col < cols; col++) {
                    
                    elev_matrix[row][col] = elev_scanner.nextInt();
                    
                    
                }//end col for
            }//end row for
            
            elev_scanner.close();
        }//end try
        
        catch(FileNotFoundException e) {
            System.out.println("oops something went wrong");
        }//end catch
        
      
            
        
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("Elevation Map");
        window.setSize(cols, rows);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        
            
    }
      //find minimum value in matrix

    public int findMin() {
            int min_value = elev_matrix[0][0];
            
            for (int row = 0; row < rows; row++) {
                
                for (int col = 0; col < cols; col++) {
                    
                    if (elev_matrix[row][col] < min_value) min_value = elev_matrix[row][col];
                }//end col loop
            }//end row loop
            
            return min_value;
        }//end find min
          
        //find maximum value in matrix
        
            public int findMax() {
                
                int max_value = 0;
                
                for(int row = 0; row < rows; row++) {
                    
                    for(int col = 0; col < cols; col++) {
                        
                        
                        if (elev_matrix[row][col] > max_value) max_value = elev_matrix[row][col];
                                        
                    }//end col loop
                }//end row loop
                return max_value;
            }//end findMax method
    

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

       
        //<====> ADD YOUR DRAWING CODE HERE <==========>//
       drawMap(g);//draw the grayscale map
       
       //draw the paths and find total elev change
       int[] elev_change = new int[rows];
       for (int x = 0; x < rows ; x++) {
          elev_change[x] = drawLowestElevPath(g,x, Color.BLUE);        
       }//end for loop for paths
       
       //draw the lowest elev path
       
       int lowest_elev_change = drawLowestElevPath(g,findIndexOfLowestElevPath(elev_change),Color.RED);
       
       System.out.println("Total elevation change of the route with the least change: " + lowest_elev_change);
       
    }//end doDrawing

    //draw map function
    
 private void drawMap(Graphics g) {
     
     Graphics2D g2d = (Graphics2D) g;

    
     int max = findMax();
     int min = findMin();
     for (int row =0; row < rows; row++) {
               
               for (int col = 0; col < cols; col++) {

                //calculations to determine gsayscale shade
                   
                   double a = (elev_matrix[row][col] - min);
                   double b = (double)max - min;
                           
                   int c = (int)((a/b)*255);
                 
                   
                   g2d.setColor(new Color(c,c,c));
                   g2d.fillRect(col, row, 1, 1);
                   
               }//end col loop
           }//end row loop
     
 }//end draw map

 // function to draw lowest elev change path given a row and color to make path
    
    private int drawLowestElevPath(Graphics g, int row, Color color) {
        
        Graphics2D g2d = (Graphics2D) g;
        int col = 0;
        int total_elev_change = 0; //running total of elevation change
        int[] elev_change = new int [3]; //array to hold the three choices for next step
        g2d.setColor(color);
        Random rand= new Random();
        
        
        
        while ( col < cols) {
            int min_change = 0;
            
            if (col == 0) { g2d.fillRect(col,  row,  1, 1);} //if first column just draw the starting point
            
            else {
                
                if (row - 1 < 0) { elev_change[0] = Integer.MAX_VALUE;} //if new row falls outside of array bounds set change to max value
                
                else {
                    
                    elev_change[0] = Math.abs((elev_matrix[row-1][col] - elev_matrix[row][col-1]));
                }//end change1 else
                
                elev_change[1] = Math.abs((elev_matrix[row][col] - elev_matrix[row][col-1]));
                
                if (row + 1 >= rows){elev_change[2] = Integer.MAX_VALUE;} //if new row falls outside of array bounds set change to max value
                
                else {
                    elev_change[2] = Math.abs((elev_matrix[row +1][col] - elev_matrix[row][col -1]));
                }//end change3 else
                
                //find min value
                min_change = elev_change[0];
                for(int i= 0; i < 3; i++) {
                    
                    if (elev_change[i] < min_change) {
                        min_change = elev_change[i];
                    }//end if
                }//end for
                
                //Code to determine where to draw the current step

                //default to straight ahead if it is the lowest value regardless of ties

                if (min_change == elev_change[1]) {
                    
                    g2d.fillRect(col, row, 1, 1); 
                }//end if

                // if both upper and lower change is equal flip coin to decide where to go
                else if (min_change == elev_change[0] && min_change == elev_change[2]){
                    int coin_flip = rand.nextInt(1);
                    
                    if (coin_flip == 1) {
                        row = row - 1;
                        g2d.fillRect(col,  row, 1,1);
                    }
                    
                    else {
                        row = row + 1;
                        g2d.fillRect(col, row, 1, 1);
                    }
                }//elseif

                //if upper step is lowest
                
                else if (min_change == elev_change[0]){
                    row = row -1;
                    g2d.fillRect(col, row, 1, 1); 
                    
                }//endelseif

                //if lower step is lowest
                
                else if (min_change == elev_change[2]) {
                    row = row + 1;
                    g2d.fillRect(col, row, 1, 1); 
                }//end else
                
        
                
            }//end process else
            
        col+=1;
        total_elev_change += min_change; //keep running total of elev change
    }//end while
        return total_elev_change;
    }//endDrawlowestelev

    //function to find index of the lowest elev change path 
    
    private int findIndexOfLowestElevPath(int [] total_elev_change){
        
        int min_total = total_elev_change[0];
        int min_total_index = 0; 
        for (int x = 0; x < rows; x++) {
            
            if (total_elev_change[x] < min_total) {
                
                min_total = total_elev_change[x];
                min_total_index = x;
            }//end if
        }//end for
        
        return min_total_index;
    }//end findLowestElevPath
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                elevMap ex = new elevMap(args[0]);
                ex.setVisible(true);
            }
        });
    } // end main
} // end class