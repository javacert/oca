package javaexamples.cert.primitives;

// This example shows that for normal calculations byte, char and short are promoted to ints.
// However, be aware that compound assignments do an explicit cast, which means although the types are promoted to int
// for the calculations, it is cast back to the data type and therefore will not throw a compilation error.
public class PrimitivePromotionExamples {

    public static void main(String[] args){
        numericPromotionExamples();
        promotionInAComparisonStatement();
        intToFloatExample();
        doublePromotionExample();
        implicitNarrowingWhenNotCompileTimeConstants((byte)10,(char)10,(short)10,10);
        doublePromotionWhenNotCompileTimeConstants((byte)10,(char)10,(short)10,10,10,10);
        wideningIsFineWhenReturningFromAMethodA();
        wideningIsFineWhenReturningFromAMethodB();
        narrowingIsFineWhenReturningFromAMethodA();
        narrowingIsFineWhenReturningFromAMethodB();
    }

    private static void numericPromotionExamples() {
        byte b = 1;
        char c = 1;
        short s = 1;
        int i = 1;

        // b = s * s; // --> Will not compile because s * s returns an int.
        b *= s; // This is fine since there is an explicit cast, so equal to b = byte(s * s)

        i = b + b; // Fine since i is an int.
        s *= b ; // All compound assignment operators internally do an explicit cast.

        // c = c + b ; // --> Will not compile because c + b returns an int.
    }

    private static void promotionInAComparisonStatement() {
        int i = 5;
        float f = 5.5f;
        double d = 5.5;
        byte b = 0;
        if (b == f) b++; // In the case of b == f, value of b will be promoted to a float i.e. 0.0, and so it returns false.
        if (i == f) b++; // In the case of i == f, value of i will be promoted to a float i.e. 5.0, and so it returns false.
        if (f == d) b++; // In the case of i == d, value of f will be promoted to a double i.e. 5.5, and so it returns true.
        if (i == d) b++; // In the case of i == d, value of i will be promoted to a double i.e. 5.0, and so it returns false.

        System.out.println(b); // 1
    }

    private static void intToFloatExample() {
        // Float f1 = 10; // Does not compile - assignment doesn't do an explicit cast automatically
        Float f1 = (float)10;

        // Double d1 = 10; // Does not compile
        Double d1 = (double)10;

        // Long l1 = 10; // Does not compile
        Long l1 = (long)10;

        Byte b1 = 10; // This works fine for char, byte and short
        Short s1 = 10;
        Character c1 = 10;

        int i1 = 'a'; // Whaaaa, you can assign a char to an int!
        char c2 = 10;
        long l2 = 10;
        byte b2 = 10;
        float f2 = 10; // Fine, as long as the values fits - we are not working with autoboxing here - implicit cast is done by the compiler.
        double d2 = 10;
    }

    private static void doublePromotionExample() {
        double a = (byte)10;
        double b = (char)10;
        double c = (short)10;
        double d = (int)10;
        double e = (long)10;
        double f = (float)10;
    }

    private static void implicitNarrowingWhenNotCompileTimeConstants(byte b, char c, short s, int i) {
        //byte b1 = b; // b is not a compile time constant
        //byte b2 = c; // c is not a compile time constant
        //byte b3 = s; // s is not a compile time constant
        //byte b4 = i; // i is not a compile time constant

        byte b1 = (byte)10;
        byte b2 = (byte)'a';
        byte b3 = (short)10;
        byte b4 = (int)10;
    }

    private static void doublePromotionWhenNotCompileTimeConstants(byte b, char c, short s, int i, long l, float f) {
        double d1 = b;
        double d2 = c;
        double d3 = s;
        double d4 = i;
        double d5 = l;
        double d6 = f;
    }

    private static double wideningIsFineWhenReturningFromAMethodA() {
        return (short)10;
    }

    private static double wideningIsFineWhenReturningFromAMethodB() {
        return (long)10;
    }

    private static short narrowingIsFineWhenReturningFromAMethodA() {
        return 10;
    }

    private static byte narrowingIsFineWhenReturningFromAMethodB() {
        return 'a';
    }
}
