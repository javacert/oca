package javaexamples.cert.truthtables;

public class TruthTableExamples {

    public static void main(String[] args){
        andTableDemo();
        shortCircuitAndTableDemo();
        inclusiveOrTableDemo();
        shortCircuitOrTableDemo();
        exclusiveOrTableDemo();
    }

    private static void andTableDemo() {
        // Both sides of the expression are evaluated and both must evaluate to true
        System.out.println("(AND)");
        System.out.println(true & true);    // true
        System.out.println(true & false);   // false
        System.out.println(false & true);   // false
        System.out.println(false & false);  // false
    }

    private static void shortCircuitAndTableDemo() {
        // Both sides must evaluate to true
        // The short circuit is when the left hand side evaluates to false -
        // there is no need to evaluate the right hand side since it is already false
        System.out.println("(SHORT-CIRCUIT AND)");
        System.out.println(true && true);    // true
        System.out.println(true && false);   // false - short circuit - right side not evaluated
        System.out.println(false && true);   // false
        System.out.println(false && false);  // false
    }

    private static void inclusiveOrTableDemo() {
        // Both sides are evaluated and will evaluate to true if either side is true
        System.out.println("(INCLUSIVE OR)");
        System.out.println(true | true);    // true
        System.out.println(true | false);   // true
        System.out.println(false | true);   // true
        System.out.println(false | false);  // false
    }

    private static void shortCircuitOrTableDemo() {
        // At least on side of the expression must evaluate to true
        // If the left side evaluates to true, the expression will short-circuit and return true
        int i = 0;
        System.out.println("(SHORT_CIRCUIT OR)");
        System.out.println(true || true);    // true
        System.out.println(true || false);   // true - short circuit, right side not evaluated
        System.out.println((1 > 0) || (++i > 0));   // true - short circuit, right side not evaluated
        System.out.println(i);               // i will still be zero
        System.out.println(false || true);   // true
        System.out.println(false || false);  // false
    }

    private static void exclusiveOrTableDemo() {
        // Evaluates to true if both sides differ and false if they are the same!
        System.out.println("(EXCLUSIVE OR (XOR))");
        System.out.println(true ^ true);    // false
        System.out.println(true ^ false);   // true
        System.out.println(false ^ true);   // true
        System.out.println(false ^ false);  // false
    }
}
