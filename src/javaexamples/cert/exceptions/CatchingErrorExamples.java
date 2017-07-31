package javaexamples.cert.exceptions;

public class CatchingErrorExamples {

    public static void main(String[] args){
        catchingErrorsExample();
    }

    private static void catchingErrorsExample() {

        // In general, code you write should throw only exceptions, not errors but you can throw errors if you wish.
        // Errors are usually thrown by the methods of the Java API, or by the Java virtual machine itself.
        try {
            throw new Error("I'm an Error");
        } catch (Error e) {
            System.out.println(e.getMessage()); // I'm an Error
        }

        try {
            throw new SomeNewErrorType("I'm a SomeNewErrorType");
        } catch (SomeNewErrorType e) {
            System.out.println(e.getMessage()); // I'm a SomeNewErrorType
            throw new Error("I'm thrown in the catch block!"); // --> Error is dropped in favor of Error in finally block
        } catch (Error e) {
            System.out.println(e.getMessage()); // I'm an Error
        } finally {
            throw new Error("I'm thrown in the finally block!"); // --> This Error is used over an Error thrown in the catch
        }

    }
}

class SomeNewErrorType extends Error {
    SomeNewErrorType(String msg){
        super(msg);
    }
}