package javaexamples.cert.strings;

// String, StringBuilder, and StringBuffer - all are final classes.
public class StringExamples {

    public static void main(String[] args){
        stringHasStartsWithMethod();
        stringReplaceMethodSupport();
        stringWithCharExample();
        stringJoinExample();
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
}
