package javaexamples.cert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This example shows that asList is fixed-size, meaning that you cannot add or remove any elements
// after the List/Array creation or you will receive a RuntimeException.

// asList returns a fixed-size list backed by the specified array. Changes to the returned list "write through" to
// the array.)  This method acts as bridge between array-based and collection-based APIs, in combination with toArray

// toArray returns an array containing all of the elements in this list in proper sequence (from first to last element);
// the runtime type of the returned array is that of the specified array.  If the list fits in the specified array,
// it is returned therein.  Otherwise, a new array is allocated with the runtime type of the specified array and the
// size of this list.
public class ArraysAsListExample {
    public static void main(String[] args){
        asListExample();
        toArrayExample();
        asListModifyExample();
        toArrayModifyExample();
    }

    private static void asListExample() {
        String[] array = { "Natural History", "Science", "Art" };
        List<String> museums = Arrays.asList(array);
        System.out.println(museums); // [Natural History, Science, Art]
    }

    private static void toArrayExample() {
        List<String> list = new ArrayList<>();
        list.add("Natural History");
        list.add("Science");
        list.add("Art");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        System.out.println(Arrays.toString(array)); // [Natural History, Science, Art]

        // Note that the following will not work.
        // the JVM doesn't know how to blindly downcast Object[] (the result of toArray()) to String[].
        // To let it know what your desired object type is, you can pass a typed array into toArray().
        // The typed array can be of any size (new String[1] is valid), but if it is too small then the
        // JVM will resize it on it's own. We have to do it as shown above.
        // String[] array = (String[])list.toArray();
    }

    private static void asListModifyExample() {
        String[] array = { "Natural History", "Science", "Art" };
        List<String> museums = Arrays.asList(array);
        museums.remove(2); // Exception in thread "main" java.lang.UnsupportedOperationException
        museums.set(0, "Something Else"); // We can modify if we like, but we can't reduce or expand the array.
        System.out.println(museums); // [Something Else, Science, Art] - if we remove the remove(2) line.
    }

    private static void toArrayModifyExample() {
        List<String> list = new ArrayList<>();
        list.add("Natural History");
        list.add("Science");
        list.add("Art");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        array[0] = "Something Else"; // We can modify an existing entry
        list.add("Will I break"); // Has no effect on the array
        System.out.println(Arrays.toString(array)); // [Something Else, Science, Art] - This works!!
    }
}
