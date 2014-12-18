package StartupData;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AngelListStartupJSONtoCSV {
	private static ArrayList<StartupListing> allStartupListings;
	private static ArrayList<String> allStartupLocations;
	private static ArrayList<String> allStartupMarkets;
	private static ArrayList<String> allStartupTypes;
	private static String[] StartupFiles;

	public static void main(String[] args) throws Exception {
		setupArrays();

		for (int i=0 ; i < StartupFiles.length; i++) {
			readFromFile("Startups_" + StartupFiles[i]);
		}
		
		printToFile(allStartupListings, "StartupListings");
		printToFile(allStartupLocations, "StartupLocations");
		printToFile(allStartupMarkets, "StartupMarkets");
		printToFile(allStartupTypes, "StartupTypes");
	}
	
    // Used an open source JSON parser
    // Run with the .jar from http://mvnrepository.com/artifact/org.json/json
	private static void parseJSONtoList(String startupObject) throws Exception {
	    String id, name, quality, highConcept, companyUrl, companySize;
		StartupListing startupData;

		try {
    		JSONObject startup = new JSONObject(startupObject);
    		id = startup.get("id") + "";
    		if (!startup.getBoolean("hidden")) {
    			
	    		name = startup.get("name") + "";
	    		quality = startup.get("quality") + "";
	    		highConcept = startup.get("high_concept") + "";
	    		companyUrl = startup.get("company_url") + "";

	    		JSONArray market = startup.getJSONArray("markets");
	    		for (int k = 0; k < market.length(); k++) {
	    			JSONObject marketTag = market.getJSONObject(k);
	    			allStartupMarkets.add("$"  + id + "," + marketTag.getString("name") + "$" );
	    		}
	    		
	    		JSONArray location = startup.getJSONArray("locations");
	    		for (int k = 0; k < location.length(); k++) {
	    			JSONObject locationTag = location.getJSONObject(k);
	    			allStartupLocations.add("$" + id + "," + locationTag.getString("name") + "$" );
	    		}
	    		
    			companySize = startup.get("company_size") + "";
   
    			JSONArray type = startup.getJSONArray("company_type");
    			for (int k = 0; k < type.length(); k++) {
	    			JSONObject companyType = type.getJSONObject(k);
	    			allStartupTypes.add("$" + id + "," + companyType.getString("name") + "$" );
	    		}
	    		
	    		startupData = new StartupListing(id,
	    				name, quality, highConcept, companyUrl, companySize);
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
	    	parseJSONtoList(next);
	    }
	}
	
	private static void printToFile(ArrayList listToPrint, String fileName) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("all" + fileName + ".csv", "UTF-8");
			for(int i = 0; i < listToPrint.size(); i++) {
				writer.println(listToPrint.get(i).toString());
			}	
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private static void setupArrays() {
		allStartupListings = new ArrayList<>();
		allStartupLocations = new ArrayList<>();
		allStartupMarkets = new ArrayList<>();
		allStartupTypes = new ArrayList<>();
		StartupFiles = new String[6];
		StartupFiles[0] = "1-1000";
		StartupFiles[1] = "1001-2000";
		StartupFiles[2] = "2001-3000";
		StartupFiles[3] = "3001-3500";
		StartupFiles[4] = "6001-7000";
		StartupFiles[5] = "7001-8000";
	}
}
