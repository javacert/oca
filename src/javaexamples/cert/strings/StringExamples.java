package javaexamples.cert.strings;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// String, StringBuilder, and StringBuffer - all are final classes.
// + is overloaded such that if any one of its two operands is a String then it will convert the other
// operand to a String and create a new string by concatenating the two.
// toUpperCase returns a new String object
public class StringExamples {

    public static void main(String[] args){
        stringConstructors();
        stringHasStartsWithMethod();
        stringHasCompareToMethod();
        stringReplaceMethodSupport();
        stringWithCharExample();
        stringJoinExample();
        stringCharAtExample();
        stringTrimMethod();
        stringSubStringMethod();
        stringComparisons();
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
        String someString8 = new String();

        //public String() {
        //    this.value = new char[0];
        //}
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
        // compareTo() stops at the first place where the strings have different letters
        // Lexicographical order is similar to alphabetical order, so A comes before B comes before C.
        // Capital letters are ordered before lowercase ones
        // Special character like "é" could be ordered after all the normal letters and numbers.
        // Digits precede letters, and uppercase letters precede lowercase ones.
        System.out.println(returnValue1);   // 4 (difference of 4 characters)
        System.out.println(returnValue2);   // 0 (difference of zero characters)
        System.out.println(returnValue3);   // -4 (difference of - 4 characters)
        System.out.println(returnValue4);   // -3 (difference of - 4 characters)

        // The result is a positive integer if the object lexicographically follows the argument string.
        // Digits precede letters, and uppercase letters precede lowercase ones, therefore h lexographically follows H
        System.out.println('h' + 0); // 104
        System.out.println('H' + 0); // 72
        System.out.println("hello world".compareTo("Hello world")); // 32
        System.out.println("Hello world".compareTo("hello world")); // -32
        System.out.println('d' + 0); // 100
        System.out.println('D' + 0); // 68
        System.out.println("d".compareTo("D")); // 32
        System.out.println("D".compareTo("d")); // -32
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

        // Some important rules with replace:
        // 1) replace(char oldChar, char newChar) method returns the same String object if both the parameters are same,
        //    i.e. if there is no change. Thus, "String" == "String".replace('g', 'g') will return true.
        // 2) replace(CharSequence oldSeq,  CharSequence newSeq) method returns a new String object even if there is
        //    no change after replacement. Thus, "String" == "String".replace("g", "g") will return false.
        System.out.println("String".replace('g','g') == "String"); // true
        System.out.println("String".replace('g','G') == "String"); // false
        System.out.println("String".replace("r", "r") == "String"); // false
        System.out.println("String".replace("r", "R") == "String"); // false
        System.out.println("String".replace(new StringBuilder("r"), new StringBuilder("r")) == "String"); // false
        System.out.println("String".replace(new StringBuilder("r"), new StringBuilder("R")) == "String"); // false
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
        // charAt throws IndexOutOfBoundsException per the documentation (although in practice it throws StringIndexOutOfBoundsException).
    }

    private static void stringTrimMethod() {
        // trim removes whitespace from front and end of the String (leading and trailing)
        System.out.println("    hello java guru   ".trim()); // "hello java guru"
    }

    private static void stringSubStringMethod() {
        System.out.println("ABCDEF".substring(3, 4)); // start and end index (remember last index not included) 4-3 = 1 char = D
    }

    private static void stringComparisons() {
        String lol = "lol";
        System.out.println(lol == "lol");               // true

        // toUpperCase first checks if any characters need changed and if not, it returns the same String -
        // in this case there are difference and a new String(..) is returned
        System.out.println(lol.toUpperCase() == lol);   // false - toUpperCase first checks if any characters need changed and if not, it returns the same String - in this case there are difference and a new String(..) is returned
        System.out.println(lol.toLowerCase() == lol);   // true - toLowerCase first checks if any characters need changed and if not, it returns the same String
        System.out.println(lol.substring(0) == lol);    // true - again since no change return the existing, otherwise return new String
        System.out.println("xlol".substring(1) == lol); // false - a new String(..) is returned since there is a difference.
    }
}
