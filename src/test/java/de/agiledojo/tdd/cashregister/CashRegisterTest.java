package de.agiledojo.tdd.cashregister;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CashRegisterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private Presenter presenter;

    @Mock
    private BarcodeService barcodeService;

    private CashRegister cashRegister;

    @Test
    public void testWorks() {
        assertTrue(true);
    }

    @Before
    public void setUp() {
        cashRegister = new CashRegister(presenter, new Session(), barcodeService);
    }

    @Test
    public void addingPriceDisplaysPrice() {
        cashRegister.addPrice(23.45);
        verifyDisplayShowsAmount(23.45);
    }

    @Test
    public void addingSecondPriceDisplaysSum() {
        cashRegister.addPrice(23.45);
        cashRegister.addPrice(3.45);
        verifyDisplayShowsAmount(23.45);
        verifyDisplayShowsAmount(26.9);
    }

    private void verifyDisplayShowsAmount(double amount) {
        verify(presenter).displayAmount(Mockito.eq(amount));
    }

    @Test
    public void addingBarcodeDisplaysPriceFromBarcodeService() {
        addBarcodeToService("12345", 33.45);
        cashRegister.addBarcode("12345");
        verifyDisplayShowsAmount(33.45);
    }

    @Test
    public void addingBarcodeAndPriceDisplaysSumFromBoth() {
        addBarcodeToService("12345", 33.45);
        cashRegister.addPrice(2.45);
        cashRegister.addBarcode("12345");
        verifyDisplayShowsAmount(2.45);
        verifyDisplayShowsAmount(35.9);
    }

    @Test
    public void addingBarcodeForAdultProductShowsVerficationAlert() {
        addBarcodeForAdultProductToService("456",56.3);
        cashRegister.addBarcode("456");
        verify(presenter).showVerificationAlert();
    }

    @Test
    public void addingBarcodeWhenBarcodeServiceFailsShows() {
        throwExceptionWhenBarcodeServiceIsCalled();
        cashRegister.addBarcode("456");
        verify(presenter).showCannotFindBarCodeInformation();
    }

    private void throwExceptionWhenBarcodeServiceIsCalled() {
        when(barcodeService.getInformation(any(String.class))).thenThrow(new RuntimeException());
    }

    private void addBarcodeToService(String barcode, double price) {
        when(barcodeService.getInformation(barcode)).thenReturn(new BarcodeInformation(price, Verification.NONE));
    }

    private void addBarcodeForAdultProductToService(String barcode, double price) {
        when(barcodeService.getInformation(barcode)).thenReturn(new BarcodeInformation(price, Verification.ADULT));
    }
}
