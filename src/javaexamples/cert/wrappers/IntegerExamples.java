package javaexamples.cert.wrappers;

// When you create an Integer using the new keyword, it creates a new Integer every time. However, Integer caches
// values between -128 and 127.
public class IntegerExamples {

    public static void main(String[] args){
        integerCachingExample();
        workingWithNullIntegerWrapper();
    }

    private static void integerCachingExample() {
        Integer a = new Integer(127);
        Integer b = new Integer(127);

        System.out.println(a == b); // false - reference comparison

        Integer c = 127;
        Integer d = 127;

        System.out.println(c == d); // true - cached so comparing the same reference to the same object for auto-boxed int primitive

        Integer e = new Integer(200);
        Integer f = new Integer(200);

        System.out.println(e == f); // false - reference comparison

        Integer g = 200;
        Integer h = 200;

        System.out.println(g == h); // false - above 127, so these are not cached!

        // Caching implementation is Integer
        //public static Integer valueOf(int i) {
        //    if (i >= IntegerCache.low && i <= IntegerCache.high)
        //        return IntegerCache.cache[i + (-IntegerCache.low)];
        //    return new Integer(i);
        //}
    }

    private static void workingWithNullIntegerWrapper() {
        Integer imNull = null;
        imNull++; // java.lang.NullPointerException
        imNull--; // java.lang.NullPointerException

    }
}
