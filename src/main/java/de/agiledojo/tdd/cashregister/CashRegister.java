package de.agiledojo.tdd.cashregister;

public class CashRegister {

    private final Session session;
    private BarcodeService barcodeService;

    private Presenter presenter;

    public CashRegister(Presenter presenter, Session session, BarcodeService barcodeService) {
        this.presenter = presenter;
        this.session = session;
        this.barcodeService = barcodeService;
    }

    public void addPrice(double price) {
        session.addToTotal(price);
        presenter.displayAmount(session.getTotal());
    }

    public void addBarcode(String barcode) {
        BarcodeInformation information = barcodeService.getInformation(barcode);
        session.addToTotal(information.getPrice());
        presenter.displayAmount(session.getTotal());
    }
}
