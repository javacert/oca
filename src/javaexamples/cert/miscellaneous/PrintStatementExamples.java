package javaexamples.cert.miscellaneous;

import java.util.Date;

public class PrintStatementExamples {

    public static void main(String[] args){
        printExamples();
        passingAnObjectToPrint();
        passingAPrimitiveToPrint();
        passingAWrapperToPrint();
        printNullExample();
        printAClassExample();
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
}
