package javaexamples.cert.operators;

public class BasicOperatorExamples {

    public static void main(String[] args){
        greaterThanLessThan();
    }

    private static void greaterThanLessThan() {
        int a = 5, b = 6;
        // boolean canDoThis = a => b;  // --> Must be >=
        // boolean canDoThis = a =< b;     // --> Must be <=

        boolean canDoThis = a >= b;
        canDoThis = a <= b;
    }
}
