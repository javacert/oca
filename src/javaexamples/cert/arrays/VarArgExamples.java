package javaexamples.cert.arrays;

import java.util.Arrays;

public class VarArgExamples {

    public static void main(String... args){
        usingVarArgsOutsideOfMethodParameters(args);

        callingAVararg("David", "Peter", "Andrew"); // Fine - treated as vararg
        callingAVararg(new String[]{ "David", "Peter", "Andrew" }); //Fine

        // callingAnArray("David", "Peter", "Andrew"); // Array parameter won't accept this!
        callingAnArray(new String[]{ "David", "Peter", "Andrew" }); //Fine
    }

    private static void usingVarArgsOutsideOfMethodParameters(String... args) {
        // String... copy =  --> You cannot use varargs outside of method parameters
        // You can of course assign to an array
        String[] someArray = args;
        System.out.println(Arrays.toString(args)); // [] when java VarArgExamples without parameters
    }

    private static void callingAVararg(String... vararg) {}

    private static void callingAnArray(String[] strings) {}

    // vararg must always be last in the list - this won't compile
    // private static void callingAnArray(String... varargMustComeLast, String[] strings) {}
    private static void callingAnArray(String[] strings, String... varargMustComeLast) {} // Fine
}
