package model.classes;

public class Voucher {
    private int voucherID;
    private String voucherName;
    private double discount;

    public Voucher(int voucherID, String voucherName, double discount) {
        this.voucherID = voucherID;
        this.voucherName = voucherName;
        this.discount = discount;
    }

    public int getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
