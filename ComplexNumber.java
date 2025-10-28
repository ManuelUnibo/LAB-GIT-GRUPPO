public class ComplexNumber {
    
    private final double real;
    private final double imaginary;

    public ComplexNumber(final double real, final double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public double getReal() {
        return this.real;
    }
    
    public ComplexNumber plus(final ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }
    
    public ComplexNumber sub(final ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber times(final ComplexNumber other) {
        final double realPart = this.real * other.real - this.imaginary * other.imaginary;
        final double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber div(final ComplexNumber other) {
        final double commonDenominator = other.getReal() * other.getReal() + other.getImaginary() * other.getImaginary();
        final double realNumerator = this.getReal() * other.getReal() + this.getImaginary() * other.getImaginary();
        final double imaginaryNumerator = other.getReal() * this.getImaginary() - this.getReal() * other.getImaginary();
        return new ComplexNumber(realNumerator / commonDenominator, imaginaryNumerator / commonDenominator);
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }


    public static void main(String[] args) {
        ComplexNumber complexNumber = new ComplexNumber(4, 8);
        System.out.println(complexNumber.getReal() + " + " + complexNumber.getImaginary() + "i");
        System.out.println("test somma: " + complexNumber.plus(new ComplexNumber(10, 4)));
        System.out.println("test sottrazione: " + complexNumber.sub(new ComplexNumber(5, 2)));
        
        ComplexNumber c1 = new ComplexNumber(4, 2);
        ComplexNumber c2 = new ComplexNumber(2, 1);
        ComplexNumber divResult = c1.div(c2);
        System.out.println("test divisione: (4+2i) / (2+1i) = " + divResult.getReal() + " + " + divResult.getImaginary() + "i");
    }
}