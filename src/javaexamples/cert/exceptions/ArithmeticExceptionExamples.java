package javaexamples.cert.exceptions;

// A division will be performed as an integer division as long as only integers are involved.
// As soon as there's a floating-point number, then everything is computed in floating-point arithmetic
// (true for all arithmetic operations, by the way). An integer division by zero throws an ArithmeticException.
// A floating-point division by zero won't throw any exception but rather will return ±Infinity or NaN, depending
// on the first operand.

// If you divide a positive decimal value by 0, the result is Infinity. If you divide a negative decimal value by 0,
// the result is -Infinity
// Division of 0.0 by 0 results in NaN (Not a Number).
// When a positive integer or decimal value is divided by 0.0, the result is Infinity.
public class ArithmeticExceptionExamples {

    public static void main(String args[]) {
        System.out.println(0.0f/0.0f);      // NaN
        System.out.println(0/0.0f);         // NaN
        System.out.println(77/0.0f);        // Infinity
        System.out.println(77.0/0.0f);      // Infinity

        System.out.println(0/0.0);          // NaN
        System.out.println(0.0/0.0);        // NaN
        System.out.println(77/0.0);         // Infinity
        System.out.println(77.0/0.0);       // Infinity

        System.out.println(77/0);           // Exception in thread "main" java.lang.ArithmeticException: / by zero
    }
}
