package javaexamples.cert.operators;

public class BasicOperatorExamples {

    public static void main(String[] args){
        greaterThanLessThan();
        modulusExamples();
    }

    private static void greaterThanLessThan() {
        int a = 5, b = 6;
        // boolean canDoThis = a => b;  // --> Must be >=
        // boolean canDoThis = a =< b;     // --> Must be <=

        boolean canDoThis = a >= b;
        canDoThis = a <= b;
    }

    // Modulus on negative numbers in Java : the sign of the result equals the sign of the dividend.
    // Dividend is: The amount that you want to divide up. dividend ÷ divisor = quotient
    private static void modulusExamples() {
        int x = -10; // Sign of dividend is - (minus)
        int y = -3;
        System.out.println(x%y); // -1

        x = 10; // Sign of dividend is + (positive)
        y = -3;
        System.out.println(x%y); // 1

        x = -10; // Sign of dividend is - (minus)
        y = 3;
        System.out.println(x%y); // -1
    }
}
