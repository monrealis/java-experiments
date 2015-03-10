package eu.vytenis.patterns.composite.impl;

import eu.vytenis.patterns.composite.api.MoneySource;

public class Purse implements MoneySource {
    private final int amount;

    public Purse(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
