package javaexamples.cert.strings;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// String, StringBuilder, and StringBuffer - all are final classes.
// + is overloaded such that if any one of its two operands is a String then it will convert the other
// operand to a String and create a new string by concatenating the two.
public class StringExamples {

    public static void main(String[] args){
        stringConstructors();
        stringHasStartsWithMethod();
        stringHasCompareToMethod();
        stringReplaceMethodSupport();
        stringWithCharExample();
        stringJoinExample();
        stringCharAtExample();
    }

    private static void stringConstructors() {
        // These are a few examples, but not all String constructors
        String someString1 = "abc";
        String someString2 = new String("abc");
        String someString3 = new String(new StringBuilder("abc"));
        String someString4 = new String(new StringBuffer("abc"));
        String someString5 = new String(new char[]{'a', 'b', 'c'});
        String someString6 = new String(new byte[]{1, 2, 3}, StandardCharsets.ISO_8859_1);
        String someString7 = new String(new char[]{'a', 'b', 'c'}, 1, 1);
    }

    private static void stringHasStartsWithMethod() {
        // String is the only one (String vs StringBuffer vs StringBuilder) to have a startsWith method
        // StringBuilder sb = new StringBuilder("abc").startsWith("a"); // --> Does not compile
        // StringBuilder sb = new StringBuilder("abc").endsWith("a"); // --> Does not compile

        boolean startsWith = "abc".startsWith("a");
        System.out.println(startsWith); // true

        boolean endsWith = "abc".endsWith("d");
        System.out.println(endsWith); // false
    }

    private static void stringHasCompareToMethod() {
        String someString = "abcdef";
        String someOtherString = "abcdef";

        int returnValue1 = someString.compareTo("ab");
        int returnValue2 = someString.compareTo(someOtherString);
        int returnValue3 = "ab".compareTo(someString);
        int returnValue4 = "abc".compareTo(someString);

        // The result is zero if the strings are equal
        // The result is a positive integer if this {@code String} object lexicographically follows the argument string.
        // The result is a negative integer if this {@code String} object lexicographically precedes the argument string.
        System.out.println(returnValue1);   // 4 (difference of 4 characters)
        System.out.println(returnValue2);   // 0 (difference of zero characters)
        System.out.println(returnValue3);   // -4 (difference of - 4 characters)
        System.out.println(returnValue4);   // -3 (difference of - 4 characters)
    }

    private static void stringReplaceMethodSupport() {
        String s = "abc";

        s.replace("a", "z");
        System.out.println(s); // abc - Remember String is immutable!

        s.replace(new StringBuilder("b"), new StringBuilder("y"));
        System.out.println(s); // abc

        s.replace('c', 'x');
        System.out.println(s); // abc

        String a = s.replace("a", "z");
        System.out.println(a); // zbc

        String b = s.replace(new StringBuilder("b"), new StringBuilder("y"));
        System.out.println(b); // ayc

        String c = s.replace('c', 'x');
        System.out.println(c); // abx
    }

    private static void stringWithCharExample() {
        // String witch = 'b'; --> You cannot assign a char to a String
        // String witch = new String('b'); --> Nor can you do this!

        String witch = Character.toString('b');
        String tail = "lack";
        witch = witch.concat(tail);
        System.out.println(witch); // black
    }

    private static void stringJoinExample() {
        // join is a new method that was released with Java 8
        // public static String join(CharSequence delimiter, CharSequence... elements)
        String message = String.join("-", "Any", "Number", "Of", "Elements");
        System.out.println(message); // Any-Number-Of-Elements
    }

    private static void stringCharAtExample() {
        int charIndex = "ABCDE".charAt('a'); // char promoted to int! java.lang.StringIndexOutOfBoundsException: String index out of range: 97
    }
}
