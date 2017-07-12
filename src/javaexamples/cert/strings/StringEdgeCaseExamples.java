package javaexamples.cert.strings;

public class StringEdgeCaseExamples {
    public static void main(String[] args){

        stringPoolNewStringExample();
        stringInternExample();
        comparingStringToNull();

    }

    private static void stringInternExample() {
        String bob = new String("bob");
        String anotherBob = "bob";
        // Remember string created with new String do not use String pooling, therefore they won't point to the same "bob"
        System.out.println((bob == anotherBob) + " " + (bob.equals(anotherBob))); // false and true

        // However the following will use the String pool
        String wowAnotherBob = "bob";
        System.out.println((wowAnotherBob == anotherBob) + " " + (wowAnotherBob.equals(anotherBob))); // true and true

        // Now let's use intern to force bob to use the String pool reference
        System.out.println((bob.intern() == anotherBob) + " " + (bob.equals(anotherBob))); // true and true

    }

    private static void stringPoolNewStringExample() {
        // Strings created with new String are not added to the String Pool
        String bob = new String("bob");
        String notBob = bob;
        // The references are the same, and also both equal "bob", so true and true will be printed
        System.out.println((bob == notBob) + " " + (bob.equals(notBob)));
    }

    private static void comparingStringToNull() {

        // The following compiles fine
        String myTestVariable = "";
        boolean comparingToNull = myTestVariable.equals(null);
        System.out.println(comparingToNull); // false

        // And so does the following, but it would throw a NullPointerException at Runtime
        myTestVariable = null;
        comparingToNull = myTestVariable.equals(null);
        System.out.println(comparingToNull); // NullPointerException
    }
}
