package javaexamples.cert.exceptions;

import java.io.IOException;

// All sub-classes of Throwable are checked except sub-classes of Error and RuntimeException.
// (You can sub-class Throwable directly)
public class ThrowingThrowableExamples {

    public static void main(String[] args){
        // method1(); // Unhandled Exception java.lang.Thowable

        try {
            method1();
        } catch(Exception e){
            System.out.println("A"); // Prints A - most specific of the available catches.
        } catch(Throwable e){
            System.out.println("B");
        }

        try {
            // Can catch Throwable even though not thrown in try.
        } catch(Throwable e){
            System.out.println("B");
        }
    }

    public static void method1() throws Throwable{
        throw new IOException(); // Okay because it is a subclass of Throwable
    }
}
