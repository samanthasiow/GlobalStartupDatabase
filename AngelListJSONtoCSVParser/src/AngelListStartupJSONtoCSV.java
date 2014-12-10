import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AngelListStartupJSONtoCSV {
	private static ArrayList<String> allStartups;
	public static void main(String[] args) throws Exception {
		
		getAllStartupListings();
	}
	
    // Used an open source JSON parser
    // Run with the .jar from http://mvnrepository.com/artifact/org.json/json
	private static void getAllStartupListings() throws Exception {
		JSONObject json;
	    JSONArray startupArray;
	    StartupData startupData;
	    StringBuilder jobsURL = new StringBuilder("https://api.angel.co/1/tags/1654/startups");
	    String id, hidden, communityProfile, name, angellistUrl,logoUrl, thumbUrl, quality, productDesc;
		String highConcept,followerCount, companyUrl, createdAt, updatedAt, crunchbaseUrl, twitterUrl;
		String facebookUrl, linkedinUrl, videoUrl, locations, companySize, companyType, status, screenshot;
		
		ArrayList<String> marketTags, locationTags;

		try {
			// test query
		    json = new JSONObject(readUrl(jobsURL.toString()));
	    	startupArray = json.getJSONArray("startups");
		    	
	    	// Adds every result from the page to the list
	    	for (int j = 0; j < startupArray.length(); j++) {
	    		JSONObject startup = startupArray.getJSONObject(j);
	    		id = startup.getInt("id") + "";
	    		hidden = startup.getBoolean("hidden") + "";
	    		communityProfile = startup.getBoolean("community_profile") + "";
	    		name = startup.getString("name");
	    		angellistUrl = startup.getString("angellist_url");
	    		quality = startup.getInt("quality") + "";
	    		highConcept = startup.getString("high_concept");
	    		companyUrl = startup.getString("company_url");
	    		String allMarkets = startup.getString("markets");
	    		JSONArray market = new JSONArray(allMarkets);
	    		marketTags = new ArrayList<>();
	    		for (int k = 0; k < market.length(); k++) {
	    			JSONObject marketTag = market.getJSONObject(k);
	    			marketTags.add(marketTag.getString("name"));
	    		}
	    		
	    		String allLocations = startup.getString("locations");
	    		locationTags = new ArrayList<>();
	    		JSONArray location = new JSONArray(allLocations);
	    		for (int k = 0; k < market.length(); k++) {
	    			JSONObject locationTag = location.getJSONObject(k);
	    			locationTags.add(locationTag.getString("name"));
	    		}
	    		
	    		companySize = startup.getInt("company_size") + "";
	    		companyType = startup.getString("company_type");
	    		status = startup.getString("status");
	    		
	    		startupData = new StartupData(id, hidden, communityProfile,
	    				name, angellistUrl, quality,
	    				highConcept, companyUrl, marketTags,
	    				locationTags, companySize,
	    				companyType, status);
	    		System.out.println(startupData.toString());
	    	}
		} catch (JSONException e) {
		    e.printStackTrace();
		}
	}
	
	// returns the url in the format needed to parse 
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
}
