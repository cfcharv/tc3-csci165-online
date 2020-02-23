

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;



	
	

	class ChessBoard extends JPanel {

	    private static final long serialVersionUID = 1L;
	    private JFrame window = new JFrame();

	    public ChessBoard() {
	        initUI();
	    }

	    private void initUI() {
	        window.add(this);
	        window.setTitle("2D Drawing");
	        window.setSize(850, 850);
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
	        
	        int x = 10, y = 10;
	        for (int j = 0; j < 8; ++j) {
	        	
	        
	        for (int i = 0; i < 8; ++i) {
	        	
	        	if ((i % 2 == 0 && j % 2 == 0) || (j % 2 != 0 && i % 2 != 0)){
	        		g2d.setColor(Color.BLUE);
	        	}//end if
	        	
	        	else {
	        		g2d.setColor(Color.YELLOW);
	        	}//end else
	        	
	        	g2d.fillRect(x,  y,  100, 100);
	        	
	        	x+=100;
	        }//end print row loop
	        	x = 10;
	        	y+=100;
	        }//end row count loop
	       
	    }
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() { 
	                ChessBoard ex = new ChessBoard();
	                ex.setVisible(true);
	            }
	        });
	    } // end main
	} // end class


