package javaexamples.cert.strings;

import java.util.Arrays;

public class StringBuilderExceptions {

    public static void main(String[] args){
        stringBuilderInsertTest();
        stringBuilderChatAtTest();
        stringBuilderSetChatAtTest();
        stringBuilderDeleteTest();
        stringBuilderDeleteCharAtTest();
        stringBuilderSubStringTest();
        stringBuilderGetCharsTest();
    }

    private static void stringBuilderInsertTest() {

        StringBuilder sb = new StringBuilder("ABCDEF");

        sb.insert(10, "ABC"); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 10
    }

    private static void stringBuilderChatAtTest() {

        StringBuilder sb = new StringBuilder("ABCDEF");

        char someChar = sb.charAt(10); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 10
    }

    private static void stringBuilderSetChatAtTest() {

        StringBuilder sb = new StringBuilder("ABCDEF");

        sb.setCharAt(10, 'A'); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 10
    }

    private static void stringBuilderDeleteTest() {

        StringBuilder sb = new StringBuilder("ABCDEF");

        sb.delete(0, 5000); // This is fine, deletes to the end!

        sb.delete(10, sb.length()); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException
    }

    private static void stringBuilderDeleteCharAtTest() {

        StringBuilder sb = new StringBuilder("ABCDEF");

        sb.deleteCharAt(10); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 10
    }

    private static void stringBuilderSubStringTest() {
        StringBuilder sb = new StringBuilder("ABCDEF");

        // It throws StringIndexOutOfBoundsException if start is invalid value.
        String someSubStringA = sb.substring(10); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -4
        
        // It throws StringIndexOutOfBoundsException if start or end or both invalid
        String someSubStringB = sb.substring(0, 5000); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 5000
    }

    private static void stringBuilderGetCharsTest() {
        StringBuilder sb = new StringBuilder("ABCDEF");

        char[] ch = new char[5] ;
        sb.getChars(0, 2, ch, 0);

        System.out.println(Arrays.toString(ch)); // [A, B,  ,  ,  ]

        sb = new StringBuilder("ABCDEF");

        ch = new char[5] ;
        sb.getChars(10, 20, ch, 0); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 20
    }
}
