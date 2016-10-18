package de.agiledojo.tdd.cashregister;

public class CashRegister {
    private Presenter presenter;

    public CashRegister(Presenter presenter) {
        this.presenter = presenter;
    }

    public void addPrice(double price) {
        presenter.displayAmount(price);
    }
}
