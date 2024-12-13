package model.classes;

import model.classes.FoodAndBeverage;

import java.util.ArrayList;

public class Cart {
    private int cart_Id;
    private int user_id;
    private int guest_id;
    private int quantity;
    private ArrayList<FoodAndBeverage> listFnB;

    public Cart(int cart_Id, int user_id, int guest_id, int quantity, ArrayList<FoodAndBeverage> listFnB) {
        this.cart_Id = cart_Id;
        this.user_id = user_id;
        this.guest_id = guest_id;
        this.quantity = quantity;
        this.listFnB = listFnB;
    }

    public int getCart_Id() {
        return cart_Id;
    }

    public void setCart_Id(int cart_Id) {
        this.cart_Id = cart_Id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<FoodAndBeverage> getListFnB() {
        return listFnB;
    }

    public void setListFnB(ArrayList<FoodAndBeverage> listFnB) {
        this.listFnB = listFnB;
    }

}
