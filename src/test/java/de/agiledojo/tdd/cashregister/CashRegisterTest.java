package de.agiledojo.tdd.cashregister;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertTrue;

public class CashRegisterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private Presenter presenter;

    @Test
    public void testWorks() {
        assertTrue(true);
    }

    @Test
    public void addingPriceDisplaysPrice() {
        CashRegister cashRegister = new CashRegister(presenter);
        cashRegister.addPrice(23.45);
        Mockito.verify(presenter).displayAmount(Mockito.eq(23.45));
    }
}
