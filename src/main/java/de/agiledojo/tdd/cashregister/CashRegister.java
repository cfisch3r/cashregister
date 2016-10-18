package de.agiledojo.tdd.cashregister;

public class CashRegister {

    private double total = 0;

    private Presenter presenter;

    public CashRegister(Presenter presenter) {
        this.presenter = presenter;
    }

    public void addPrice(double price) {
        total += price;
        presenter.displayAmount(total);
    }
}
