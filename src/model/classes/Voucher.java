package model.classes;

public class Voucher {
    private int voucherID;
    private String voucherName;
    private double discount;
    private int nominal;
    private int point;

    public Voucher(int voucherID, String voucherName, double discount, int nominal, int point) {
        this.voucherID = voucherID;
        this.voucherName = voucherName;
        this.discount = discount;
        this.nominal = nominal;
        this.point = point;
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

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
