package javaexamples.cert.exceptions;

// This example demonstrates what happens when we thrown the exception right up the chain to main.

// When an exception occurs in the code, it interrupts the current method and gives the control back
// to the previous method on the stack trace. If this method can handle the exception (with a catch),
// the catch will be executed, the exception will stop bubbling up. If not, the exception will bubble
// up the stack trace. Ultimately, if it arrives in the main and the main cannot handle it, the program
// will stop with an error.

public class ThrowingRightUpToMainExample {

    public static void main(String[] args) throws Exception {

        System.out.println("The exception is handled in the calling method iWillCatchAnException");
        new ClassToThrowAnException().iWillCatchAnException();

        System.out.println("The main method handles the exception thrown in the calling method.");
        try {
            new ClassToThrowAnException().iWillPassTheExceptionBackToMain();
        } catch (Exception e){
            System.out.println("I will catch the exception and handle it gracefully allowing the execution to continue");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Since I do not catch the exception, I break the program execution and end with an error");
        new ClassToThrowAnException().iWillPassTheExceptionBackToMain();
        System.out.println("You will never see me since execution is broken!");
    }
}

class ClassToThrowAnException {
    public void iWillCatchAnException() throws Exception {
        try {
            throw new Exception(" --> Some Error Message from ClassToThrowAnException - iWillCatchAnException");
        } catch (Exception e){
            System.out.println(e.getMessage()); // Some Error Message from ClassToThrowAnException - iWillCatchAnException
            e.printStackTrace();
/*          java.lang.Exception: Some Error Message from ClassToThrowAnException
               at javaexamples.cert.exceptions.ClassToThrowAnException.iWillThrowAnException(ThrowingRightUpToMainExample.java:13)
               at javaexamples.cert.exceptions.ThrowingRightUpToMainExample.main(ThrowingRightUpToMainExample.java:6)*/
        }
    }

    public void iWillPassTheExceptionBackToMain() throws Exception {
        throw new Exception(" --> Some Error Message from ClassToThrowAnException - iWillPassTheExceptionBackToMain");
/*      Exception in thread "main" java.lang.Exception: Some Error Message from ClassToThrowAnException - iWillPassTheExceptionBackToMain
           at javaexamples.cert.exceptions.ClassToThrowAnException.iWillPassTheExceptionBackToMain(ThrowingRightUpToMainExample.java:26)
           at javaexamples.cert.exceptions.ThrowingRightUpToMainExample.main(ThrowingRightUpToMainExample.java:7)*/
    }
}

/* OUTPUT:
    The exception is handled in the calling method iWillCatchAnException
     --> Some Error Message from ClassToThrowAnException - iWillCatchAnException
    The main method handles the exception thrown in the calling method.
    java.lang.Exception:  --> Some Error Message from ClassToThrowAnException - iWillCatchAnException
    I will catch the exception and handle it gracefully allowing the execution to continue
        at javaexamples.cert.exceptions.ClassToThrowAnException.iWillCatchAnException(ThrowingRightUpToMainExample.java:30)
     --> Some Error Message from ClassToThrowAnException - iWillPassTheExceptionBackToMain
    Since I do not catch the exception, I break the program execution and end with an error
        at javaexamples.cert.exceptions.ThrowingRightUpToMainExample.main(ThrowingRightUpToMainExample.java:12)
    java.lang.Exception:  --> Some Error Message from ClassToThrowAnException - iWillPassTheExceptionBackToMain
        at javaexamples.cert.exceptions.ClassToThrowAnException.iWillPassTheExceptionBackToMain(ThrowingRightUpToMainExample.java:41)
        at javaexamples.cert.exceptions.ThrowingRightUpToMainExample.main(ThrowingRightUpToMainExample.java:15)
    Exception in thread "main" java.lang.Exception:  --> Some Error Message from ClassToThrowAnException - iWillPassTheExceptionBackToMain
        at javaexamples.cert.exceptions.ClassToThrowAnException.iWillPassTheExceptionBackToMain(ThrowingRightUpToMainExample.java:41)
        at javaexamples.cert.exceptions.ThrowingRightUpToMainExample.main(ThrowingRightUpToMainExample.java:22)
*/
