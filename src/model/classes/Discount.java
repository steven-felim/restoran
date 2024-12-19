package model.classes;

public class Discount {
    private double discount_percent;

    public Discount(double discount_percent) {
        this.discount_percent = discount_percent;
    }

    public double getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(double discount_percent) {
        this.discount_percent = discount_percent;
    }
}
