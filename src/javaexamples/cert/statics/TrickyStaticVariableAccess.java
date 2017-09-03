package javaexamples.cert.statics;

// This example shows that you need to be careful when accessing static variables, because they can still be
// accessed when a reference is assigned to null (since it is static). Look out for examples such as these!

// The compiler creates the instruction for the JVM to access this field directly using the class reference instead
// of the object reference returned by the method at runtime.
public class TrickyStaticVariableAccess {

    static String someStaticString = "Some String Value";

    static TrickyStaticVariableAccess getTrickyStaticVariableAccess() {
        System.out.println("Getting DB");
        return null;
    }

    public static void main(String[] args) {
        // Even though the reference returned is null, we can still access it since it is a static variable.
        System.out.println(getTrickyStaticVariableAccess().someStaticString);

        // OUTPUT:
        // Getting DB
        // Some String Value
    }
}