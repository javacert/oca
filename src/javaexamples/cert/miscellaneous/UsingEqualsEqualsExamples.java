package javaexamples.cert.miscellaneous;

import java.io.IOException;

// Using == rules:
// 1) Any two integral primitives can be compared using == operator. short s = 9; int i = 9; System.out.println(s == i)
// 2) Any two object references being compared using == must have an IS-A relationship among themselves.
// 3) You can compare Wrapper objects against primitives since the wrapper will be un-boxed.
public class UsingEqualsEqualsExamples {
    public static void main(String[] args){
        comparingPrimitives();
        comparingObjects();
        comparingWrapperObjectsToPrimitives();
        comparingObjectsToPrimitives();
    }

    private static void comparingPrimitives() {
        short s = 5;
        int i = 5;
        float f = 5;
        double d = 5;
        System.out.println(s == i); // true
        System.out.println(s == f); // true
        System.out.println(s == d); // true
        System.out.println(f == d); // true
    }

    private static void comparingObjects() {
        IOException ioe = new IOException();
        Exception e = new Exception();

        System.out.println(ioe == e); // IOException is-a Exception

        Short s = new Short((short)5);
        // System.out.println(s == e); // Will NOT Compile
    }

    private static void comparingWrapperObjectsToPrimitives() {
        // These all work fine since the wrapper is un-boxed to a primitive
        short s = 5;
        int i = 5;
        float f = 5;
        Short sWrapper = 5;
        Integer iWrapper = 5;
        Float fWrapper = 5.0f;
        Double dWrapper = 5.0;
        System.out.println(s == sWrapper); // true
        System.out.println(s == iWrapper); // true
        System.out.println(i == fWrapper); // true
        System.out.println(f == dWrapper); // true
    }

    private static void comparingObjectsToPrimitives() {
        short s = 5;
        IOException e = new IOException();
        // System.out.println(s == e); // --> Will NOT Compile
    }
}
