package eu.vytenis.patterns.structural.composite.money;

import eu.vytenis.patterns.structural.composite.api.MoneySource;

import java.util.ArrayList;
import java.util.List;

public class Person implements MoneySource {
    private final List<MoneySource> sources = new ArrayList<>();

    public void addSource(MoneySource source) {
        sources.add(source);
    }


    @Override
    public int getAmount() {
        return sources.stream().map(MoneySource::getAmount).reduce(0, Integer::sum);
    }
}
