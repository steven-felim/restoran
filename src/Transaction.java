import java.util.Calendar;

public class Transaction {
	private Calendar datePurchase;
	private int seats;
	private boolean status;
	private String menuID;

	public Calendar getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Calendar datePurchase) {
		this.datePurchase = datePurchase;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public Transaction(Calendar datePurchase, int seats, boolean status, String menuID) {
		this.datePurchase = datePurchase;
		this.seats = seats;
		this.status = status;
		this.menuID = menuID;
	}
}
