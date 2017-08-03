package javaexamples.cert.numerics;

public class HexExamples {

    public static void main(String[] args){
        BasicHexExamples();
        hexConversionToDecimal();
    }

    private static void BasicHexExamples() {
        int hexValue1 = 0x100;
        int hexValue2 = 0x1234;
        int hexValue3 = 0xDEAF;
        int hexValue4 = 0xCAB;
        int hexValue5 = 0XCAB; // Note Capital X makes no difference

        System.out.println(hexValue1); // 256
        System.out.println(hexValue2); // 4660
        System.out.println(hexValue3); // 57007
        System.out.println(hexValue4); // 3243
        System.out.println(hexValue5); // 3243
    }

    private static void hexConversionToDecimal() {

        // 0x     4            0            0
        //    (4 * 16^2) + (0 * 16^1) + (0 * 16^0) = (4 * 256) + (0 * 16)) + (1 * 1) = 5
        int x = 0x400;
        System.out.println(x); // 1024

        // 0x     9            2            4
        //    (9 * 16^2) + (2 * 16^1) + (4 * 16^0) = (9 * 256) + (2 * 16)) + (4 * 1) = 2340
        int y = 0X924;
        System.out.println(y); // 2340
    }
}
