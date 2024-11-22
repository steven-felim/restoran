package model.classes;

import model.interfaces.Discount;

public class Guest extends User implements Discount {
	public Guest(Integer id, String name) {
		super(id, name);
	}

	@Override
	public double applyDiscount(double price) {
		return 0;
	}
}
