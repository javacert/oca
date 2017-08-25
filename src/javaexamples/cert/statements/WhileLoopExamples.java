package javaexamples.cert.statements;

public class WhileLoopExamples {

    public static void main(String[] args){
        unreachableStatement();
        byteRangeEdgeCase();
        charRangeEdgeCase();
        shortRangeEdgeCase();
        integerRangeEdgeCase();
    }

    private static void unreachableStatement() {
        // Observe the following, you cannot have a while(false) but you can have if(false). If is an exception to the rule.
        // do {} while (false) will also compile since it is always executed at least once.
        int x = 0;
        //while(false) {
            // Unreachable Statement
        //}

        // Note that while (true) is permitted.
        while(true) {

        }
    }

    // In this example it looks as though we have an infinite loop, but in fact
    // when we get to the minimum value the primitive can hold, the condition is eventually satisfied.
    private static void byteRangeEdgeCase() {
        byte x = 0;
        while (x-- < 10) {
            continue;
        }
        System.out.println("Can you believe I am printed? " + x); // I am! x = 126 (max capacity 127)
    }

    private static void charRangeEdgeCase() {
        char x = 'a';
        while (x-- < 'b') {
            System.out.println(x);
            continue;
        }
        System.out.println("Can you believe I am printed?"); // I am!
    }

    private static void shortRangeEdgeCase() {
        short x = 0;
        while (x-- < 10) {
            continue;
        }
        System.out.println("Can you believe I am printed? " + x); // I am! x = 32766 (max capacity 32767)
    }

    private static void integerRangeEdgeCase() {
        int x = 0;
        while (x-- < 10) { // Will eventually hit -2147483648 and shift to the maximum value: 2147483647
            continue;
        }
        System.out.println("Can you believe I am printed? " + x); // I am! x = 2147483646 (max capacity 2147483647)
    }
}
