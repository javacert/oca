package javaexamples.cert.precedence;

public class StringConcatenationPrecedenceExample {

    public static void main(String[] args){
        exampleA();
        exampleB();
        exampleC();
    }

    private static void exampleA() {
        int x = 1;
        int y = 1;
        System.out.println(x + "printing: " + ++x * y++ + ++x * ++y); // 1printing 29

        // Why?
        // Remember since we have concatenated to a string, then we treat those that come after as strings
        // 1 + "printing" + (2 * 1) + (3 * 3)
        // 1 + "printing" + (2) + (9)
        // 1printing 29
    }

    private static void exampleB() {
        int x = 1;
        int y = 1;
        System.out.println(++x + "printing: " + ++x * y++ + ++x * ++y); // 2printing 312

        // Why?
        // Remember since we have concatenated to a string, then we treat those that come after as strings
        // 2 + "printing" + (3 * 1) + (4 * 3)
        // 2 + "printing" + (3) + (12)
        // 2printing 312
    }

    private static void exampleC() {
        int x = 1;
        int y = 1;
        System.out.println(++x + "printing: " + ++x + y++ + ++x + ++y); // 2printing 3143
    }
}
