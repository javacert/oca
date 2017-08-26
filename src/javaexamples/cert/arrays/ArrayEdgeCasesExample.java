package javaexamples.cert.arrays;

import java.util.ArrayList;

public class ArrayEdgeCasesExample {
    public static void main(String[] args){
        reassignmentWhileAccessingArray();
        crazyArrayExamples();
    }

    private static void reassignmentWhileAccessingArray() {
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 3, 1, 0};
        System.out.println(a[(a = b)[3]]); // 1

        // In an array access, the expression to the left of the brackets appears to be fully evaluated before
        // any part of the expression within the brackets is evaluated. In the expression a[(a=b)[3]], the expression
        // a is fully evaluated before the expression (a=b)[3]
        // This means that the original value of a is fetched and remembered while the expression (a=b)[3] is evaluated.
        // Therefore:
        // 1) a[] will refer to the original array a
        // 2) (a=b)[3] will return array index of 0
        // 3) Therefore a[0] of original array a, is 1
        // Note that if evaluation of the expression to the left of the brackets completes abruptly,
        // no part of the expression within the brackets will appear to have been evaluated.
    }


    private static void crazyArrayExamples() {
        // This is valid, primitive is Autoboxed to Integer wrapper
        Object[] someObjectArray = new Object[]{ "aaa", new Object(), new ArrayList(), 10};
        someObjectArray = new Object[]{ "aaa", new Object(), new ArrayList(), new String[]{""} };

        // You cannot use {} as compiler throws illegal initializer for java.lang.Object
        //someObjectArray = new Object[]{ "aaa", new Object(), new ArrayList(), {} };
        // It needs to be in the following format:
        someObjectArray = new Object[]{ "aaa", new Object(), new ArrayList(), new Double[]{1.1} };
    }
}
