package javaexamples.cert.arrays;

import java.util.Arrays;

public class ArraysUtilExamples {

    public static void main(String[] args){
        arraysSortExample();
        arraysEqualsExample();
    }

    private static void arraysSortExample() {
        // Observe in the following line that the [] is immediately beside the variable name
        String []strings = {"N", "L", "n", "O", "S", "z", "a", "10", "2", "1", "S1", "S2", "S10", "s10", "SA", "Sa"};
        Arrays.sort(strings);

        // Numeric values sort first
        // Lowercase will come AFTER Uppercase in the Natural order of things
        // In the example below watch how the first letter is sorted first, then we apply the same rules to the second char
        for (String s: strings) {
            System.out.print(s + " "); // 1 10 2 L N O S S1 S10 S2 SA Sa a n s10 z
        }
    }

    private static void arraysEqualsExample() {
        int[] a1 = {2, -1, 4, 5, 3};
        int[] a2 = {2, -1, 4, 5, 3};

        System.out.println(Arrays.equals(a1, a2));
        // The following does not compile - public static boolean deepEquals(Object[] a1, Object[] a2)
        // You cannot cast a primitive array to an Object[]. In Java, primitive types and reference types are two
        // distinct worlds. This reflects to arrays: A primitive array is not an object array, that's why you can't cast.
        // System.out.println(Arrays.deepEquals(a1, a2));
    }
}
