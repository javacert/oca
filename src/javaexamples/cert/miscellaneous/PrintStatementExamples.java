package javaexamples.cert.miscellaneous;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PrintStatementExamples {

    public static void main(String[] args){
        printExamples();
        passingAnObjectToPrint();
        passingAPrimitiveToPrint();
        passingAWrapperToPrint();
        printNullExample();
        printAClassExample();
        printAShortExample();
        printAIntExample();
        printAFloatExample();
        printADoubleExample();
        printAObjectExample();
        printACharExample();
        printALocalDateExample();
        printAStringExample();
        printABooleanExample();
    }

    private static void printExamples() {
        // System.out.print(); // print() required a parameter
        System.out.println(); // println does not required a parameter as part of its overloads

        // It will print a new line when you pass nothing.
        //public void println() {
        //    newLine();
        //}
    }

    private static void passingAnObjectToPrint() {
        System.out.println(new Date()); // Sun Aug 13 18:12:47 BST 2017 (today's date)

        // The above works because println accepts an Object reference and in turn calls toString method on it.

        //public void println(Object x) {
        //    String s = String.valueOf(x);
        //    synchronized (this) {
        //        print(s);
        //        newLine();
        //    }
        //}

        //public static String valueOf(Object obj) {
        //    return (obj == null) ? "null" : obj.toString();
        //}
    }

    private static void passingAPrimitiveToPrint() {
        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4;
        float e = 5;
        double f = 6;
        double g = 6.123;

        System.out.println(a); // 1
        System.out.println(b); // 2
        System.out.println(c); // 3
        System.out.println(d); // 4
        System.out.println(e); // 5.0
        System.out.println(f); // 6.0
        System.out.println(g); // 6.123
    }

    private static void passingAWrapperToPrint() {
        Byte a = 1;
        Short b = 2;
        Integer c = 3;
        Long d = 4L; // Note - have to pass correct type when assigning to wrapper in this way
        Float e = 5.0f; // Note - have to pass correct type when assigning to wrapper in this way
        Double f = 6.0; // Note - have to pass correct type when assigning to wrapper in this way
        Double g = 6.123; // Note - have to pass correct type when assigning to wrapper in this way

        // All the following call the toString method in the wrapper object
        System.out.println(a); // 1
        System.out.println(b); // 2
        System.out.println(c); // 3
        System.out.println(d); // 4
        System.out.println(e); // 5.0
        System.out.println(f); // 6.0
        System.out.println(g); // 6.123
    }

    private static void printNullExample() {
        String someString = null;
        Integer someInteger = null;
        System.out.println(someString); // null
        System.out.println(someInteger); // null
        //System.out.println(null); // Can't do this - ambiguous method call to println
        //System.out.println(null + null); // Can't do this either
    }

    private static void printAClassExample() {
        // When a class (or the superclass) of an object does not override the toString method,
        // Object class's toString is used, which prints the name of the class + @ sign + hash code of the object.
        System.out.println(new Integer(5)); // Integer overrides object toString and returns 5
        System.out.println(new PrintStatementExamples()); // javaexamples.cert.miscellaneous.PrintStatementExamples@1540e19d

        // Now, in case of an array, the name of the class is a little complicated.
        // The internal form of the name consists of the name of the element type preceded by one or
        // more '[' characters representing the depth of the array nesting.
        String[] stringArray = { "A", "B", "C" };
        System.out.println(stringArray); // [Ljava.lang.String;@677327b6

        String[][] stringArrayB = {{ "A", "B", "C" }};
        System.out.println(stringArrayB); // [[Ljava.lang.String;@14ae5a5
    }

    private static void printAShortExample() {
        System.out.println((short)10); // 10 - public void println(int x)
        System.out.println((short)10 + 3.2); // 13.2 - public void println(double x)
    }

    private static void printAIntExample() {
        System.out.println('b' + new Integer(63)); // 161
        System.out.println('a' + 1 ); // This does NOT print B, char promoted to an int - 98
    }

    private static void printAFloatExample() {
        System.out.println(3.1f); // 3.1 (same as how double is output)
        System.out.println(4 + 1.7f); // 5.7
    }

    private static void printADoubleExample() {
        System.out.println(3.2); // 3.2
        System.out.println(3.2 + 1); // 4.2 - public void println(double x)
        System.out.println(3.2 + 'c'); // 102.2 - public void println(double x)
    }

    private static void printAObjectExample() {
        System.out.println(new Object()); // java.lang.Object@7f31245a - public void println(Object x)
    }

    private static void printACharExample() {
        System.out.println('b'); // b - public void println(char x)
        System.out.println('b' + 123); // 221 - public void println(int x) - widened to an int
        System.out.println("b" + 'b'); // bb - public void println(String x) - String concatenation
        System.out.println("b" + 'b' + 12); // bb12 - public void println(String x) - String concatenation
        System.out.println(12 + "b" + 'b'); // 12bb - public void println(String x) - String concatenation
        System.out.println(12 + 3 + "b" + 'b'); // 15bb - public void println(String x) - String concatenation
    }

    private static void printALocalDateExample() {
        LocalDate d1 = LocalDate.parse("2015-02-05", DateTimeFormatter.ISO_DATE);
        LocalDate d2 = LocalDate.of(2015, 2, 5);
        LocalDate d3 = LocalDate.now();

        // LocalDate overrides toString to output the date in the following format.
        // For other formats you need to use format with DateTimeFormatter
        System.out.println(d1); // 2015-02-05
        System.out.println(d2); // 2015-02-05
        System.out.println(d3); // 2017-08-22
    }

    private static void printAStringExample() {
        // Both method println(char[]) in java.io.PrintStream and method println(java.lang.String) in java.io.PrintStream match
        //System.out.println(null + true); // Operator + cannot be applied to null, boolean
        //System.out.println(true + null); // Operator + cannot be applied to null, boolean
    }

    private static void printABooleanExample() {
        System.out.println(true); // true - public void println(boolean x)
        System.out.println(false); // false - public void println(boolean x)
        System.out.println(new Boolean("true")); // true - public void println(Object x)
        System.out.println(new Boolean("false")); // false - public void println(Object x)
        //System.out.println(true + new Boolean("false")); // Operator + cannot be applied to boolean, java.lang.Boolean
    }
}
