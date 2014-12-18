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

public class AngelListRoleJSONtoCSV {
	private static ArrayList<StartupRole> allUserRoles;
	private static HashMap<String, String> rolesInStartups;
	
	public static void main(String[] args) throws Exception {
		String path = "Roles_1-2000";
		setupArrays();
		readFromFile(path);
		
		printToFile(allUserRoles, "UserRoles");
	}
	
	private static void parseJSONToList(String startupRoles) {
		StartupRole user;
		String userID, startupID, userName, userRole, roleID;
		
		JSONObject object = new JSONObject(startupRoles);
		JSONArray roles = object.getJSONArray("startup_roles");
		for (int i = 0; i < roles.length(); i++) {
			JSONObject role = roles.getJSONObject(i);
			roleID = role.get("id") + "";
			userRole = role.get("role") + "";
			JSONObject userInfo = role.getJSONObject("user");
			userName = userInfo.get("name") + "";
			userID = userInfo.get("id") + "";
			user = new StartupRole(userID, userName, userRole, roleID);
			allUserRoles.add(user);
		}
	}
	
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
		allUserRoles = new ArrayList<>();
		rolesInStartups = new HashMap<>();
	}
}
