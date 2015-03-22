package eu.vytenis.patterns.structural.composite.money;

import eu.vytenis.patterns.structural.composite.api.MoneySource;

public class DebitCard implements MoneySource {
    private final int amount;

    public DebitCard(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
