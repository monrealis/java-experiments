package eu.vytenis.fitnesse.basic.column;

import fit.ColumnFixture;

public class SumColumnFixture extends ColumnFixture {
    public int first;
    public int second;

    public int getSum() {
        return first + second;
    }
}
