package StartupRoles;

public class StartupRole {
	String role;
	String name;;
	String userID;
	String roleID;
	
	public StartupRole(String userID, String name, String role, String roleID) {
		this.userID = userID;
		this.name = name.replace(',', ';');
		this.role = role.replace(',', ';');
		this.roleID = roleID;
	}
	
	public String toString() {
		return userID + "," + name + "," + roleID + "," + role;
	}
}
