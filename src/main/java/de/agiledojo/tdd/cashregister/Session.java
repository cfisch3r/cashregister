package de.agiledojo.tdd.cashregister;

public class Session {
    double total = 0;

    public Session() {
    }

    double getTotal() {
        return total;
    }

    void addToTotal(double price) {
        total += price;
    }
}