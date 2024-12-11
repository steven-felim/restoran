package model.classes;

public class FoodAndBeverage {
	private int id;
	private String name;
	private int stock;
	private int price;

	public FoodAndBeverage(int id, String name, int stock, int price) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
	}

	public FoodAndBeverage() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
