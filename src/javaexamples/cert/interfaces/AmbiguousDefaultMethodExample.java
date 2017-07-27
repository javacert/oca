package javaexamples.cert.interfaces;

// Note in this example we are implementing 2 interfaces with the same default method.
// For this to compile we needed to add an overridden version of the method.
public class AmbiguousDefaultMethodExample implements SomeInterfaceA, SomeInterfaceB {

    // int someAmbiguousMethod(){ return 10; } // --> Won't compile since access modifier is more restrictive

    // This class will not compile if you don't override the ambiguous method as below.
    public int someAmbiguousMethod(){ return 10; }
}

interface SomeInterfaceA {
    default int someAmbiguousMethod(){ return 1; }
}

interface SomeInterfaceB {
    public default int someAmbiguousMethod(){ return 7; }
}
