package javaexamples.cert.collections;

// Note that these collections live in the java.util package
// ArrayLists are initialized with an initial capacity of 10 - private static final int DEFAULT_CAPACITY = 10
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class CollectionExamples {

    public static void main(String[] args){
        List myList = new ArrayList();
        spliteratorExample();
        setExample();
        arrayListExamples();
    }

    private static void spliteratorExample() {
        // spliterator was introduced with Java 8
        ArrayList<Integer> number_List;
        Spliterator<Integer> mySpliterator;

        number_List = new ArrayList<> ();

        number_List.add(1);
        number_List.add(2);
        number_List.add(3);
        number_List.add(4);

        mySpliterator = number_List.spliterator();

        // Characteristics Of Spliterator are : 16464
        System.out.println("Characteristics Of Spliterator are : " + mySpliterator.characteristics());
    }

    private static void setExample() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list.set(3, "E")); // D - remember that set replaces an element and then returns the removed element
        System.out.println(list.set(4, "E")); // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 4, Size: 4
    }

    private static void arrayListExamples() {
        ArrayList<Double> al = new ArrayList<>();
        // al.add(111); // Won't compile - you can't widen to a double and then box in one go
        al.add(2.0); // Here we are only boxing!
        System.out.println(al.indexOf(1.0));        // -1 since it doesn't exist
        System.out.println(al.contains("string"));  // false
    }
}
