package javaexamples.cert.strings;

public class StringExceptions {

    public static void main(String[] args){
        stringSubStringExample();
        stringCharAtExample();
    }

    private static void stringSubStringExample() {

        String someString = "ABCDEF";

        // If beginIndex is invalid(negative number or greater than string length), it throws IndexOutOfBoundsException.
        // But practically it throws StringIndexOutOfBoundsException.

        String newStringA = someString.substring(10); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -4

        // If beginIndex or endIndex or both invalid(if the beginIndex is negative, or endIndex is larger than the
        // length of this String object, or beginIndex is larger than endIndex), it throws IndexOutOfBoundsException.
        // But practically it throws StringIndexOutOfBoundsException.

        String newStringB = someString.substring(2, 30); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 30
    }

    private static void stringCharAtExample() {

        String someString = "ABCDEF";

        char newChar = someString.charAt(10); // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 10
    }
}
