package javaexamples.cert.miscellaneous;

public class InitializeStaticVariableInInstanceInitializer {

    static final int x;
    static int y;

    {
        y = 0; // we can initialize static (non-final) variables in an instance initializer
    }

    // static final must be initialized in a static initializer
    static {
        x = 1;
    }
}
