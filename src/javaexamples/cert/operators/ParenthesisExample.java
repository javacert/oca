package javaexamples.cert.operators;

public class ParenthesisExample {

    public static void main(String[] args){
        parenthesisExample1();
        parenthesisExample2();
        parenthesisExample3();
    }

    private static void parenthesisExample1() {

        // Remember expressions are evaluated left to right.
        // Parentheses just express grouping, they don't express ordering of evaluation.
        // Operator precedence then comes into play
        int leaders = 10 * (2 + (1 + 2 / 5));
        int followers = leaders * 2;
        System.out.print(leaders + followers < 10 ? "Too few" : "Too many"); // Too many

        int c = 10;
        int whatIsThisGonnaBe = 10 * (2 + (++c - --c));
        System.out.println(whatIsThisGonnaBe); // 30

        int d = 10;
        int yikes = 10 * (2 + ++d - --d) + ++d;
        System.out.println(yikes + " " + d); // 41 11
    }

    private static void parenthesisExample2() {
        // Step 1: 10 * (2 + (5) / 5) --> Remember / takes precedence
        // Step 2: 10 * (2 + 1) = 30
        int turtle = 10 * (2 + (3 + 2) / 5); // 30
        int hare = turtle < 5 ? 10 : 25; // hare = 25
        System.out.println("turtle = " + turtle + " hare = " + hare);
        System.out.println(turtle < hare ? "Hare Wins!" : "Turtle Wins!"); // Turtle Wins!
    }

    private static void parenthesisExample3() {
        // int a = (5 + (!2 + 8) * 3 - 3 % 2) / 2; --> Doesn't compile because you can only apply ! to boolean values
        // Step 1: (5 + ((10) * 3) - (3 % 2)) / 2
        // Step 2: (5 + (30) - (1)) / 2
        // Step 3: 34 / 2 = 17
        int a = (5 + (2 + 8) * 3 - 3 % 2) / 2;
        System.out.println(a); // 17
    }
}
