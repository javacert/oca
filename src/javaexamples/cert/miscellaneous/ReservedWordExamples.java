package javaexamples.cert.miscellaneous;

public class ReservedWordExamples {

    transient int x = 0; // Must be at class level
    transient static int y = 0;

    public static void main(String[] args){
        transientExample();
        nativeExample();
    }

    private static void transientExample() {
        // transient int x = 0; // Modifier not allowed here
    }

    // The native keyword is applied to a method to indicate that the method
    // is implemented in native code using JNI (Java Native Interface)
    private static void nativeExample() {
        // native int x = 0; // Modifier native not allowed here
    }

    // native void method(){} // Native methods cannot have a body
    native void method();
}
