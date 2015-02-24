package eu.vytenis.fitnesse;

import fit.ColumnFixture;

public class SumFixture extends ColumnFixture {
    public int first;
    public int second;

    public int getSum() {
        return first + second;
    }
}
