package javaexamples.cert.exceptions;

// Notice that we do not need imports for any of the following.
// This is because all 3 belong to the java.lang package which is imported by default

//import java.lang.Exception;
//import java.lang.RuntimeException;
//import java.lang.Throwable;

public class ImportingBaseLevelExceptionClassesExample {

    public void someMethodWithThrowable() throws Throwable {}
    public void someMethodWithException() throws Exception {}
    public void someMethodWithRuntimeException() throws RuntimeException {}

}
