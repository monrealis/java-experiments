package eu.vytenis.solid.liskov;

public class ComplexNumber {
    private final RealNumber real;
    private final RealNumber imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = new RealNumber(real);
        this.imaginary = new RealNumber(imaginary);
    }

    @Override
    public String toString() {
        return real.toString() + " " + imaginary.toString();
    }
}
