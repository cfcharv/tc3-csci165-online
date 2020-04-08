import java.util.ArrayList;

public class Invoice {

	private String invoiceNumber;
	private Account account;
	private Date orderDate;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	
	
	//constructors
	
	//default constructor
	
	public Invoice() {
		
	}//end default constructor
	
	//account date constructor
	
	public Invoice(Account acct, Date date) {
		
		//clone account
		
		Account cloned_acct = new Account(acct);
		
		this.account = cloned_acct;
		this.orderDate = date;
		this.invoiceNumber = createInvoiceNumber(acct.getCustomer().getFirstName(), acct.getCustomer().getLastName(), date.toString());
	}//end account date constructor
	
	//Helper method to create invoice number
	
	private String createInvoiceNumber(String fname, String lname, String dateString) {
		
		String date = dateString.replaceAll("/","");
		
		String invoiceNumber = fname + lname + date;
		return invoiceNumber;
		
	}//end invoice number helper method
	
	//getAccount method
	
	public Account getAccount() {
		
		//clone account
		
		Account cloned_acct = new Account(this.account);
		
		return cloned_acct;
	}//end getAccount method
	
	//getDate method
	
	public Date getDate() {
		
		return orderDate;
	}//end getDate
	
	//getAmountDue method
	
	public double getAmountDue() {
		
		double total = 0.0;
		
		for (int i = 0; i < products.size(); i++) {
			
			total += products.get(i).getPrice();
		}//end loop
		
		return total;
	}//end getAmountDue
	
	//addProduct method
	
	public void addProduct(Product p) {
		
		this.products.add(p);
	}//end addProduct method
	
	//compareTo method
	
	public int compareTo(Invoice other_invoice) {
		
		int comparison = 0;
		
		if (this.getAmountDue() < other_invoice.getAmountDue())
			comparison = -1;
		
		else if (this.getAmountDue() > other_invoice.getAmountDue())
			comparison = 1;
		
		else
			comparison = 0;
		
		return comparison;
				
	}//end compareTo method
	
	//toStringmethod
	
	public String toString() {
		
		String invoicestr ="Invoice Number: " + invoiceNumber + "\tDate: " + orderDate.toString() + "\tAccount Number: " + account.getAccountID() + "\n\n";
		
		for (Product p : products) {
			
			invoicestr += p.toString() + "\n";
		}//end product loop
		
		invoicestr += "\n";
		
		invoicestr += String.format("%74s%.2f", "Total: ",  getAmountDue());
		
		return invoicestr;
		
		
	}//end to string
	
	
	
	
	
	
}//end class
