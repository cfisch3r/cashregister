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
        addPriceToTotal(price);
    }

    public void addBarcode(String barcode) {
        try {
            BarcodeInformation information = barcodeService.getInformation(barcode);
            if (verficationIsNeeded(information)) {
                presenter.showVerificationAlert();
            }
            addPriceToTotal(information.getPrice());
        } catch (RuntimeException e) {
            presenter.showCannotFindBarCodeInformation();
        }
    }

    private boolean verficationIsNeeded(BarcodeInformation information) {
        return information.getVerification() == Verification.ADULT;
    }

    private void addPriceToTotal(double price) {
        session.addToTotal(price);
        presenter.displayAmount(session.getTotal());
    }
}
