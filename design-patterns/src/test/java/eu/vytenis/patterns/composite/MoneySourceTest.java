package eu.vytenis.patterns.composite;

import eu.vytenis.patterns.composite.api.MoneySource;
import eu.vytenis.patterns.composite.impl.DebitCard;
import eu.vytenis.patterns.composite.impl.Person;
import eu.vytenis.patterns.composite.impl.Purse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneySourceTest {
    @Test
    public void getAmount_sumsMoneyFromAllSources() {
        assertEquals(60, makeMoneySource().getAmount());
    }

    private MoneySource makeMoneySource() {
        Person husband = new Person();
        husband.addSource(makeWife());
        husband.addSource(new Purse(30));
        return husband;
    }

    private Person makeWife() {
        Person p = new Person();
        p.addSource(new Purse(10));
        p.addSource(new DebitCard(20));
        return p;
    }
}
