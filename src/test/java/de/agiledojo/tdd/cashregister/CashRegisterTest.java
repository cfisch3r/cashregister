package de.agiledojo.tdd.cashregister;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class CashRegisterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private Presenter presenter;
    private CashRegister cashRegister;

    @Test
    public void testWorks() {
        assertTrue(true);
    }

    @Before
    public void setUp() {
        cashRegister = new CashRegister(presenter, new Session());
    }

    @Test
    public void addingPriceDisplaysPrice() {
        cashRegister.addPrice(23.45);
        verify(presenter).displayAmount(Mockito.eq(23.45));
    }

    @Test
    public void addingSecondPriceDisplaysSum() {
        cashRegister.addPrice(23.45);
        cashRegister.addPrice(2.45);
        verify(presenter).displayAmount(Mockito.eq(25.9));
    }
}
