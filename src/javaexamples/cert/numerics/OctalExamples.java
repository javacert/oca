package javaexamples.cert.numerics;

public class OctalExamples {

    public static void main(String[] args){
        basicOctalExamples();
        octalConversionsToDecimal();
    }

    private static void basicOctalExamples() {
        // Octal values are ints with a leading zero
        // Octal numbers can only use digits 0-7, just like decimal can use 0-9, and binary can use 0-1
        int octalA = 05356;
        System.out.println(octalA); // 2798

        double octalB = 0345.00; // Doubles do not have Octals, only ints
        System.out.println(octalB); // 345.0

        //int octalC = 0898; // Compiler Error - Integer number is too large
        //int octalC = 0678; // Compiler Error - Integer number is too large
    }

    private static void octalConversionsToDecimal() {
        // 053 Octal
        // (5 * 8^1) + (3 * 8^0) = (5 * 8) + (3 * 1) = 43

        int octalA = 053;
        System.out.println(octalA);

        // 345 Octal
        // (3 * 8^2) + (4 * 8^1) + (5 * 8^0) = (3 * 64) + (4 * 8) + (5 * 1) = 229

        int octalB = 0345;
        System.out.println(octalB); // 229
    }
}
