package eu.vytenis.patterns.structural.adapter;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class StringBackedNumber extends Number {
    private String number;

    public StringBackedNumber(String number) {
        this.number = number;
    }

    @Override
    public int intValue() {
        return parseInt(number);
    }

    @Override
    public long longValue() {
        return parseLong(number);
    }

    @Override
    public float floatValue() {
        return parseFloat(number);
    }

    @Override
    public double doubleValue() {
        return parseDouble(number);
    }
}
