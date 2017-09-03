package javaexamples.cert.exceptions;

// This example shows that the following will not compile, not because e is null, (throws a NullPointer at runtime),
// but because we are throwing a checked exception but not handling it with a try/catch.

// A NullPointerException will be thrown if the expression given to the throw statement results in a null pointer.
public class ThrowNullCheckExceptionExample {

    public static void main(String args[]) {
        Exception e = null;
        // throw e; // --> Needs a try/catch

        // If we do surround it with a try/catch, we get a NullPointerException at runtime
        // java.lang.NullPointerException
        //      at javaexamples.cert.exceptions.ThrowNullCheckExceptionExample.main(ThrowNullCheckExceptionExample.java:12)
        try {
            throw e;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}