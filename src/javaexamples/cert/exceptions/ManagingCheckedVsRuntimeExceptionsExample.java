package javaexamples.cert.exceptions;

// This example demonstrates that you MUST try/catch/finally when you call a method that throws an exception
// WATCH OUT for this in examples that call a method with throws Exception.
// NOTE - this applies to Checked exceptions only, RuntimeExceptions do not need to be caught explicitly!

public class ManagingCheckedVsRuntimeExceptionsExample {

    // Adding in the throws declaration means I would not need a try/catch, but I won't handle gracefully!
    public static void main(String[] args) /* throws Exception */ {

        // I will throw a compile error since I am not surrounded by a try/catch and I'm a checked exception!
        // new SomeClassWithMethodThatThrowsException().someMethodThatThrowsException();

        // I'm still unhandled using the code below:
/*        try {
            new SomeClassWithMethodThatThrowsException().someMethodThatThrowsException();
        } finally {

        }*/

        // The following will compile since I catch the Exception!
        try {
            new SomeClassWithMethodsThatThrowsExceptions().someMethodThatThrowsException();
        } catch (Exception e){
            System.out.println("It looks like you handled me gracefully - thanks");
        } finally {
            // All lines in a finally block are NOT guaranteed to run e.g. if a new Exception is run, then it is exited.
            // You must add brackets to the finally block or you will receive a compilation error!
        }

        // You can handle RuntimeExceptions with a try/catch, but you don't have to as with Checked Exceptions
        try {
            new SomeClassWithMethodsThatThrowsExceptions().someMethodThatThrowsRuntimeException();
        } catch (RuntimeException e){
            System.out.println("I decided that I want to handle you RuntimeException, even though I don't have to!");
        }

        // Observe how the following will compile for a RuntimeException, but as shown above it will not for a Checked Exception.
        new SomeClassWithMethodsThatThrowsExceptions().someMethodThatThrowsRuntimeException();
        // However it will still error out and the line below won't be printed.
        System.out.println("I won't be printed since I wasn't handled in a try/catch!");
    }
}

class SomeClassWithMethodsThatThrowsExceptions {
    // Observe that you can marks as throws Exception, but you don't have to explicitly throw an exception for this to compile!
    public void someMethodThatThrowsException() throws Exception {
        System.out.println("I throw a Checked Exception, you will need to handle me!");
        throw new Exception("Checked Exception");
    }

    public void someMethodThatThrowsRuntimeException() throws RuntimeException {
        System.out.println("I throw an RuntimeException - you do NOT need to handle me, but you can if you want!");
        throw new RuntimeException("Runtime Exception");
    }
}