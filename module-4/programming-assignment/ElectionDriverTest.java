import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ElectionDriverTest {
	
	
	
	@BeforeAll
	static void createObject() throws FileNotFoundException{
		ElectionDriver.fillList();
	}
	
	

	@Test
	void testFindLargestMargin() {
		
		ElectionResults2016 largest_county = ElectionDriver.findLargestMargin();
		
		
		
		assertEquals(91.64, largest_county.getPercentDifference());
		assertEquals("TX" , largest_county.getState());
		assertEquals("Roberts County", largest_county.getCounty());
		
		
	}

	@Test
	void testFindLargestMarginString() {
		
		ElectionResults2016 largest_county = ElectionDriver.findLargestMargin("NY");
		
		assertEquals(79.13, largest_county.getPercentDifference());
		assertEquals("Bronx County", largest_county.getCounty());
		assertEquals(318403, largest_county.getDemVotes());
	}

	@Test
	void testGetStateTotals() {
		
		String[] totals = new String[51];
		
		totals = ElectionDriver.getStateTotals();
		
		assertEquals("RI,249902.0,179421.0,70481.0,Dem", totals[39]);
		assertEquals(totals[39], ElectionDriver.getStateTotals("RI"));
	}

}
