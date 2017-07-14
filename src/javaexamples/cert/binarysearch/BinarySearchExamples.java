/* BINARY SEARCH
 * Searches the specified array for the specified object using the binary
 * search algorithm. The array must be sorted into ascending order
 * according to the Comparable natural ordering of its elements prior to making this call.
 * If it is not sorted, the results are undefined. If the natural ordering is already there,
 * then this will work fine.
 *
 * Definition: Search a sorted array by repeatedly dividing the search interval in half.
 * Begin with an interval covering the whole array. If the value of the search key is less
 * than the item in the middle of the interval, narrow the interval to the lower half.
 */
package javaexamples.cert.binarysearch;

import java.util.Arrays;

public class BinarySearchExamples {

    public static void main(String[] args){

        binarySearchWithoutSort();
        binarySearchWithASort();
        binarySearchWithSortButValueDoesNotExist();
        binarySearchWithArray(new String[]{"seed", "flower"});
        binarySearchWithArrayVariation(new String[]{"seed", "flower"});
        binarySearchOnAnAlreadySortedArray();
    }

    private static void binarySearchWithoutSort() {
        String[] search = { "A0", "8", "12", "Z" };
        int whatIsIt = Arrays.binarySearch(search, "44");
        System.out.println(whatIsIt); // Remember need to sort first before doing a binary search - result is unpredictable
    }

    private static void binarySearchWithASort() {
        String[] search = { "A0", "8", "12", "Z", "AA", "A1", "44" };
        // Sorts the specified range of the specified array of objects into ascending order, according to the natural ordering of its elements
        Arrays.sort(search);
        System.out.println(search); // [Ljava.lang.String;@28d93b30
        // Remember first character is sorted numeric first, then characters
        System.out.println(search[0] + " " + search[1] + " " + search[2] + " " + search[3] + " " + search[4] + " " + search[5] + " " + search[6]); // 12 44 8 A0 A1 AA Z
    }

    private static void binarySearchWithSortButValueDoesNotExist() {
        String[] search = { "A0", "8", "12", "Z" };
        Arrays.sort(search); // NOTE when I excluded this line the result below was -1!!!
        int result = Arrays.binarySearch(search, "44");
        // Negative value showing one smaller than the negative of the index
        System.out.println(result); // -2 (remember, index where it should be (in this case 1), times -1, -1 = -2)
    }

    private static void binarySearchWithArray(String[] someArray) {
        String one = someArray[0];
        Arrays.sort(someArray);
        System.out.println(one); // This is still seed unaffected by the sort
        int position = Arrays.binarySearch(someArray, one);
        System.out.println(position); // Prints 1
    }

    private static void binarySearchWithArrayVariation(String[] someArray) {
        // someArray = new String[]{"seed", "flower"}
        System.out.println(someArray[0]); // seed initially before the sort
        Arrays.sort(someArray);
        System.out.println(someArray[0]); // flower - affected by the sort!
        // String position = Arrays.binarySearch(someArray, someArray[0]); // Watch out for the return!
        int position = Arrays.binarySearch(someArray, someArray[0]); // Searching for flower!
        System.out.println("Binary Search with someArray[0]: " + position); // Prints 0
    }

    private static void binarySearchOnAnAlreadySortedArray() {
        // Array is already sorted without the need for Arrays.sort - seems to work fine!
        String[] alreadyOrderedArray = new String[]{ "Linux", "Mac", "Windows" };
        System.out.println("Binary search on sorted array: " + Arrays.binarySearch(alreadyOrderedArray, "Windows")); // 2
        System.out.println("Binary search on sorted array missing element: " + Arrays.binarySearch(alreadyOrderedArray, "Something Else")); // -3

        // You get the same values even if you sort (since it is already sorted)
        Arrays.sort(alreadyOrderedArray);
        System.out.println("Binary search on sorted again array: " + Arrays.binarySearch(alreadyOrderedArray, "Windows")); // 2
        System.out.println("Binary search on sorted again array missing element: " + Arrays.binarySearch(alreadyOrderedArray, "Something Else")); // -3
    }
}
