package javaexamples.cert.miscellaneous;

// This example results in a StackOverflowError because every instance of Emp creates another instance of Emp.
// Exception in thread "main" java.lang.StackOverflowError
public class ClassBasedStackOverflowError {

    public static void main(String[] args) {
        Emp e = null;
        e = new Emp();
        e = null;
    }
}

class Emp {
    Emp mgr = new Emp();
}
