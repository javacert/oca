package javaexamples.cert.exceptions;

// This example demonstrates several points
// 1) The main method throws Exception, therefore we do not need to have a try/catch to handle exceptions thrown from Lair
// 2) openDrawBridge throws Exception, but actually throws both Runtime and Checked Exceptions. This is fine since all
//    of the exceptions extend Exception and main handles the generic Exception type.
// 3) If you change the Exception thrown by main to DragonException/RuntimeException, then we would need to try/catch it.
// 4) closeDrawBridge introduces an Error - if we update main to throws Throwable then we can also call this method
//    without handling the errors.
public class CatchingMultipleExceptionTypesExample {

    public static void main(String[] args) throws Exception /* DragonException */ {
        new Lair().openDrawBridge();
        // new Lair().closeDrawBridge(); // --> this won't compile unless main throws Throwable!
    }
}

class DragonException extends Exception{}
class Lair {
    public void openDrawBridge() throws Exception {
        try {
            throw new Exception("A Checked Exception");
        } catch (RuntimeException e){
            throw new DragonException();
        } finally {
            throw new RuntimeException("Runtime from the finally");
        }
    }

    public void closeDrawBridge() throws Throwable {
        try {
            throw new Exception("A Checked Exception");
        } catch (RuntimeException e){
            throw new Error("Oh dear!");
        } finally {
            throw new RuntimeException("Runtime from the finally");
        }
    }
}
