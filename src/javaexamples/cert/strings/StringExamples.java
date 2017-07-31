package javaexamples.cert.strings;

public class StringExamples {

    public static void main(String[] args){
        stringHasStartsWithMethod();
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
}
