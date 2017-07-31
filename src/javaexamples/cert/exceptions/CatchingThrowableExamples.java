package javaexamples.cert.exceptions;

public class CatchingThrowableExamples {

    public static void main(String[] args){
        catchThrowableForAllExceptionsExample();
    }

    private static void catchThrowableForAllExceptionsExample() {

        // You can use Throwable to catch all types of Error or Exception.
        try {
            throw new Exception("I'm a checked exception");
        } catch (Throwable t) {
            System.out.println(t.getMessage()); // I'm a checked exception
        }

        try {
            throw new RuntimeException("I'm a Runtime exception");
        } catch (Throwable t) {
            System.out.println(t.getMessage()); // I'm a Runtime exception
        }

        try {
            throw new Error("I'm an Error");
        } catch (Throwable t) {
            System.out.println(t.getMessage()); // I'm an Error
        }
    }
}
