package view;

import javax.swing.*;

public class Login extends JFrame {
	public Login() {
		super("Login");
		setSize(400, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		Login login = new Login();
	}
}
