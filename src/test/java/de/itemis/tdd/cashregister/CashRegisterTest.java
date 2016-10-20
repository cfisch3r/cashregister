package de.itemis.tdd.cashregister;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class CashRegisterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private Presenter presenter;

    @Test
    public void enteringPriceDisplaysPrice() {
        CashRegister cashRegister = new CashRegister(presenter);
        cashRegister.enterPrice(23.45);
        verify(presenter).displayAmount(23.45);
    }
}
