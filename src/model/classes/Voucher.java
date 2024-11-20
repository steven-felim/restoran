package model.classes;

public class Voucher {
    private String voucher;
    private double discount;
    private boolean used;

    public Voucher(String voucher, double discount, boolean used) {
        this.voucher = voucher;
        this.discount = discount;
        this.used = used;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
