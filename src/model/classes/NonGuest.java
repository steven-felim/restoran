package model.classes;

public class NonGuest extends User {
	private String email;
	private String password;
	private String cellphone;

	public NonGuest(Integer id, String name, String email, String password, String cellphone) {
		super(id, name);
		this.email = email;
		this.password = password;
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
}