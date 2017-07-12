package javaexamples.cert.binarysearch;

import java.util.Arrays;

public class BinarySearchExamples {

    public static void main(String[] args){

        binarySearchWithoutSort();
        binarySearchWithASort();
        binarySearchWithSortButValueDoesNotExist();
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
}
