package javaexamples.cert.exceptions;

// Notes:
// The class of the common exception reference e will be the closest common super class of all the exceptions in the
// catch block. In the catch below it will be Exception since all 3 exceptions extends Exception.
public class MultiCatchBlockExamples {

    public static void main(String [] args){
        basicMultiCatchExample(args);
    }

    // When using the multi-catch block, the exception is implicitly final - therefore you cannot reassign it.
    private static void basicMultiCatchExample(String [] args) {
        try {
            System.out.println(args[0]);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e){
            if (e instanceof ArrayIndexOutOfBoundsException) {
                // e = new ArrayIndexOutOfBoundsException(); // Cannot do, e is a final variable
            }
        } catch(RuntimeException e) {
            if (e instanceof ArrayIndexOutOfBoundsException) {
                e = new ArrayIndexOutOfBoundsException(); // This is fine though!
            }
        }
    }
}
