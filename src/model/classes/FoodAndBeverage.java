package model.classes;

public class FoodAndBeverage {
	private String name;
	private int stock;
	private int price;

	public FoodAndBeverage(String name, int stock, int price) {
		this.name = name;
		this.stock = stock;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
