import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AngelListStartupJSONtoCSV {
	private static ArrayList<StartupData> allStartupListings;
	private static ArrayList<String> allStartupLocations;
	private static ArrayList<String> allStartupMarkets;
	private static ArrayList<String> allStartupTypes;
	public static void main(String[] args) throws Exception {
		setupArrays();
		readFromFile("Startups_2001-2200");
		
		// Write all job listings to a .csv file in order of series
		PrintWriter startupWriter = new PrintWriter("allStartupListings.csv", "UTF-8");
		for(StartupData j : allStartupListings) {
			startupWriter.println(j.toString());
		}	
		startupWriter.close();
		
		// Write all job listings to a .csv file in order of series
		PrintWriter locationWriter = new PrintWriter("allStartupLocations.csv", "UTF-8");
		for(String j : allStartupLocations) {
			locationWriter.println(j);
		}	
		locationWriter.close();
		
		// Write all job listings to a .csv file in order of series
		PrintWriter marketWriter = new PrintWriter("allStartupMarkets.csv", "UTF-8");
		for(String j : allStartupMarkets) {
			marketWriter.println(j);
		}	
		marketWriter.close();
		
		// Write all job listings to a .csv file in order of series
		PrintWriter typeWriter = new PrintWriter("allStartupTypes.csv", "UTF-8");
		for(String j : allStartupTypes) {
			typeWriter.println(j);
		}
		typeWriter.close();
	}
	
    // Used an open source JSON parser
    // Run with the .jar from http://mvnrepository.com/artifact/org.json/json
	private static void JSONToCSV(String startupObject) throws Exception {
	    String id, communityProfile, name, angellistUrl, quality;
		String highConcept, companyUrl, companySize, status;
		StartupData startupData;
		
		ArrayList<String> marketTags, locationTags, companyTypes;

		try {
    		JSONObject startup = new JSONObject(startupObject);
    		id = startup.get("id") + "";
    		System.out.println(id);
    		if (!startup.getBoolean("hidden")) {
    			
	    		name = startup.get("name") + "";
	    		angellistUrl = startup.get("angellist_url") + "";
	    		quality = startup.get("quality") + "";
	    		highConcept = startup.get("high_concept") + "";
	    		companyUrl = startup.get("company_url") + "";

	    		marketTags = new ArrayList<>();
	    		JSONArray market = startup.getJSONArray("markets");
	    		for (int k = 0; k < market.length(); k++) {
	    			JSONObject marketTag = market.getJSONObject(k);
	    			allStartupMarkets.add(id + "," + marketTag.getString("name"));
	    		}
	    		
	    		locationTags = new ArrayList<>();
	    		JSONArray location = startup.getJSONArray("locations");
	    		for (int k = 0; k < location.length(); k++) {
	    			JSONObject locationTag = location.getJSONObject(k);
	    			allStartupLocations.add(id + "," + locationTag.getString("name"));
	    		}
	    		
    			companySize = startup.get("company_size") + "";
   
    			companyTypes = new ArrayList<>();
    			JSONArray type = startup.getJSONArray("company_type");
    			for (int k = 0; k < type.length(); k++) {
	    			JSONObject companyType = type.getJSONObject(k);
	    			allStartupTypes.add(id + "," + companyType.getString("name"));
	    		}
	    		status = startup.get("status") + "";
	    		
	    		startupData = new StartupData(id,
	    				name, angellistUrl, quality,
	    				highConcept, companyUrl, companySize);
	    		allStartupListings.add(startupData);
	    	}
		} catch (JSONException e) {
		    e.printStackTrace();
		}
	}
	
	private static void readFromFile(String path) throws Exception {
		FileReader fr = new FileReader(path);
	    BufferedReader reader = new BufferedReader(fr);
	    String next;
	    while ((next = reader.readLine()) != null) {
	    	JSONToCSV(next);
	    }
	}
	
	private static void setupArrays() {
		allStartupListings = new ArrayList<>();
		allStartupListings.add(new StartupData("STARTUPID", "NAME", "ANGELLISTURL", "QUALITY", 
				"HIGHCONCEPT", "COMPANYURL", "COMPANYSIZE"));
		allStartupLocations = new ArrayList<>();
		allStartupLocations.add("STARTUPID, LOCATION");
		allStartupMarkets = new ArrayList<>();
		allStartupMarkets.add("STARTUPID, MARKETTYPE");
		allStartupTypes = new ArrayList<>();
		allStartupTypes.add("STARTUPID, STARTUPTYPE");
		
	}
}
