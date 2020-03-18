import java.lang.Math;

public class Fraction {

	private int numerator;
	private int denominator;
	
	//constructors
	
	//no argument constructor
	
	public Fraction() {
		
		this.numerator = 1;
		this.denominator = 1;
		
	}//end no argument constructor
	
	//constructor with two integers
	
	public Fraction (int numerator, int denominator) {
		
		setNumerator(numerator);
		setDenominator(denominator);
		
	}//end two int constructor
	
	//copy constructor
	
	public Fraction(Fraction f) {
		
		this.numerator = f.getNumerator();
		this.denominator = f.getDenominator();
	}//end copy constructor
	
	
	//getters and setters
	
	//setters with verification
	
	//setNumerator method
	
	public void setNumerator(int numerator){
		
		if (numerator < 0)
		{
			this.numerator = Math.abs(numerator);
		}
		
		else
			this.numerator = numerator;
	}//end set numerator
	
	//setDenominator
	
	public void setDenominator(int denominator) {
		
		if (denominator == 0) {
			
			this.denominator = 1;
		}//end if
		
		else if (denominator < 0) {
			
			this.denominator = Math.abs(denominator);
		}//end else if
		
		else
			this.denominator = denominator;
		
	}//end set denominator
	
	//getters
	
	//get numerator
	
	public int getNumerator() {
		
		return this.numerator;
	}//end getNumerator
	
	//get denominator
	
	public int getDenominator() {
		
		return this.denominator;
	}//end getDenominator
	
	//toDecimal method
	
	public double toDecimal() {
		
		return (double)this.numerator / this.denominator;
	}//end to decimal
	
	
	//reduce method
	
	public void reduce() {
		
		int gcd = this.gcd();
		
		int n = this.numerator / gcd;
		int d = this.denominator / gcd;
		
		this.setNumerator(n);
		this.setDenominator(d);
	}//end reduce
	
	private int gcd() {
		
		int n = this.numerator;
		int d = this.denominator;
		int gcd = 1;
		
		for (int x = 1; x <= n && x <= d; x++) {
			
			if (n % x == 0 && d % x == 0) {
			
				gcd = x;
			}//end if
		}//end for
		
		return gcd;
	}//gcd
	
	//add fractions
	
	public Fraction add(Fraction f) {
		
		int d = this.denominator * f.getDenominator();
		
		int n = (f.getNumerator() * this.denominator) + (this.numerator * f.getDenominator());
		
		Fraction sum = new Fraction(n,d);
		sum.reduce();
		
		return sum;
	}//end add
	
	//subtract fractions
	
	public Fraction subtract(Fraction f) {
		
		int d = this.denominator * f.getDenominator();
		
		int n = (this.numerator * f.getDenominator()) - (f.getNumerator() * this.denominator);
		
		Fraction difference = new Fraction(n,d);
		difference.reduce();
		
		return difference;
	}//end subtract
	
	//multiply fractions
	
	public Fraction multiply(Fraction f) {
		
		int n = this.numerator * f.getNumerator();
		int d = this.denominator * f.getDenominator();
		
		Fraction product = new Fraction (n,d);
		product.reduce();
		
		return product;
	}//end multiply
	
	//equals method
	
	public boolean equals(Fraction f) {
		
		int gcd1 = this.gcd();
		int gcdf = f.gcd();
		
		if (this.numerator / gcd1 == f.getNumerator() / gcdf && this.denominator / gcd1 == f.getDenominator() / gcdf) {
			
			return true;
		}
		
		else
			return false;
	}//end equals
	
	
	//compare method
	
	public int compareTo(Fraction f) {
		
		double r1 = this.toDecimal();
		double r2 = f.toDecimal();
		
		if (r1 == r2)
			return 0;
		
		else if (r1 < r2)
			return -1;
		
		else 
			return 1;
		
	}//end compare to
	
	//to string method
	
	public String toString() {
		
		if (numerator <= denominator)
			return numerator + "/" + denominator;
		
		else
		{
			int whole_number = numerator / denominator;
			
			int n = numerator % denominator;
			
			Fraction temp = new Fraction(n, denominator);
			
			temp.reduce();
			
			if (temp.getNumerator() == 0)
				return Integer.toString(whole_number);
			
			else
				return whole_number + " " + temp.getNumerator() + "/" + temp.getDenominator();
		}
		
	}//end to string
	
}//end class
