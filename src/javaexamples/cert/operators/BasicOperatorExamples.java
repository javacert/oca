package javaexamples.cert.operators;

// The logical complement ! operator may only be applied to boolean expressions, not numeric ones.
public class BasicOperatorExamples {

    public static void main(String[] args){
        greaterThanLessThan();
        modulusExamples();
        interestingExample();
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

    private static void interestingExample() {
        int x = 10;
        int y = 20;
        int z = 30;
        // Translates to:
        // (x + (y % z) > (x + (-y * -z))
        // (10 + (20) > (10 + 600)
        System.out.println(y%z); // 20 -  20/30 = 0 remainder 20
        System.out.println(x+y%z); // 30
        System.out.println((x+(-y)*(-z))); // 610
        if (x+y%z > (x+(-y)*(-z))) {
            System.out.println(x + y + z);
        }
    }
}
