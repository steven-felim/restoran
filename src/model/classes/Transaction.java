package model.classes;

import model.enums.TransactionStatus;

import java.util.Date;

public class Transaction {
	private Integer transactionId;
	private Date datePurchase;
	private TransactionStatus status;
	private int userId;
	private int guestId;
	private int cartId;
	private int voucherId;
	private int total;

	public Transaction(Integer transactionId, int userId, int guestId, int cartId, int voucherId, Date datePurchase, TransactionStatus status, int total) {
		this.transactionId = transactionId;
		this.userId = userId;
		this.guestId = guestId;
		this.cartId = cartId;
		this.voucherId = voucherId;
		this.datePurchase = datePurchase;
		this.status = status;
		this.total = total;
	}

	public Transaction() {}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public Date getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
