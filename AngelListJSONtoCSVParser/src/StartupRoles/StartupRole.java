package StartupRoles;
/* Holds all the data for an individual and their role in a startup */
public class StartupRole {
	String role;
	String name;;
	String userID;
	String roleID;
	String startupID;
	
	public StartupRole(String userID, String name, String role, String roleID, String startupID) {
		this.userID = userID;
		this.name = name.replace(',', ';');
		this.role = role.replace(',', ';');
		this.roleID = roleID;
		this.startupID = startupID;
	}
	
	public String toString() {
		return userID + "," + name + "," + roleID + "," + role + "," + startupID;
	}
}
