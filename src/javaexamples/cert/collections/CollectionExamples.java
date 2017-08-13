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
}
