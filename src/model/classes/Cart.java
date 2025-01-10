package model.classes;

public class Cart {
    private int cart_Id;
    private int user_id;
    private int guest_id;
    private boolean checkoutStatus;
    private int quantity;
    private FoodAndBeverage fnb;

    // Design Pattern Builder
    public Cart(Builder builder) {
        this.cart_Id = builder.cart_Id;
        this.user_id = builder.user_id;
        this.guest_id = builder.guest_id;
        this.checkoutStatus = builder.checkoutStatus;
        this.quantity = builder.quantity;
        this.fnb = builder.fnb;
    }

    public int getCart_Id() {
        return cart_Id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public boolean isCheckoutStatus() {
        return checkoutStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public FoodAndBeverage getFnb() {
        return fnb;
    }

    public static class Builder {
        private int cart_Id;
        private int user_id;
        private int guest_id;
        private boolean checkoutStatus;
        private int quantity;
        private FoodAndBeverage fnb;

        public Builder setCart_Id(int cart_Id) {
            this.cart_Id = cart_Id;
            return this;
        }

        public Builder setUser_id(int user_id) {
            this.user_id = user_id;
            return this;
        }

        public Builder setGuest_id(int guest_id) {
            this.guest_id = guest_id;
            return this;
        }

        public Builder setCheckoutStatus(boolean checkoutStatus) {
            this.checkoutStatus = checkoutStatus;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setFnb(FoodAndBeverage fnb) {
            this.fnb = fnb;
            return this;
        }
    }
}