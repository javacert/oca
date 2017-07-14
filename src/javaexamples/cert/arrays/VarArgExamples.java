package javaexamples.cert.arrays;

import java.util.Arrays;

public class VarArgExamples {

    public static void main(String... args){
        usingVarArgsOutsideOfMethodParameters(args);
    }

    private static void usingVarArgsOutsideOfMethodParameters(String... args) {
        // String... copy =  --> You cannot use varargs outside of method parameters
        // You can of course assign to an array
        String[] someArray = args;
        System.out.println(Arrays.toString(args)); // [] when java VarArgExamples without parameters
    }
}
