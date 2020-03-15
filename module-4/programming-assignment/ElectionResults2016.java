import java.lang.Math;

public class ElectionResults2016 {
	
	//instance variables
	private double demVotes;
	private double gopVotes;
	private double totalVotes;
	private double percentDem;
	private double percentGOP;
	private double percentDiff;
	private String stateAbbreviation;
	private String county;
	private int fips;
	
	
	//constructor method
	
	public ElectionResults2016(double demVotes, double gopVotes, double totalVotes, double percentDem, double percentGOP, double percentDiff, String stateAbbreviation, String county, int fips) {
		
		this.demVotes = demVotes;
		this.gopVotes = gopVotes;
		this.totalVotes = totalVotes;
		this.percentDem = percentDem;
		this.percentGOP = percentGOP;
		this.percentDiff = percentDiff;
		this.stateAbbreviation = stateAbbreviation;
		this.county = county;
		this.fips = fips;
		
	}//end constructor method
	
	//getTotalVotes method
	
	public double getTotalVotes() {
		
		return this.totalVotes;	
	}//end get totalvotes
	
	//get DemVotes method
	
	public double getDemVotes() {
		
		return this.demVotes;
	}//end demVotes
	
	//get gopvotes method
	
	public double getGOPVotes() {
		
		return this.gopVotes;
	}//end getGopVotes
	
	//getPercentDifference method
	
	public double getPercentDifference() {
		
		return this.percentDiff;
	}//end percentDifference method
	
	//get State method
	
	public String getState() {
		
		return this.stateAbbreviation;
	}//end etState method
	
	//getCounty method
	
	public String getCounty() {
		
		return this.county;
	}//end getCounty method
	
	//toString method
	
	public String toString() {
		
		return this.demVotes + "," + this.gopVotes + "," + this.totalVotes + "," + this.percentDem + "," + this.percentGOP + "," + this.percentDiff + "%," + this.stateAbbreviation + "," + this.county + "," + this.fips;
	}//end toString
	
	
	

}//end election results class
