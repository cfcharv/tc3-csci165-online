import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvoiceTest {
	
	

	@Test
	void testGetAmountDue() {
		//create the objects
		Address home_address = new Address("123 PCH", 13021);
		Customer iron_man = new Customer("Tony", "Stark", "tony@avengers.com", home_address);
		
		Account acct = new Account(iron_man, 5000, 2500);
		Date date = new Date(3,21,2020);
		
		Invoice invoice1 = new Invoice(acct,InvoiceDriver.getTodayDate());
		Invoice invoice2 = new Invoice(acct, date);
		
		Product product = new Product("peach","fruit",2.00);
		
		invoice1.addProduct(product);
		
		invoice2.addProduct(product);
		invoice2.addProduct(product);
		
		assertEquals(2, invoice1.getAmountDue());
		assertEquals(4, invoice2.getAmountDue());
		
		
	}

	@Test
	void testCompareTo() {
		//create the objects
		Address home_address = new Address("123 PCH", 13021);
		Customer iron_man = new Customer("Tony", "Stark", "tony@avengers.com", home_address);
				
		Account acct = new Account(iron_man, 5000, 2500);
		Date date = new Date(3,21,2020);
				
		Invoice invoice1 = new Invoice(acct,InvoiceDriver.getTodayDate());
		Invoice invoice2 = new Invoice(acct, date);
				
		Product product = new Product("peach","fruit",2.00);
				
		invoice1.addProduct(product);
				
		invoice2.addProduct(product);
		invoice2.addProduct(product);	
		
		assertEquals(invoice1.compareTo(invoice2), -1);
		assertEquals(invoice2.compareTo(invoice1), 1);
		
		invoice1.addProduct(product);
		
		assertEquals(invoice1.compareTo(invoice2), 0);
		
		
	}

}
