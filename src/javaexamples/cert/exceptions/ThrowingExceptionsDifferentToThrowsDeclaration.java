package javaexamples.cert.exceptions;

import java.io.FileNotFoundException;

// This example demonstrates what you can actually throw when you declare an exception.
// 1) You cannot throw a broader (superclass) exception.
// 2) You can throw any Runtime Exception, or any Error
// 3) You don't have to throw anything at all.
// 4) You can throw any more specific exception (i.e. subclass).
public class ThrowingExceptionsDifferentToThrowsDeclaration {

    public static void main(String[] args){
    }

    public void methodA() throws FileNotFoundException {
        // You don't have to throw anything
    }

    public void methodB() throws FileNotFoundException {
        // You can throw the exception declared in the throws
        throw new FileNotFoundException();
    }

    public void methodC() throws FileNotFoundException {
        // You CANNOT throw a broader exception (superclass)
        //throw new IOException();
    }

    public void methodD() throws FileNotFoundException {
        // You CAN throw a more specific exception
        throw new SomeMoreSpecificException();
    }

    public void methodE() throws FileNotFoundException {
        // You can throw any RuntimeExceptions that you want!
        throw new NullPointerException();
    }

    public void methodF() throws FileNotFoundException {
        // You can throw any Error that you want!
        throw new StackOverflowError();
    }
}

class SomeMoreSpecificException extends FileNotFoundException {

}