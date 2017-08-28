package javaexamples.cert.collections;

import java.util.ArrayList;
import java.util.List;

// ArrayList extends java.util.AbstractList and implements Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess
// RandomAccess is a marker interface used by List implementations to indicate that they support fast (generally constant time) random access.
// You can sort its elements using Collections.sort() method.
// It allows you to access its elements in random order using get(index) method.
// An ArrayList, just like an array is not thread safe.
// ArrayList and Arrays are both type safe. ArrayList<String> al = new ArrayList<>(); vs String[] sa = new String[10];
// To access the elements of an ArrayList, you can use get(), an enhanced for loop, Iterator, or ListIterator.
// Iterator vs ListIterator:
//    1) Iterator is used for traversing List and Set both. We can use ListIterator to traverse List only.
//    2) We can traverse in only forward direction using Iterator. Using ListIterator, we can traverse a List in
//       both directions
//    3) We cannot obtain indexes while using Iterator. We can obtain indexes at any point of time while traversing a
//       list using ListIterator.
//    4) We cannot add element to collection while traversing it using Iterator, it throws
//       ConcurrentModificationException when you try to do it.
//    5) We cannot replace the existing element value when using Iterator. By using set(E e) method of ListIterator
//       we can replace the last element returned by next() or previous() methods.
// The ArrayList remove method compares the objects for equality before removing it from ArrayList by calling the method equals.
// For classes such as StringBuilder that do not override the equals method this would have an impact.
public class ArrayListExamples {

    public static void main(String[] args){
        arrayListCanAcceptPrimitives();
        arrayListAddBeyondRange();
        arrayListAddAllReferenceTrickA();
        arrayListAddAllReferenceTrickB();
    }

    private static void arrayListCanAcceptPrimitives() {
        // ArrayLists can only take Objects, but primitives are Autoboxed so can be used.
        List al = new ArrayList();
        al.add(111); // Autoboxed to an Integer
        al.add(10.2); // Autoboxed to an Double
        System.out.println(al.get(al.size())); // IndexOutOfBoundsException: Index: 2, Size: 2
    }

    private static void arrayListAddBeyondRange() {
        List list = new ArrayList();
        list.add("val1");
        list.add(2, "val2"); // java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
        list.add(1, "val3");
        System.out.println(list);
    }

    private static void arrayListAddAllReferenceTrickA() {
        ArrayList<StringBuilder> myArrList = new ArrayList<>();
        myArrList.add(new StringBuilder("One"));
        myArrList.add(new StringBuilder("Two"));

        ArrayList<StringBuilder> yourArrList = new ArrayList<>();
        yourArrList.add(new StringBuilder("Three"));
        yourArrList.add(new StringBuilder("Four"));

        myArrList.addAll(1, yourArrList);

        for (StringBuilder val : myArrList) {
            System.out.println(val);
        }
        System.out.println();

        // Watch here:
        // 1) If you reassign the object reference using either of the lists, the value in the second list will remain unchanged.
        // 2) If you modify the internals of any of the common list elements, the change will be reflected in both of the lists.

        // 1) Let's reassign the reference
        yourArrList.set(0, new StringBuilder("Ten"));
        for (StringBuilder val : myArrList) {
            System.out.println(val);
        }
        System.out.println("---");
        for (StringBuilder val : yourArrList) {
            System.out.println(val);
        }
        System.out.println();

        // 2) Let's change the contents of the original array
        yourArrList.get(1).append("I've been updated!");
        for (StringBuilder val : myArrList) {
            System.out.println(val);
        }
        System.out.println("---");
        for (StringBuilder val : yourArrList) {
            System.out.println(val);
        }

        // OUTPUT:
        // One
        // Three
        // Four
        // Two

        // One
        // Three
        // Four
        // Two
        // ---
        // Ten
        // Four

        // One
        // Three
        // FourI've been updated!
        // Two
        // ---
        // Ten
        // FourI've been updated!
    }

    private static void arrayListAddAllReferenceTrickB() {
        ArrayList<String> myArrList = new ArrayList<>();
        String one = "One";
        String two = new String("Two");
        myArrList.add(one);
        myArrList.add(two);
        ArrayList<String> yourArrList = myArrList;
        one.replace("O", "B");

        for (String val : myArrList)
            System.out.print(val + ":");

        for (String val : yourArrList)
            System.out.print(val + ":");

        // OUTPUT: One:Two:One:Two:
    }
}
