package model.classes;

public class Wallet {
	private double balance;
	private String pin;

	public Wallet(String pin) {
		this.balance = 0;
		this.pin = pin;
	}

	public Wallet(double balance, String pin) {
		this.balance = balance;
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public void addBalance(double newBalance) {
		this.balance += newBalance;
	}

	public boolean decreaseBalance(double reduceBalance) {
		if (this.balance < reduceBalance) return false;
		this.balance -= reduceBalance;
		return true;
	}

	public boolean verifyPin(String pin) {
		return this.pin.equals(pin);
	}
}
