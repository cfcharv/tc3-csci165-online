import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class ElectionDriver {
	
	private static ArrayList<ElectionResults2016> results = new ArrayList<ElectionResults2016>();
	
	private static String[] state_abbrev = new String[] {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","HI","IA","ID","IL","IN","KS","KY","LA","MA","MD","ME","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VA","VT","WA","WI","WV","WY" };
	
	//fill list method
	
	public static void fillList() {
		
		
		
		try {
			File results_file = new File("2016_US_County_Level_Presidential_Results.csv");
			
			BufferedReader buff_results_read = new BufferedReader(new FileReader(results_file));
			
			String line;
			String headers = buff_results_read.readLine();//reads the header line of file
			
			while ((line = buff_results_read.readLine()) != null) {
				
				String[] values = line.split(",");
				
				values[6] = values[6].substring(0, values[6].length() -1);
				
				double demVotes = Double.parseDouble(values[1]);
				double gopVotes = Double.parseDouble(values[2]);
				double totalVotes = Double.parseDouble(values[3]);
				double percentDem = Double.parseDouble(values[4]);
				double percentGOP = Double.parseDouble(values[5]);
				double percentDiff = Double.parseDouble(values[6]);
				String stateAbbreviation = values[7];
				String county = values[8];
				int fips =  Integer.parseInt(values[9]);
				
				ElectionResults2016 county_results = new ElectionResults2016(demVotes, gopVotes, totalVotes, percentDem, percentGOP, percentDiff, stateAbbreviation, county, fips);
				
				results.add(county_results);
				
			}//end while loop
			
			buff_results_read.close();
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
	}//end filllist
	
	//find the largest margin
	
	public static ElectionResults2016 findLargestMargin() {
		
		double largest = 0;
		double current = 0;
		int largest_index = 0;
		int index = 0;
		
		for (ElectionResults2016 county : results) {
			
			current = county.getPercentDifference();
			
			if (current > largest) {
				largest = current;
				largest_index = index;
				
			}
			index ++;
		}//end for
		
		return results.get(largest_index);
		
	}//end findLargestmargin()
	
	//findLargestMargin(state) method
	
	public static ElectionResults2016 findLargestMargin(String state) {
		
		double largest = 0;
		int largest_index = 0;
		int index = 0;
		
		for (ElectionResults2016 county : results) {
			
			if (state.equals(county.getState())) {
				if (county.getPercentDifference() > largest) {
					largest = county.getPercentDifference();
					largest_index = index;
				}				
			}
			index ++;
		}//end for loop
		
		return results.get(largest_index);
	}//endFindLargest(state)
	
	public static String[] getStateTotals(){
		String[] states = new String[51];
		
		String current_state = results.get(0).getState();
		double total_dem_votes = 0;
		double total_gop_votes = 0;
		double marginOfVictory = 0;
		String winning_party = "";
		int index = 0;
		
		
		for (ElectionResults2016 county : results) {
			
			if (current_state.equals(county.getState())){
				total_dem_votes += county.getDemVotes();
				total_gop_votes += county.getGOPVotes();
				
			}//end if
			
			else {
				if (total_dem_votes > total_gop_votes) {
					winning_party = "Dem";
					marginOfVictory = total_dem_votes - total_gop_votes;
					
					states[index] = current_state + "," + total_dem_votes + "," + total_gop_votes + "," + marginOfVictory + "," + winning_party;
					
					total_dem_votes = county.getDemVotes();
					total_gop_votes = county.getGOPVotes();
					marginOfVictory = 0;
					winning_party = "";
					current_state = county.getState();
					index ++;
										
				}//endif
				
				else {
					winning_party = "GOP";
					marginOfVictory = total_gop_votes - total_dem_votes;
					
					states[index] = current_state + "," + total_dem_votes + "," + total_gop_votes + "," + marginOfVictory + "," + winning_party;
					
					total_dem_votes = county.getDemVotes();
					total_gop_votes = county.getGOPVotes();
					marginOfVictory = 0;
					winning_party = "";
					current_state = county.getState();
					index ++;
					
				}//end else
								
			}//end else				
			
		}//end for loop
		
		if (total_dem_votes > total_gop_votes) {
			winning_party = "Dem";
			marginOfVictory = total_dem_votes - total_gop_votes;
			
			
								
		}//endif
		
		else {
			winning_party = "GOP";
			marginOfVictory = total_gop_votes - total_dem_votes;		
		}
			
		
		states[index] = current_state + "," + total_dem_votes + "," + total_gop_votes + "," + marginOfVictory + "," + winning_party;
		
				
		return states;
	}//end statetotals method
	
	public static String getStateTotals(String state) {
		double total_dem_votes = 0;
		double total_gop_votes = 0;
		double marginOfVictory = 0;
		String winning_party = "";
		
		for (ElectionResults2016 county : results) {
			
			if (state.contentEquals(county.getState())) {
				
				total_dem_votes += county.getDemVotes();
				total_gop_votes += county.getGOPVotes();
				
			}//end if
		}//end for
		
		if (total_dem_votes > total_gop_votes) {
			marginOfVictory = total_dem_votes - total_gop_votes;
			winning_party = "Dem";
			
		}//end if
		
		else {
			marginOfVictory = total_gop_votes - total_dem_votes;
			winning_party = "GOP";
		}//end else
		
		return state + "," + total_dem_votes + "," + total_gop_votes + "," + marginOfVictory + "," + winning_party;
		
	}//getStateTotals(string) method
	
	//getAllStateTotals method
	
	public static String[] getAllStateTotals() {
		
		int index = 0;
		String [] totals = new String[51];
		for (String state : state_abbrev) {
			
			totals[index] = getStateTotals(state);
			index ++;
		}//end for
		
		return totals;
	}
	
	
	

	public static void main(String[] args) {
		
		
		
		fillList();//make the list of objects
				
		
		String[] state_results = new String[51];//initialize array to store state totals
		state_results = getStateTotals();//get state totals
		
		//=========================================
		//Doing the same as above using a different method that I prefer but didn't think of and outputting to test
		//commented out as it is not needed 
		
		/*
		String[] other_state_results = new String[51];
		
		other_state_results = getAllStateTotals();
		
		for (int x = 0; x < 51; x++) {
			
			System.out.println(other_state_results[x]);
		}*/
		
		
		
				
		
		try {
			
			File election_file = new File("Election_Results_2016.csv");
			BufferedWriter buff_results_write = new BufferedWriter(new FileWriter(election_file));
			
			String header = "votes_dem,votes_gop,total_votes,per_dem,per_gop,per_point_diff,state_abbr,county_name,combined_fips";
			
					
			buff_results_write.write("County with the largest margin in each state");
			buff_results_write.newLine();
			
			buff_results_write.write(header);
			buff_results_write.newLine();
			
						
			for (String state : state_abbrev) {
				
				buff_results_write.write(findLargestMargin(state).toString());
				buff_results_write.newLine();
				
			}//end for
			
			buff_results_write.write("Largest margin countrywide");
			buff_results_write.newLine();
			buff_results_write.write(findLargestMargin().toString());
			buff_results_write.newLine();
			
			buff_results_write.write("Total results by state");
			buff_results_write.newLine();
			
			header = "Sate,Total_dem_votes, Total_GOP_votes, Margin_of_Victory, Winning_Party";
			buff_results_write.write(header);
			buff_results_write.newLine();
			
			for (int x = 0; x < 51; x++) {
				
				buff_results_write.write(state_results[x]);
				buff_results_write.newLine();
				
			}
			
			buff_results_write.close();
		}//end try
		
		catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
		
		

	}//end main

}//end class
