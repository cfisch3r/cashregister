package de.agiledojo.tdd.cashregister;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
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
        verify(presenter).displayAmount(Mockito.eq(23.45));
    }

    @Test
    public void addingSecondPriceDisplaysSum() {
        cashRegister.addPrice(2);
        cashRegister.addPrice(3);
        verify(presenter).displayAmount(Mockito.eq(2d));
        verify(presenter).displayAmount(Mockito.eq(5d));
    }

    @Test
    public void addingBarcodeDisplaysPriceFromBarcodeService() {
        when(barcodeService.getInformation("12345")).thenReturn(new BarcodeInformation(33.45));
        cashRegister.addBarcode("12345");
        verify(presenter).displayAmount(Mockito.eq(33.45));
    }

    @Test
    public void addingBarcodeAndPriceDisplaysSumFromBoth() {
        when(barcodeService.getInformation("12345")).thenReturn(new BarcodeInformation(33.45));
        cashRegister.addPrice(2);
        cashRegister.addBarcode("12345");
        verify(presenter).displayAmount(Mockito.eq(2d));
        verify(presenter).displayAmount(Mockito.eq(35.45));
    }
}
