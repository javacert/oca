package javaexamples.cert.exceptions;

// ExceptionInInitializerError can be caused by an object of RuntimeException only.
// It can’t occur as the result of an error or checked exception thrown by the static initialization block.
public class ExceptionInInitializerErrorExample {

    static {
        //int num = Integer.parseInt("sd", 16);
    }
    // java.lang.ExceptionInInitializerError
    // Caused by: java.lang.NumberFormatException: For input string: "sd"

    static String someStringA = getName(); // Note that in the following we get a ExceptionInInitializerError
    // static String someStringB = getNameB(); // Unhandled Exception
    // java.lang.ExceptionInInitializerError
    // Caused by: java.lang.RuntimeException

    public static void main(String[] args){
        // Note that in the following we get a RuntimeException
        getName(); //Exception in thread "main" java.lang.RuntimeException
    }

    static String getName() {
        throw new RuntimeException();
    }

    static String getNameB() throws Exception {
        throw new Exception();
    }
}
