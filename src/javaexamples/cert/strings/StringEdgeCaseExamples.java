package javaexamples.cert.strings;

public class StringEdgeCaseExamples {
    public static void main(String[] args){

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
