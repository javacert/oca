package javaexamples.cert.exceptions;

import java.io.FileNotFoundException;

// A method can declare to throw any type of exception, checked or unchecked, even if it doesn't do so.
// But a try block can't define a catch block for a checked exception (other than Exception) if the try block
// doesn't throw that checked exception or use a method that declares to throw that checked exception
public class CatchUnthrownCheckedExceptionExample {

    // The following shows what happens when you throw a checked exception without declaring it
    public static void main(String[] args) throws SomeCheckedException { // will only compile with the throws clause
        throw new SomeCheckedException(); // Must have the throws clause above.
    }
}

class SomeCheckedException extends Exception {

}

// The following compile even though they don't contain any code to actually throw the exception
class ThrowExceptions {
    void method1() throws Error {}
    void method2() throws Exception {}
    void method3() throws Throwable {}
    void method4() throws RuntimeException {}
    void method5() throws FileNotFoundException {}
}

// Although a try block can define a handler for unchecked exceptions not thrown by it,
// it can't do so for checked exceptions (other than Exception)
class HandleExceptions {
    void method6() {
        try {}
        catch (Error e) {}
    }
    void method7() {
        try {}
        catch (Exception e) {} // Works, but only for Exception, not other checked exceptions subclasses from Exception
    }
    void method8() {
        try {}
        catch (Throwable e) {}
    }
    void method9() {
        try {}
        catch (RuntimeException e) {}
    }
    void method10() {
        try {}
        catch (NullPointerException e) {}
    }

    // What happens when a checked exception other than Exception is caught?
    void method11() {
        try {}
        //catch (FileNotFoundException e) {} // --> Won't compile since FileNotFoundException not thrown in the try
        finally {}
    }

    // We need to throw the exception (either through a method or directly in the try
    void method12() {
        try {
            throw new FileNotFoundException();
        }
        catch (FileNotFoundException e) {}
        finally {}
    }
}
