package model.classes;

public class Admin extends NonGuest {
	public Admin(Integer id, String name, String email, String password, String cellphone) {
		super(id, name, email, password, cellphone);
	}
}
