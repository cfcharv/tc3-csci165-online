import java.util.Random;
public class Account {
	
	//define the variables
	
	private String accountID;
	private Customer customer;
	private double balance = 0.0;
	private double creditLimit = 0.0;
	private double discountLevel = 0.0;
	private Date dateCreated;
	
	
	//constructor methods
	
	//no argument constructor
	
	public Account() {
		
	}//end no argument constructor
	
	//constructor with just customer
	
	public Account(Customer customer) {
		
		Customer cloned_cust = new Customer(customer);
		Date date = getRandomDate();
		
		this.accountID = createAccountID(customer.getFirstName(), customer.getLastName(), date.toString());
		this.dateCreated = date;
		this.creditLimit = 0.0;
		this.customer = cloned_cust;
		this.balance = 0.0;
		this.discountLevel = 0.0;
		
	}//end just customer constructor
	
	//constructor with customer, balance and credit limit parameters
	
	public Account(Customer customer, double balance, double creditLimit) {
		
		Customer cloned_cust = new Customer(customer);
		Date date = getRandomDate();
		
		this.accountID = createAccountID(customer.getFirstName(), customer.getLastName(), date.toString());
		this.dateCreated = date;
		this.creditLimit = creditLimit;
		this.balance = balance;
		this.discountLevel = 0.0;
		this.customer = cloned_cust;
		
	}//end customer, balance, credit limit constructor
	
	//create a random date method
	
	private static Date getRandomDate() {
		Random rand = new Random();
		
		int month = rand.nextInt(12) + 1;
		int day = rand.nextInt(28) + 1;
		int year = 2020 - (rand.nextInt(20) + 1);
		
		Date date = new Date(month, day, year);
		
		return date;
		
	}//end getRandomDate
	
	// create account ID method
	
	private static String createAccountID(String fname, String lname, String date) {
		
		String id = fname.toUpperCase() + lname.toUpperCase() + date;
		
		id = id.replaceAll("[AEIOU/]", "");
		
		return id;
		
	}//end create account id method
	
	//getCustomer method
	
	public Customer getCustomer() {
		
		Customer cloned_cust = new Customer(this.customer);
		return cloned_cust;
		
	}//end getCustomer method
	
	//getBalance method
	
	public double getBalance() {
		
		return balance;
	}//end get balance
	
	public double getCreditLimit() {
		
		return creditLimit;
	}//end getCreditLimit
	
	public void setCreditLimit(double creditLimit) {
		
		this.creditLimit = creditLimit;
	}//end setCreditLimit
	
	public void setBalance(double balance) {
		
		this.balance = balance;
	}//end setBalance
	
	//equals method
	
	public boolean equals(Account other_account) {
		
		return this.accountID.equals(other_account.accountID) &&
				this.customer.equals(other_account.customer)  &&
				this.balance == other_account.balance &&
				this.creditLimit == other_account.creditLimit &&
				this.discountLevel == other_account.discountLevel &&
				this.dateCreated.equals(other_account.dateCreated);
	}//end equals method
	
	//compareTo method
	
	public int compareTo(Account other_account) {
		
		int comparison;
		
		if (this.balance < other_account.balance)
			comparison = -1;
		
		else if (this.balance == other_account.balance)
			comparison = 0;
		
		else 
			comparison = 1;
		
		return comparison;
	}//end compare to method
	
	//toString method
	
	public String toString() {
		
		return String.format("Account ID: %s\tDate Created: %s\n%s\nBalance: %.2f\tCredit Limit: %.2f\nDiscount Level: %.2f",this.accountID,this.dateCreated.toString(),this.customer.toString(),this.balance, this.creditLimit, this.discountLevel);
		
	}//end toString method
	
}//end class
