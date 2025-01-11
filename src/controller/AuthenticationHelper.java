package controller;

// design patern singletone
public class AuthenticationHelper {
	private static AuthenticationHelper instance;
	private int roleId = 0;
	private String role = "";

	public static AuthenticationHelper getInstance() {
		if (instance == null) {
			synchronized (AuthenticationHelper.class) {
				if (instance == null) {
					instance = new AuthenticationHelper();
				}
			}
		}
		return instance;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void reset() {
		this.roleId = 0;
		this.role = "";
	}
}
