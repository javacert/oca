package javaexamples.cert.primitives;

// This example shows that for normal calculations byte, char and short are promoted to ints.
// However, be aware that compound assignments do an explicit cast, which means although the types are promoted to int
// for the calculations, it is cast back to the data type and therefore will not throw a compilation error.
public class PrimitivePromotionExamples {

    public static void main(String[] args){
        numericPromotionExamples();
        promotionInAComparisonStatement();
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
}
