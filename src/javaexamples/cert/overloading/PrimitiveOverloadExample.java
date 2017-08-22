package javaexamples.cert.overloading;

// This example shows that when you call an overloaded method with int values and only have overloaded methods
// which accept float or double, the float option will be called since float is closer to an int that to a double.
// The int value is widened to a float. Chars are widened to a float also in this example, but if you have 1 as char
// and 1 parameter as double, then it will call the double overloaded method.

// In method overloading, widening is preferred over boxing/unboxing
public class PrimitiveOverloadExample {

    public static void main(String[] args) {
        printSum(1.0, 2.0); // In double 3.0
        printSum(1, 2); // In float 3.0
        printSum('a', 2.0); // In double 99.0
        printSum('a', 'b'); // In float 195.0
    }

    public static void printSum(double a, double b) {
        System.out.println("In double " + (a + b));
    }

    public static void printSum(float a, float b) {
        System.out.println("In float " + (a + b));
    }

    // Note that this method is not used even though we call with 2 int parameters.
    // This is because widening is preferred over boxing.
    public static void printSum(Integer a, Integer b) {
        System.out.println("In Integer " + (a + b));
    }
}
