package javaexamples.cert.exceptions;

import java.io.*;

// This demo shows what happens when an inner try/catch doesn't catch an exception but the outer try/catch does.
// The exception is propagated to the outer exception-handler block. The outer exception handler catches the
// NullPointerException thrown by the inner try block and executes the appropriate exception handler.
public class NestedTryCatchExample {

    static FileInputStream players, coach;

    public static void main(String args[]) {
        nestedRuntimeExample();
        nestedCheckedExample();
    }

    private static void nestedRuntimeExample() {
        // OUTPUT: D
        try {
            try {
                coach.close(); // coach will be null here so a NullPointerException is thrown, but it is in the outer try/catch
            } catch (IOException e) {
                System.out.println("A"); // Won't be caught, but what happens to the NullPointerException
            }
            players = new FileInputStream("players.txt");
            System.out.println("B"); // This is NOT printed
        } catch (FileNotFoundException fnfe) {
            System.out.println("C");
        } catch (NullPointerException ne) {
            System.out.println("D"); // NullPointerException passed to outer try/catch and exception thrown here!
        }

        // Note if we didn't catch the NullPointerException in the outer block then an Exception would be thrown:
        // Exception in thread "main" java.lang.NullPointerException
        //      at javaexamples.cert.exceptions.NestedTryCatchExample.main(NestedTryCatchExample.java:14)
    }

    private static void nestedCheckedExample() {
        // OUTPUT: A C
        try {
            try {
                throw new FileNotFoundException();
            } catch (IOException e) {
                System.out.println("A"); // Won't be caught, but what happens to the FileNotFoundException
            }
            players = new FileInputStream("players.txt");
            System.out.println("B");
        } catch (FileNotFoundException fnfe) {
            System.out.println("C"); // Exception is passed to the outer try/catch and handled here.
        } catch (NullPointerException ne) {
            System.out.println("D");
        }

        // Note if we didn't catch the FileNotFoundException in the outer block it would result in a compilation error - Unhandled Exception
    }
}