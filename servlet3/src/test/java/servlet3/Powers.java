package servlet3;

public class Powers {
    public static double power2(int exponent) {
        return power(2, exponent);
    }

    public static double power(double n, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; ++i)
            result *= n;
        return result;
    }
}
