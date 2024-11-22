package model.classes;

import model.interfaces.Discount;

import java.util.ArrayList;

public class Member extends NonGuest implements Discount {
	Wallet wallet;
	Point point;
	ArrayList<Transaction> transactions;

	public Member(Integer id, String name, String email, String password, String cellphone, Wallet wallet, Point point, ArrayList<Transaction> transactions) {
		super(id, name, email, password, cellphone);
		this.wallet = wallet;
		this.point = point;
		this.transactions = transactions;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public double applyDiscount(double price) {
		return 0;
	}
}
