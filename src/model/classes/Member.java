package model.classes;

import model.interfaces.Discount;

import java.util.ArrayList;

public class Member extends NonGuest implements Discount {
	Wallet wallet;
	int point;

	public Member(Integer id, String name, String email, String password, String cellphone, Wallet wallet, int point) {
		super(id, name, email, password, cellphone);
		this.wallet = wallet;
		this.point = point;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public double applyDiscount(double price) {
		return 0;
	}
}
