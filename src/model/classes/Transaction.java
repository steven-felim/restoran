package model.classes;

import model.enums.TransactionStatus;

import java.util.ArrayList;
import java.util.Calendar;

public class Transaction {
	private Integer transactionId;
	private Calendar datePurchase;
	private TransactionStatus status;
	private ArrayList<Table> listBookTable;
	private ArrayList<FoodAndBeverage> listFnB;

	public Transaction(Integer transactionId, Calendar datePurchase, TransactionStatus status, ArrayList<Table> listBookTable, ArrayList<FoodAndBeverage> listFnB) {
		this.transactionId = transactionId;
		this.datePurchase = datePurchase;
		this.status = status;
		this.listBookTable = listBookTable;
		this.listFnB = listFnB;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Calendar getDatePurchase() {
		return datePurchase;
	}

	public void setDatePurchase(Calendar datePurchase) {
		this.datePurchase = datePurchase;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public ArrayList<Table> getListBookTable() {
		return listBookTable;
	}

	public void setListBookTable(ArrayList<Table> listBookTable) {
		this.listBookTable = listBookTable;
	}

	public ArrayList<FoodAndBeverage> getListFnB() {
		return listFnB;
	}

	public void setListFnB(ArrayList<FoodAndBeverage> listFnB) {
		this.listFnB = listFnB;
	}
}
