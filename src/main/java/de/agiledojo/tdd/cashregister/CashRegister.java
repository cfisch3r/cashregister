package de.agiledojo.tdd.cashregister;

public class CashRegister {

    private final Session session;

    private Presenter presenter;

    public CashRegister(Presenter presenter, Session session) {
        this.presenter = presenter;
        this.session = session;
    }

    public void addPrice(double price) {
        session.addToTotal(price);
        presenter.displayAmount(session.getTotal());
    }

}
