package eu.vytenis.fitnesse.fitlibrary.sequence;

import fitlibrary.SequenceFixture;

public class SumSequenceFixture extends SequenceFixture {
    int sum = 0;

    public void addOne(int number) {
        sum += number;
    }

    public void addTwo(int number1, int number2) {
        sum += number1 + number2;
    }

    public void addLetterCounts(String s1, String s2) {
        addTwo(s1.length(), s2.length());
    }

    public void twice() {
        sum *= 2;
    }

    public int sum() {
        return sum;
    }

    public int sumPlus(int number) {
        return sum + number;
    }
}
