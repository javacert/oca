package javaexamples.cert.generics;

import java.util.ArrayList;
import java.util.List;

public class BasicGenericExamples {

    public static void main(String[] args){

        List<Integer> i1 = new ArrayList<Integer>();
        List<Integer> i2 = new ArrayList<>();
        // The right side is a raw type meaning the ArrayList can hold every object (not only Integer)
        List<Integer> i3 = new ArrayList();
    }
}
