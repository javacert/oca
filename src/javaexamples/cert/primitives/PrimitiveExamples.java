package javaexamples.cert.primitives;

public class PrimitiveExamples {

    // Capacities:
    // byte = 128.0 - 127.0,
    // long = 9.223372036854776E18 - 9.223372036854776E18,
    // int = 2.147483648E9 - 2.147483647E9,
    // char = 65535.0,
    // short = 32768.0 - 32767.0

    public static void main(String[] args){
        byteExamples();
        charExamples();
        floatExamples();
        doubleExamples();
        longExamples();
    }

    private static void floatExamples() {
        float a = 1.1F;
        float b = 1.1f; // You can have lower or upper case, both are the same
        System.out.println(a); // 1.1
        System.out.println(b); // 1.1
    }

    private static void charExamples() {
        //char a = 'BF'; // char can only have one letter
        char a = 'B';
        char b = 65535;
        //char c = 65536; // Incompatible types, found int, requires char
    }

    private static void doubleExamples() {
        double a = 1.1d;
        double b = 1.1D; // You can have lower or upper case, both are the same
        System.out.println(a); // 1.1
        System.out.println(b); // 1.1
    }

    private static void byteExamples() {
        // -128 to 127
        // byte a = -129; // Incompatible types, found int, requires byte
        byte a = -128;
        byte b = 10;
        byte c = 99;
        byte d = 127;
        // byte e = 128;
        // byte f = 200; // Incompatible types, found int, requires byte
    }

    private static void longExamples() {
        long l1 = 3; // get wider implicitly
    }
}
