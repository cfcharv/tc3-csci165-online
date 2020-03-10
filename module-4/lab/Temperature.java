import java.lang.Math;

public class Temperature {
	
	//instance variables
	
	private double temp_value;
	private String temp_scale;
	
	//constructors
	
	public Temperature() {
		
		this.temp_value = 0;
		this.temp_scale = "C";
	}//end no argument constructor
	
	//constructor with temp and scale parameters
	
	public Temperature(double temp_value, String temp_scale) {
		
		setTempVal(temp_value);
		setTempScale(temp_scale);
		
	}//end constructor with arguments
	
	//set temp value method
	
	public void setTempVal(double temp_value) {
		
		if (temp_value < -200 || temp_value > 200) {
			
			this.temp_value = 0;
		}
		
		else
			this.temp_value = temp_value;
	}//end set temp value method
	
	//set temp scale method
	
	public void setTempScale(String temp_scale) {
		
		if (temp_scale.equals("C")) {
			
			this.temp_scale = "C";
		}
		
		else if (temp_scale.equals("F")) {
			
			this.temp_scale = "F";
		}
		
		else
			this.temp_scale = "C";
		
	}//end set scale methods
	
	//method to set temp value and scale
	
	public void setTempValScale(double temp_value, String temp_scale) {
		
		setTempVal(temp_value);
		setTempScale(temp_scale);
		
	}//end set value and scale method
	
	//method to get temp value
	
	public double getTempVal() {
		return this.temp_value;
	}//end getTempVal
	
	//method to get temp scale
	
	public String getTempScale() {
		return this.temp_scale;
	}//end getTempScale method
	
	//method to convert from fahrenheit to celsius
	
	private double convertToC(double temp_value) {
		
		
		double degreesC = ((5 * (temp_value - 32)) / 9);
		
		degreesC = (double)Math.round(degreesC *10) / 10;
		return degreesC;
	}// end convert to C method
	
	//method to convert to fahrenheit
	
	private double convertToF(double temp_value) {
		
		
		double degreesF = (9 *(temp_value / 5)) + 32;
		degreesF = (double)Math.round(degreesF * 10) / 10;
		return degreesF;
	}//end fahrenheit conversion
	
	//get temp value in Fahrenheit method
	
	public double getTempF() {
		
		if (temp_scale =="F") {
			return temp_value;
		}
		
		else
			return convertToF(temp_value);
	}//end getTempF method
	
	//get temp in celsius
	
	public double getTempC() {
		
		if (temp_scale == "C") {
			return temp_value;
		}
		
		else 
			return convertToC(temp_value);
	}//end getTempC method
	
	
	//equals comparisson method
	
	public boolean equals(Temperature t) {
		
		boolean compare;
		
		if (this.temp_scale == t.temp_scale){
			compare = this.temp_value == t.temp_value;
		}
		
		else if (this.temp_scale == "F") {
			compare = this.temp_value == t.getTempF();
		}
		
		else
			compare = this.temp_value == t.getTempC();
		
		
		return compare;
	}//end equals comparison
	
	//to string method
	public String toString() {
		
		return temp_value + " degrees " + temp_scale;
	}//end to string
	
	//compare method
	
	public int compareTo(Temperature t) {
		
		if (this.temp_scale == "C") {
			
			if (this.temp_value > t.getTempC())
				return 1;
			
			else if (this.temp_value < t.getTempC())
				return -1;
			
			else
				return 0;
		}//end if celsius
		
		else {
			if (this.temp_value > t.getTempF())
				return 1;
			
			else if (this.temp_value < t.getTempF())
				return -1;
			
			else
				return 0;
		}//end else
	}//end compare to
	
	

}//end of class


