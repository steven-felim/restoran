package model.classes;

public class Order {
    private int id;
    private int menuId;
    private int quantity;
    private String status;

    public Order(int id, int menuId, int quantity, String status) {
        this.id = id;
        this.menuId = menuId;
        this.quantity = quantity;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }
}

