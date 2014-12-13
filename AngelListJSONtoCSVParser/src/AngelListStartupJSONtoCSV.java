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
	public static void main(String[] args) throws Exception {
		allStartupListings = new ArrayList<>();
		
		readFromFile("Startups_1-793");
		
		// Write all job listings to a .csv file in order of series
		PrintWriter writer = new PrintWriter("allStartupListings.csv", "UTF-8");
		for(StartupData j : allStartupListings) {
			writer.println(j.toString());
		}	
		writer.close();
	}
	
    // Used an open source JSON parser
    // Run with the .jar from http://mvnrepository.com/artifact/org.json/json
	private static void JSONToCSV(String jsonLine) throws Exception {
		JSONObject startup;
	    StartupData startupData;
	    StringBuilder startupLine = new StringBuilder(jsonLine);
	    String id, name, angellistUrl, quality;
		String highConcept, companyUrl, companySize, companyType, status;
		
		ArrayList<String> marketTags, locationTags;

		try {
			// test query
			startup = new JSONObject(startupLine);
    		id = startup.get("id") + "";
    		if (!startup.getBoolean("hidden")) {
	    		name = startup.get("name") + "";
	    		angellistUrl = startup.get("angellist_url") + "";
	    		quality = startup.get("quality") + "";
	    		highConcept = startup.get("high_concept") + "";
	    		companyUrl = startup.get("company_url") + "";

	    		JSONArray market = startup.getJSONArray("markets");
	    		marketTags = new ArrayList<>();
	    		for (int k = 0; k < market.length(); k++) {
	    			JSONObject marketTag = market.getJSONObject(k);
	    			marketTags.add(marketTag.getString("name"));
	    		}
	    		
	    		locationTags = new ArrayList<>();
	    		JSONArray location = startup.getJSONArray("locations");
	    		for (int k = 0; k < location.length(); k++) {
	    			JSONObject locationTag = location.getJSONObject(k);
	    			locationTags.add(locationTag.getString("name"));
	    		}
	    		
    			companySize = startup.get("company_size") + "";
    			companyType = startup.get("company_type") + "";
	    		status = startup.get("status") + "";
	    		
	    		startupData = new StartupData(id,
	    				name, angellistUrl, quality,
	    				highConcept, companyUrl, marketTags,
	    				locationTags, companySize,
	    				companyType, status);
	    		allStartupListings.add(startupData);
	    	}
		} catch (JSONException e) {
		    e.printStackTrace();
		}
	}
	
	// returns the url in the format needed to parse 
	private static void readFromFile(String path) throws Exception {
		FileReader fr = new FileReader(path);
	    BufferedReader reader = new BufferedReader(fr);
	    String next;
	    while ((next = reader.readLine()) != null) {
	    	JSONToCSV(next);
	    }
	    reader.close();
	}
}
