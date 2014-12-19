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
	private static ArrayList<StartupListing> allStartupListings;	// all startups
	private static ArrayList<String> allStartupLocations;	// relation for startup to locations
	private static ArrayList<String> allStartupMarkets;		// relation for startup to markets
	private static ArrayList<String> allStartupTypes;		// relation for startup to types
	private static String[] StartupFiles;		// files to read

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
	/**
	 * Parse the JSON string into a startupData object,
	 * and add it to the appropriate list.
	 * @param startupObject	json formatted string
	 */
	private static void parseJSONtoList(String startupObject) throws Exception {
	    String id, name, quality, highConcept, companyUrl, companySize, thumbUrl;
		StartupListing startupData;

		try {
    		JSONObject startup = new JSONObject(startupObject);
    		id = startup.get("id") + "";
    		System.out.println(id);
    		// if not hidden, get all the data
    		if (!startup.getBoolean("hidden")) {
    			
	    		name = startup.get("name") + "";
	    		quality = startup.get("quality") + "";
	    		highConcept = startup.get("high_concept") + "";
	    		companyUrl = startup.get("company_url") + "";
	    		thumbUrl = startup.get("thumb_url") + "";

	    		// for each market type the startup is listed as,
	    		// add to the markets list.
	    		JSONArray market = startup.getJSONArray("markets");
	    		for (int k = 0; k < market.length(); k++) {
	    			JSONObject marketTag = market.getJSONObject(k);
	    			allStartupMarkets.add(id + "," + marketTag.getString("name"));
	    		}
	    		// for each location the startup is listed as,
	    		// add to the location list.
	    		JSONArray location = startup.getJSONArray("locations");
	    		for (int k = 0; k < location.length(); k++) {
	    			JSONObject locationTag = location.getJSONObject(k);
	    			allStartupLocations.add( id + "," + locationTag.getString("name"));
	    		}
	    		
    			companySize = startup.get("company_size") + "";
    			// for each company type the startup is listed as,
	    		// add to the type list.
    			JSONArray type = startup.getJSONArray("company_type");
    			for (int k = 0; k < type.length(); k++) {
	    			JSONObject companyType = type.getJSONObject(k);
	    			allStartupTypes.add(id + "," + companyType.getString("name"));
	    		}
	    		
    			// crate a startupData object to hold all the information
	    		startupData = new StartupListing(id,
	    				name, quality, highConcept, companyUrl, companySize, thumbUrl);
	    		allStartupListings.add(startupData);
	    	}
		} catch (JSONException e) {
		    e.printStackTrace();
		}
	}
	
	/**
	 * Read from the file and parse line by line.
	 * @param path		path to file
	 * @throws Exception	file not found
	 */
	private static void readFromFile(String path) throws Exception {
		FileReader fr = new FileReader(path);
	    BufferedReader reader = new BufferedReader(fr);
	    String next;
	    while ((next = reader.readLine()) != null) {
	    	parseJSONtoList(next);
	    }
	}
	
	/**
	 * Print the contents of the array list into a file
	 * @param listToPrint	the list to print
	 * @param fileName		the name of the file to print to
	 */
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
