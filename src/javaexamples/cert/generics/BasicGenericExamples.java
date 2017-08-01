package javaexamples.cert.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicGenericExamples {

    public static void main(String[] args){

        genericInitializationExamples();
        genericsWithArraysAsListExample();
        diamondOperatorOnlyNeededOnRightExample();
    }

    private static void genericInitializationExamples() {
        List<Integer> i1 = new ArrayList<Integer>();
        List<Integer> i2 = new ArrayList<>();
        // The right side is a raw type meaning the ArrayList can hold every object (not only Integer)
        List<Integer> i3 = new ArrayList();
    }

    private static void genericsWithArraysAsListExample() {
        String[] array = { "Natural History", "Science"};
        List<String> museums = Arrays.asList(array);

        // Notice the following code which allows for generic assignment above
        //public static <T> List<T> asList(T... a) {
        //    return new Arrays.ArrayList<>(a);
        //}

        // List<Integer> museums = Arrays.asList(array); // --> This won't compile since the array is of type String
    }

    private static void diamondOperatorOnlyNeededOnRightExample() {
        // Diamond Operator is a shortcut which says infer the type from the left hand side
        // In this case there is nothing to infer but it is still valid syntax.
        List balloons = new ArrayList<>();
    }
}
