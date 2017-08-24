package javaexamples.cert.exceptions;

// Exception Type: Runtime Exceptions - extends RuntimeException
// 1) ArithmeticException - thrown by JVM
// 2) ArrayIndexOutOfBoundsException - thrown by JVM
// 3) ClassCastException - thrown by JVM
// 4) IllegalArgumentException - tricky one, seems like a Checked exception since thrown by programmer
// 5) NullPointerException - thrown by JVM
// 6) NumberFormatException - tricky one, seems like a Checked exception since thrown by programmer -
//         --> also note that NumberFormatException extends IllegalArgumentException extends RuntimeException
// 7) NegativeArraySizeException - thrown by JVM when array initialized with a negative number
// 8) SecurityException - thrown by the programmer - tricky one again since not thrown by JVM

// Exception Type: Checked Exceptions - extends Exception
// 1) FileNotFoundException - thrown programmatically - public class FileNotFoundException extends IOException
// 2) IOException - thrown programmatically - class IOException extends Exception
// 3) ClassNotFoundException - thrown programmatically - using reflection and class doesn't exist

// Exception Type: Errors - extends Error
// 1) ExceptionInInitializerError - thrown by JVM - class ExceptionInInitializerError extends LinkageError
//         --> Runtime exceptions arising from any of the following will throw this error (can be caused by an object of RuntimeException only:
//              1) Execution of an anonymous static block
//              2) Initialization of a static variable
//              3) Execution of a static method (called from either of the previous two items)
// 2) StackOverflowError - thrown by JVM - class StackOverflowError extends VirtualMachineError
// 3) NoClassDefErrorFound - thrown by JVM - class NoClassDefFoundError extends LinkageError
//         --> When JVM class loader cannot locate a class on the classpath

// Main takeaways:
// If you have a try statement and both the catch block and the finally block each throw an exception, then it is the
// exception from the finally block that is propagated to the caller, with the one from the catch being dropped.

// When you use System.out.println(exception), a stack trace is not printed. Just the name of the exception class and the message is printed.
// When you use exception.printStackTrace(), a complete chain of the names of the methods called, along with the line numbers, is printed.

// Exception handling in Java improves code because error handling code is clearly separated from the main program logic.
// A try block may be followed by multiple catch blocks, and the catch blocks may be followed by a single finally block.
// A try block may be followed by either a catch or a finally block or both. But a finally block alone won't suffice
// if code in the try block throws a checked exception. In this case, you need to catch the checked exception or declare
// it to be thrown by your method. Otherwise, your code won't compile.
// The try, catch, and finally blocks can't exist independently.
// The finally block can't appear before a catch block.
// A finally block always executes, regardless of whether the code throws an exception.
// If you rethrow a checked exception you must ensure the method declares a throws for the checked exception.
// Exception has 4 public constructors and 1 protected constructor.
// The first line of printStackTrace() is the output of the toString() method for the object, printing a description of the message.
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
