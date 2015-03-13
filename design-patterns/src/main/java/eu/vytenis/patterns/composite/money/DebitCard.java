package eu.vytenis.patterns.composite.money;

import eu.vytenis.patterns.composite.api.MoneySource;

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
