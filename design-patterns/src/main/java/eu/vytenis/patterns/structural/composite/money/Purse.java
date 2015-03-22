package eu.vytenis.patterns.structural.composite.money;

import eu.vytenis.patterns.structural.composite.api.MoneySource;

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
