package javaexamples.cert.operators;

import java.math.BigDecimal;

public class ParenthesisExample {

    public static void main(String[] args){
        int whatIsThis = 2 / 5;
        System.out.println(whatIsThis); // 0

        float whatIsThisFloat = 2 / 5;
        // The following will return 0.0 because the conversion to float happens after the division has been done
        System.out.println(whatIsThisFloat); // 0.0
        whatIsThisFloat = 2.0f / 5.0f;
        System.out.println(whatIsThisFloat); // 0.4
        System.out.println(String.format("%2.02f", whatIsThisFloat)); // 0.40

        double whatIsThisDouble = 2 / 5;
        System.out.println(whatIsThisDouble); // 0.0
        whatIsThisDouble = 2.0 / 5.0;
        System.out.println(whatIsThisDouble); // 0.4

        BigDecimal whatIsThisBigDecimal = new BigDecimal(2 / 5);
        System.out.println(whatIsThisBigDecimal.toString()); // 0
        whatIsThisBigDecimal = new BigDecimal(2.0 / 5); // Expression will return a double
        System.out.println(whatIsThisBigDecimal.toString()); // 0.40000000000000002220446049250313080847263336181640625

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
}
