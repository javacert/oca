package javaexamples.cert.operators;

import java.math.BigDecimal;

public class DivisionRoundedToZeroExamples {

    public static void main(String[] args){
        integerDivisionExample();
        floatDivisionExample();
        doubleDivisionExample();
        bigDecimalDivisionExample();
    }

    private static void integerDivisionExample() {
        int whatIsThis = 2 / 5;
        System.out.println(whatIsThis); // 0
    }

    private static void floatDivisionExample() {
        float whatIsThisFloat = 2 / 5;
        // The following will return 0.0 because the conversion to float happens after the division has been done
        System.out.println(whatIsThisFloat); // 0.0
        whatIsThisFloat = 2.0f / 5.0f;
        System.out.println(whatIsThisFloat); // 0.4
        System.out.println(String.format("%2.02f", whatIsThisFloat)); // 0.40
    }

    private static void doubleDivisionExample() {
        double whatIsThisDouble = 2 / 5;
        System.out.println(whatIsThisDouble); // 0.0
        whatIsThisDouble = 2.0 / 5.0;
        System.out.println(whatIsThisDouble); // 0.4
    }

    private static void bigDecimalDivisionExample() {
        BigDecimal whatIsThisBigDecimal = new BigDecimal(2 / 5);
        System.out.println(whatIsThisBigDecimal.toString()); // 0
        whatIsThisBigDecimal = new BigDecimal(2.0 / 5); // Expression will return a double
        System.out.println(whatIsThisBigDecimal.toString()); // 0.40000000000000002220446049250313080847263336181640625
    }
}
