package javaexamples.cert.miscellaneous;

import java.util.Date;

public class PrintStatementExamples {

    public static void main(String[] args){
        printExamples();
        passingAnObjectToPrint();
        passingAPrimitiveToPrint();
        passingAWrapperToPrint();
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
}
