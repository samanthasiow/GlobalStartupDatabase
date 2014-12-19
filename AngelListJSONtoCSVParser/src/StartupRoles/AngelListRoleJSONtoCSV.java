package StartupRoles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
/*Convert a JSON formatted string into an entry on a csv */
public class AngelListRoleJSONtoCSV {
	private static ArrayList<StartupRole> allUserRoles;
	
	public static void main(String[] args) throws Exception {
		allUserRoles = new ArrayList<>();
		String path = "Roles_1-2000";
		readFromFile(path);
		
		printToFile(allUserRoles, "UserRoles");
	}
	
	/**
	 * Parse the JSON string into a startupRole object,
	 * and add it to the allUserRoles list.
	 * @param startupRoles	json formatted string
	 */
	private static void parseJSONToList(String startupRoles) {
		StartupRole user;
		String userID, startupID, userName, userRole, roleID;
		
		JSONObject object = new JSONObject(startupRoles);
		startupID = object.get("startupID") + "";
		JSONArray roles = object.getJSONArray("startup_roles");
		// for each role the startup has, create a user with that role
		// that is attached to the startup
		for (int i = 0; i < roles.length(); i++) {
			JSONObject role = roles.getJSONObject(i);
			roleID = role.get("id") + "";
			userRole = role.get("role") + "";
			JSONObject userInfo = role.getJSONObject("user");
			userName = userInfo.get("name") + "";
			userID = userInfo.get("id") + "";
			user = new StartupRole(userID, userName, userRole, roleID, startupID);
			allUserRoles.add(user);
		}
	}
	
	/**
	 * Read from the file and parse line by line.
	 * @param path		path to file
	 * @throws Exception	file not found
	 */
	@SuppressWarnings("resource")
	private static void readFromFile(String path) throws Exception {
		FileReader fr = new FileReader(path);
	    BufferedReader reader = new BufferedReader(fr);
	    String next;
	    next = reader.readLine();
	    parseJSONToList(next);
	    while ((next = reader.readLine()) != null) {
	    	parseJSONToList(next);
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
}
