package de.itemis.tdd.cashregister;

public class CashRegister {

    private Presenter presenter;

    public CashRegister(Presenter presenter) {
        this.presenter = presenter;
    }

    public void enterPrice(double price) {
        presenter.displayAmount(price);
    }
}
