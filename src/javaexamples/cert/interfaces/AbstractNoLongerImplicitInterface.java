package javaexamples.cert.interfaces;

public interface AbstractNoLongerImplicitInterface {

    // Implicit modifiers are used when no other modifiers are specified.
    // abstract is implied when neither static nor default has been specified.
    // And all methods are always public whether implicit or explicit.
    // Note that interface fields were always implicitly public static.

    public void someMethod();
    // abstract is implied when neither static nor default has been specified
    public abstract void someOtherMethod();

    public default int someDefaultMethod(){
        return 0;
    }

    public static int someStaticMethod(){
        return 0;
    }

}
