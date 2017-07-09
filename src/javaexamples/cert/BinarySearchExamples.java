package javaexamples.cert;

import java.util.Arrays;

public class BinarySearchExamples {

    public static void main(String[] args){

        String[] search = { "A0", "8", "12", "Z" };
        int whatIsIt = Arrays.binarySearch(search, "44");
        System.out.println(whatIsIt); // Remember need to sort first

        Arrays.sort(search);
        System.out.println(search); // [Ljava.lang.String;@28d93b30
        System.out.println(search[0] + " " + search[1] + " " + search[2] + " " + search[3]); // 12 8 A0 Z

        int result = Arrays.binarySearch(search, "44");
        System.out.println(result); // -2 (remember, index where it should be (in this case 1), times -1, -1 = -2)
    }
}
