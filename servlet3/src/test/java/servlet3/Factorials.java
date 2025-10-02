package servlet3;

public class Factorials {
    static double factorial(int n) {
        double f = 1;
        for (int i = 1; i < n; ++i)
            f *= i + 1;
        return f;
    }
}
