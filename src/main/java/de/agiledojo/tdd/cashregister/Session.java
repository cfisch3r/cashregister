package de.agiledojo.tdd.cashregister;

import java.math.BigDecimal;

public class Session {
    BigDecimal total = new BigDecimal(0);

    public Session() {
    }

    double getTotal() {
        return total.doubleValue();
    }

    void addToTotal(double price) {
        total = total.add(new BigDecimal(price));
        total.setScale(2,BigDecimal.ROUND_HALF_DOWN);
    }
}