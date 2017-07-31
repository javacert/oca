package javaexamples.cert.exceptions;

// Exception Type: Runtime Exceptions - extends RuntimeException
// 1) ArithmeticException - thrown by JVM
// 2) ArrayIndexOutOfBoundsException - thrown by JVM
// 3) ClassCastException - thrown by JVM
// 4) IllegalArgumentException - tricky one, seems like a Checked exception since thrown by programmer
// 5) NullPointerException - thrown by JVM
// 6) NumberFormatException - tricky one, seems like a Checked exception since thrown by programmer

// Exception Type: Checked Exceptions - extends Exception
// 1) FileNotFoundException - thrown programmatically - public class FileNotFoundException extends IOException
// 2) IOException - thrown programmatically - class IOException extends Exception

// Exception Type: Errors - extends Error
// 1) ExceptionInInitializerError - thrown by JVM - class ExceptionInInitializerError extends LinkageError
// 2) StackOverflowError - thrown by JVM - class StackOverflowError extends VirtualMachineError
// 3) NoClassDefErrorFound - thrown by JVM - class NoClassDefFoundError extends LinkageError

// Main takeaways:
// If you have a try statement and both the catch block and the finally block each throw an exception, then it is the
// exception from the finally block that is propagated to the caller, with the one from the catch being dropped.
public class BasicExceptionExamples {

    public static void main(String[] args) {
        basicTryCatchExamples();
        orderOfExceptionsIsImportant();
        throwingANewExceptionWithinATryCatch();
    }

    private static void basicTryCatchExamples() {

        // A try block can have either a catch or a finally, or both.

/*        try{
            System.out.print("A try needs either a catch or a finally to compile ");
        }*/

        try {
            System.out.print("A ");
        } finally {
            System.out.println("B");
        } // Prints A B

        try {
            System.out.print("A ");
            throw new Exception("Some Message Text");
        } catch (Exception e) {
            System.out.print("B ");
            System.out.println(e);
        } // Prints A B java.lang.Exception: Some Message Text

        try {
            System.out.print("A ");
            throw new SomeException("Some Message Text");
        } catch (Exception e) {
            System.out.print("B ");
            System.out.println(e);
        } // Prints A B com.cert.SomeException: Some Message Text

        // Order is important, you can'y have finally and then catch.
/*        try {
            System.out.print("A ");
        } finally {

        } catch (Exception e) {

        }*/
    }

    private static void orderOfExceptionsIsImportant() {
        /*
        try {
            System.out.print("A ");
            throw new SomeException("Some Message Text");
        } catch (Exception e) {
            System.out.print("B ");
            System.out.println(e);
        } catch (SomeException e) { // Does not compile since Exception is a superclass to SomeException
            System.out.print("B ");
            System.out.println(e);
        }
        */

        try {
            System.out.print("A ");
            throw new SomeException("Some Message Text");
        }
/*        catch (RuntimeException e) { // Couldn't have this here as would result in compiler error because of NullPointerException
            System.out.print("B ");
            System.out.println(e);
        } */
        catch (NullPointerException e) { // You can mix RuntimeExceptions and Checked Exceptions
            System.out.print("B ");
            System.out.println(e);
        } catch (SomeException e) {
            System.out.print("C ");
            System.out.println(e);
        }// Prints A B com.cert.SomeException: Some Message Text
    }

    private static void throwingANewExceptionWithinATryCatch() {
        // When an new exception is thrown in a catch block or finally block that will propagate out of that block,
        // then the current exception will be aborted (and forgotten) as the new exception is propagated outward.
        // The new exception starts unwinding up the stack just like any other exception, aborting out of the current block
        // (the catch or finally block) and subject to any applicable catch or finally blocks along the way.
        // When a new exception is thrown in a catch block, the new exception is still subject to that catch's finally block, if any.
        System.out.print("A "); // This is printed
        try {
            System.out.print("B "); // This is also printed
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.print("C "); // This is also printed
            //throw new RuntimeException("1"); // We throw this and existing exception is aborted, remember that the finally bock is still executed!!
        } catch (RuntimeException e) {
            System.out.print("D "); // This is NOT printed
            //throw new RuntimeException("2"); // We never get here since we are throwing a new RunTimeException not managed in this try/catch
        } finally {
            System.out.println("E"); // This is also printed
            //throw new RuntimeException("3"); // This is the Exception that is actually thrown since it takes over from the previously thrown
        } // Prints A B C E and throws Exception in thread "main" java.lang.RuntimeException: 3

        // Note in the above throw new RuntimeException had to be commented out otherwise we would get unreachable statement in the following

        System.out.print("A "); // This is printed
        try {
            System.out.print("B "); // This is also printed
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("1"); // We throw this and existing exception is aborted, remember that the finally bock is still executed!!
            //System.out.print("C "); // This is NOT printed since the new exception takes precedence and current exception is aborted - it becomes an unreachable statement
        } catch (RuntimeException e) {
            System.out.print("D "); // This is NOT printed
            throw new RuntimeException("2"); // We never get here since we are throwing a new RunTimeException not managed in this try/catch
        } finally {
            System.out.println("E"); // This is also printed
            throw new RuntimeException("3"); // This is the Exception that is actually thrown since it takes over from the previously thrown
        } // Prints A B E and throws Exception in thread "main" java.lang.RuntimeException: 3
    }
}

class SomeException extends Exception {

    public SomeException(String msg){
        super(msg);
    }

}
