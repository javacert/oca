package javaexamples.cert.strings;

// These imports are not required since java.lang is imported automatically,
// but they show that all 3 of these classes live in java.lang package
import java.lang.String;
import java.lang.StringBuffer;
import java.lang.StringBuilder;

public class StringBufferBuilderComparisonExamples {

    public static void main(String[] args) {

        // StringBuilder replaces the thread safe StringBuffer, introduced in Java 5
        // StringBuilder returns the current reference to facilitate method chaining
        StringBuilder sb = new StringBuilder("abcdef");
        sb.append("ghi");
        System.out.println(sb); // Prints "abcdefghi"

        StringBuffer sBuff = new StringBuffer("abcdef");
        sBuff.append("ghi");
        System.out.println(sBuff); // Prints "abcdefghi"

        String myString = "abcdef";
        myString.concat("ghi"); // concat returns a new String
        System.out.println(myString); // Prints "abcdef"

        String myNewString = myString.concat("ghi");
        System.out.println(myNewString); // Prints "abcdefghi"

        StringBuffer sBuff2 = new StringBuffer("abcdef");
        sBuff2.append("ghi").append("jkl");
        System.out.println(sBuff2); // Prints "abcdefghijkl"

        sb.delete(0, sb.length());
        sb.append('c').append(1).append(true);
        System.out.println(sb); // Prints c1true

        // Both end and index parameters read as character right before this index
        sb.delete(2, 5);
        System.out.println(sb); // Prints c1e
        sb.delete(2, 5);
        System.out.println(sb); // Prints c1

        sBuff2.delete(0, sBuff2.length());
        sBuff2.append('c').append(1).append(true);
        System.out.println(sBuff2); // Prints c1true

        // Both end and index parameters read as character right before this index
        sBuff2.delete(2, 5);
        System.out.println(sBuff2); // Prints c1e
        sBuff2.delete(2, 5);
        System.out.println(sBuff2); // Prints c1

        //sBuff2.delete(8, 5); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException
        //System.out.println(sBuff2); // Doesn't Print

        //StringBuilder sb2 = new StringBuilder("abcdef");
        // Watch the following, when the end index is before the start, it throws an exception
        //sb2.delete(3, 2); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException
        //System.out.println(sb2); // Doesn't Print

        //StringBuilder sb2 = new StringBuilder("abcdef");
        //sb2.insert(10, 'c'); // java.lang.ArrayIndexOutOfBoundsException
        //System.out.println(sb2); // Doesn't Print

        StringBuilder sb2 = new StringBuilder("abcdef");
        sb2.insert(2, 'z'); // java.lang.ArrayIndexOutOfBoundsException
        System.out.println(sb2); // Prints abzcdef

        StringBuilder sb3 = new StringBuilder("abcdef");
        String subString = sb3.substring(2, 5); // start and end index is before
        System.out.println(subString); // Prints cde
        subString = sb3.substring(2, 6); // start and end index is before
        System.out.println(subString); // Prints cdef
        //subString = sb3.substring(2, 10); // java.lang.StringIndexOutOfBoundsException
        //System.out.println(subString); // Doesn't Print due to exception

        sb3.delete(2, 5000);
        System.out.println(sb3); // Prints ab

        sb = new StringBuilder("rumble");
        sb.append(4).deleteCharAt(3);
        System.out.println(sb.toString() + " " + (sb.length() - 1)); // rumle4 5
        sb.delete(3, sb.length() - 1); // rum4 - remember start/end index is before in each case
        System.out.println(sb);
    }
}
