package javaexamples.cert.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionEdgeCaseExamples {

    public static void main(String[] args){
        unreachableException();

        // In the following example throwADifferentExceptionToTheThrows throws IOException
        // which is a superclass to FileNotFoundException
        try {
            throwADifferentExceptionToTheThrows();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException"); // This is printed and not IOException!!!!
        } catch (IOException e) {
            System.out.println("IOException");
        }
        // If we added the following after IOException we could get the message FileNotFoundException has already
        // been caught. This is because IOException is the superclass and these need to be in correct order.
/*        catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException"); // This is printed and not IOException!!!!
        }*/

        // Outputs the following
        // FileNotFoundException
        // finally
        // Catching the Exception :-)
        try{
            throwNullPointerButCatchClassCastException();
        } catch (Exception e){
            System.out.println("Catching the Exception :-)");
        }

        // Now without the try/catch - outputs the following
        // finally
        // Exception in thread "main" java.lang.NullPointerException
        //    at javaexamples.cert.exceptions.ExceptionEdgeCaseExamples.throwNullPointerButCatchClassCastException(ExceptionEdgeCaseExamples.java:56)
        //    at javaexamples.cert.exceptions.ExceptionEdgeCaseExamples.main(ExceptionEdgeCaseExamples.java:34)
        throwNullPointerButCatchClassCastException();
    }

    private static void unreachableException() {
        try {
            // If you comment out the following line of code, then the catch becomes a compiler error with
            // Exception 'java.io.FileNotFoundException' is never thrown in the corresponding try block
            throw new FileNotFoundException();
        } catch (FileNotFoundException e){

        }
    }

    // This is fine to return a different exception as long as it is a superclass of enclosing method exception.
    // The calling method still needs to handle the IOException in the try/catch block - see above.
    // This would NOT work with the checked exception ClassNotFoundException, since it is not in the hierarchy
    private static void throwADifferentExceptionToTheThrows() throws IOException /* ClassNotFoundException */ {
        throw new FileNotFoundException();
    }

    // This method does not use throws declaration since it only throws RuntimeExceptions
    private static void throwNullPointerButCatchClassCastException() {
        try{
            throw new NullPointerException(); // Runtime Exception
        } catch (ClassCastException e){ // Runtime Exception - Remember that ClassNotFoundException is the checked!
            System.out.println("ClassCastException");
        } finally {
            System.out.println("finally");
        }
        System.out.println("At the end - never gets here since NullPointerException output after finally block");
    }
}
