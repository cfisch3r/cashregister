package de.agiledojo.tdd.cashregister;

public class BarcodeInformation {
    private double price;
    private Verification verification;

    public BarcodeInformation(double price, Verification verification) {
        this.price = price;
        this.verification = verification;
    }

    public double getPrice() {
        return price;
    }

    public Verification getVerification() {
        return verification;
    }
}
