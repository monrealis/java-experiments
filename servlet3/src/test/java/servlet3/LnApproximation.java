package servlet3;

public class LnApproximation {

    public static double lnApprox(double x) {
        double result = 0.0;

        long numeratorFact = 1; // (n - 1)!
        long denominatorFact = 1; // n!

        for (int n = 1; n <= 5; n++) {
            denominatorFact *= n;
            double term = Math.pow(-1, n + 1) * ((double) numeratorFact / denominatorFact) * Math.pow(x, n);
            result += term;
            numeratorFact = denominatorFact;
        }

        return result;
    }
}
