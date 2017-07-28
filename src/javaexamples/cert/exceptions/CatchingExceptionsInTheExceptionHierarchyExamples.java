package javaexamples.cert.exceptions;

// These examples attempt to demonstrate what happens when the exact Exception is not in the catch hierarchy.
// What this class shows is that when there is a parent class available in the exception stack, it will handle the exception.
// The most specific match in the hierarchy will catch and throw it.
// If there is no available match, then an error is thrown and execution is terminated with an error.

// Note that as a result of this it is possible for an exception to match two or more catch blocks - the first
// one that matches is always executed.

import java.io.IOException;

public class CatchingExceptionsInTheExceptionHierarchyExamples {

    public static void main(String[] args){
        comparingCheckedAndRuntimeExceptions();
        testingRuntimeExceptions();
    }

    private static void comparingCheckedAndRuntimeExceptions() {
        // Prints A C D
        try {
            System.out.println("A");
            throw new IOException("Throwing a IOException A"); // Throw a Checked Exception
        } catch (RuntimeException e){
            System.out.println("B");
        } catch (Exception e){
            System.out.println("C");
        } finally {
            System.out.println("D");
        }

        // Prints A B D
        try {
            System.out.println("A");
            throw new IllegalArgumentException("Throwing a IllegalArgumentException A"); // Throw a Runtime Exception
        } catch (RuntimeException e){
            System.out.println("B");
        } catch (Exception e){
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
    }

    private static void testingRuntimeExceptions() {

        // The following prints A C D and execution continues fine
        try {
            System.out.println("A");
            throw new RuntimeException("Throwing a RuntimeException A");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("B");
        } catch (RuntimeException e){ // I catch it since I'm an exact match to the thrown exception
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
        System.out.println("Since I handle the RuntimeException, execution will continue fine!");

        // The following prints A B D and execution continues fine
        try {
            System.out.println("A");
            throw new ArrayIndexOutOfBoundsException("Throwing a ArrayIndexOutOfBoundsException A");
        } catch (IndexOutOfBoundsException e){ // I will catch it since ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
            System.out.println("B");
        } catch (RuntimeException e){ // IndexOutOfBoundsException is more specific than me, so I won't catch this time
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
        System.out.println("Since I handle the IndexOutOfBoundsException, execution will continue fine!");

        // The following prints A B D and execution continues fine
        try {
            System.out.println("A");
            throw new RuntimeException("Throwing a RuntimeException B");
        } catch (RuntimeException e){ // I will catch it this time
            System.out.println("B");
        } catch (Exception e){
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
        System.out.println("Since I handle the RuntimeException, execution will continue fine!");

        // The following prints A B C and execution continues fine
        try {
            System.out.println("A");
            throw new RuntimeException("Throwing a RuntimeException C");
        } catch (Exception e){
            System.out.println("B"); // Since RuntimeException extends Exception, I will handle it as I'm the closest match
        } finally {
            System.out.println("C");
        }
        System.out.println("Since I handle the Exception, execution will continue fine!");

        // The following prints A C and execution ends with an error since we do not handle the RuntimeException
        try {
            System.out.println("A");
            throw new RuntimeException("Throwing a RuntimeException D");
        } catch (ArrayIndexOutOfBoundsException e){ // I can't handle it since I'm a broader ( i.e. subclass) exception
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("You won't see me since I do not handle the RuntimeException gracefully and execution ends!");
    }
}