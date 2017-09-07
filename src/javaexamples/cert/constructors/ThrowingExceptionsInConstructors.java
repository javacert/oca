package javaexamples.cert.constructors;

import java.io.FileNotFoundException;
import java.io.IOException;

// A constructor of a subclass cannot throw subclass exception
public class ThrowingExceptionsInConstructors extends SomeSubclassWithConstructor {

    // If you remove IOException you get compile error for unhandled exception.
    // Whereas typical method you can only throw the same, none of subclass of the exception, for constructors
    // you can only throw the same or superclass exception.
    // If you throw none or a subclass you will get a compilation error for unhandled exception IOException.
    ThrowingExceptionsInConstructors() throws IOException, NullPointerException, FileNotFoundException {

    }

}

class SomeSubclassWithConstructor {

    SomeSubclassWithConstructor() throws IOException{

    }
}
