package eu.vytenis.fitnesse.basic.table;

import fitnesse.fixtures.TableFixture;

public class SumTableFixture extends TableFixture {
    int sum = 0;

    @Override
    protected void doStaticTable(int rows) {
        for (int i = 0; i < rows; ++i)
            handleRow(i);
    }

    private void handleRow(int i) {
        if (getText(i, 0).equals("addOne"))
            handleAddOne(i);
        else if (getText(i, 0).equals("addTwo"))
            handleAddTwo(i);
        else if (getText(i, 0).equals("checkSum"))
            handleCheckSum(i);
    }

    private void handleAddOne(int i) {
        addOne(getInt(i, 1));
    }

    private void handleAddTwo(int i) {
        addTwo(getInt(i, 1), getInt(i, 2));
    }

    private void addOne(int number) {
        sum += number;
    }

    private void addTwo(int number1, int number2) {
        sum += number1 + number2;
    }

    private void handleCheckSum(int i) {
        if (sum == getInt(i, 1))
            right(i, 1);
        else
            wrong(i, 1, String.valueOf(sum));
    }
}
