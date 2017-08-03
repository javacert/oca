package javaexamples.cert.numerics;

public class BinaryExamples {

    public static void main(String[] args){
        BasicBinaryExamples();
        binaryConversionToDecimal();
    }

    private static void BasicBinaryExamples() {
        int anInt1 = 0b10100001010001011010000101000101;
        int anInt2 = 0b101;
        int anInt3 = 0B101; // The B can be upper or lower case.

        System.out.println(anInt1); //
        System.out.println(anInt2); //
        System.out.println(anInt3); //
    }

    private static void binaryConversionToDecimal() {

        // Remember that anything to the power of zero is 1, so 2^0 = 1
        // Remember that anything to the power of 1 is the number itself, so 2^1 = 2
        int x = 0b101;
        // 0b     1           0           1
        //    (1 * 2^2) + (0 * 2^1) + (1 * 2^0) = (1 * 4) + (0 * 2)) + (1 * 1) = 5
        System.out.println(x); // 5

        int y = 0b110;
        // 0b     1           1           0
        //    (1 * 2^2) + (1 * 2^1) + (0 * 2^0) = (1 * 4) + (1 * 2)) + (1 * 0) = 6
        System.out.println(y); // 6

        int z = 0b11101;
        // 0b     1           1           1           0           1
        //    (1 * 2^4) + (1 * 2^3) + (1 * 2^2) + (0 * 2^1) + (1 * 2^0) = (1 * 16) + (1 * 8) + (1 * 4) + (0 * 2)) + (1 * 1) = 29
        System.out.println(z); // 29
    }
}
