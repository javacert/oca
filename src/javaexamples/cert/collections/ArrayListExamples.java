package javaexamples.cert.collections;

import java.util.ArrayList;
import java.util.List;

// ArrayList extends java.util.AbstractList and implements Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess
// RandomAccess is a marker interface used by List implementations to indicate that they support fast (generally constant time) random access.
// You can sort its elements using Collections.sort() method.
// It allows you to access its elements in random order using get(index) method.
// An ArrayList, just like an array is not thread safe.
// ArrayList and Arrays are both type safe. ArrayList<String> al = new ArrayList<>(); vs String[] sa = new String[10];
public class ArrayListExamples {
    public static void main(String[] args){
        arrayListCanAcceptPrimitives();
    }

    private static void arrayListCanAcceptPrimitives() {
        // ArrayLists can only take Objects, but primitives are Autoboxed so can be used.
        List al = new ArrayList();
        al.add(111); // Autoboxed to an Integer
        al.add(10.2); // Autoboxed to an Double
        System.out.println(al.get(al.size())); // IndexOutOfBoundsException: Index: 2, Size: 2
    }
}
