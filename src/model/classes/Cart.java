import java.util.ArrayList;

public class Cart {
    private int cart_Id;
    private int quantity;
    private ArrayList<FoodAndBeverage> listFnB;

    public Cart(int cart_Id, int quantity, ArrayList<FoodAndBeverage> listFnB) {
        this.cart_Id = cart_Id;
        this.quantity = quantity;
        this.listFnB = listFnB;
    }

    public int getCart_Id() {
        return cart_Id;
    }

    public void setCart_Id(int cart_Id) {
        this.cart_Id = cart_Id;
    }

    public int getMember_Id() {
        return member_Id;
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
