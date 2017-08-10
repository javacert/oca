package javaexamples.cert.wrappers;

public class WrapperEdgeCaseExamples {

    public static void main(String[] args){
        usingWrapperConstructors();
        wrapperPromotionExample();
        doubleDivisionByZeroExample();
        wrapperEqualsExample();
        wrapperCompareToPrimitiveExample();
    }

    private static void usingWrapperConstructors() {

        // IMPORTANT - literals in int range are considered as int implicitly (do not need a cast). This means that we can assign
        // an int to a short and it will compile since within int range (int = 2.147483648E9 - 2.147483647E9),
        // but see on down, we can't do this for anything bigger than an int without an explicit cast
        Short myShortB = 3;

        // Double myDoubleA = 10; // Found int, required Double
        // Double myDoubleB = 10L; // Found long, required Double
        Double myDoubleA = 10.0;

        // Short myShort = new Short(4); // --> Won't compile since the constructor expects a short
        Short myShortA = new Short((short)4); // public Short(short value) {

        Long myLongA = new Long(4); // public Long(long value) {
        // Long myLongB = new Long(2.0); // --> Won't compile since the constructor expects a long and not a double
        Long myLongB = new Long((long)2.0);
        Long myLongC = new Long(2L);
        Long myLongD = new Long((long)2);

        Integer myIntegerA = 3; // This will call Integer.valueOf()

        // As described above for short, we can't do the following assignments
        // Long myLongC = 3; // Incompatible Types - Required: java.lang.Long, Found: int
        Long myLongE = (long)3; // This works fine and will call Long.valueOf()
        Long myLongF = 3L; // Also compiles fine and will call Long.valueOf()

        // Double myDoubleA = 10; // Incompatible Types - Required: java.lang.Double, Found: int
        Double myDoubleB = (double)10; // This works fine with the explicit cast

        // Watch out for float since you can assign an int to those
        float floatAsInt = 0;
        Object myDoubleObject = new Double(3); // Constructor accepts an int value
        Number num = (Number) myDoubleObject; // Number is an abstract class - note that this still prints the number.
        System.out.println(num); // 3.0
    }

    // You MUST remember these rules:
    // Assignment contexts allow the use of one of the following:
    //    1) an identity conversion
    //    2) a widening primitive conversion
    //    3) a widening reference conversion
    //    4) a boxing conversion optionally followed by a widening reference conversion
    //    5) an unboxing conversion optionally followed by a widening primitive conversion.
    // NOTE that this list does not include a widening primitive conversion followed by a boxing conversion. The reverse is okay.

    // A narrowing primitive conversion may be used if the type of the variable is byte, short, or char,
    // and the value of the constant expression is representable in the type of the variable.
    // A narrowing primitive conversion followed by a boxing conversion may be used if the type of the variable is:
    //    1) Byte and the value of the constant expression is representable in the type byte.
    //    2) Short and the value of the constant expression is representable in the type short.
    //    3) Character and the value of the constant expression is representable in the type char.
    private static void wrapperPromotionExample() {
        final int startScore = 4;
        final Integer startScoreWrapper = 4;
        final long someLong = startScore; // Compiles Fine - a widening primitive conversion
        // final Long someLongWrapper = startScore; // Does not compile - a widening primitive conversion followed by a boxing conversion


        // System.out.println(getScore(startScore)); // Does not compile - a widening primitive conversion followed by a boxing conversion - int to long, then long to Long
        // System.out.println(getScore(4)); // Does not compile - a widening primitive conversion followed by a boxing conversion - int to long, then long to Long
        // System.out.println(getScore(startScoreWrapper)); // Does not compile - Integer unboxed to int, widened to long (cannot convert back to Long since only 2 steps)
        System.out.println(getScore(someLong)); // Fine, a primitive long is boxed to Long

        System.out.println(getScorePrimitiveLong(startScoreWrapper)); // Fine, Integer is unboxed to int, and then widened to long - from rules, a boxing conversion optionally followed by a widening reference conversion
    }

    private static Long getScore(Long someLong){
        return 2 * someLong;
    }

    private static Long getScorePrimitiveLong(long someLong){
        return 2 * someLong;
    }

    // NOTE: Float/Double point primitives do not throw Arithmetic Exception when divided by zero
    private static void doubleDivisionByZeroExample() {
        double thisIsAValidCalculationA = 0.0/0.0;
        Double thisIsAValidCalculationB = 0.0/0.0;
        Double thisIsAValidCalculationC = new Double(0.0/0.0);

        System.out.println(thisIsAValidCalculationA); // NaN
        System.out.println(thisIsAValidCalculationB); // NaN
        System.out.println(thisIsAValidCalculationC); // NaN

        boolean isNaNAlt = thisIsAValidCalculationB.isNaN();
        System.out.println(isNaNAlt); // true

        boolean isNaN = Double.isNaN(thisIsAValidCalculationC);
        System.out.println(isNaN); // true

        boolean isInfinite = Double.isInfinite(thisIsAValidCalculationC);
        System.out.println(isInfinite); // true
    }


    private static void wrapperEqualsExample() {
        Integer i = 10;
        Double d = 10.0;

        // See the equals method below, it checks the wrapper type before the comparison.
        System.out.println(i.equals(d)); // false
        System.out.println(d.equals(i)); // false

        //public boolean equals(Object obj) {
        //    if (obj instanceof Integer) {
        //        return value == ((Integer)obj).intValue();
        //    }
        //    return false;
        //}

        //public boolean equals(Object obj) {
        //    return (obj instanceof Double)
        //            && (doubleToLongBits(((Double)obj).value) ==
        //            doubleToLongBits(value));
        //}
    }

    // Thing to remember here is that primitives with the same value are equivalent
    // The different is the capacity and whether they can hold point values but the contents you are comparing are
    // the same. The same with the unwrapped wrapper object. The equals method is different as shown previously,
    // it compares only equivalent wrapper objects, and returns false if they are not equivalent
    private static void wrapperCompareToPrimitiveExample() {
        Double d = 10.0;
        int i = 10;
        long l = 10L;
        float f = 10f;
        char c = 10;
        double dp = 10;
        double dp2 = 10.1;

        // The following will unwrap the wrapper to a primitive and compare
        System.out.println(d == i); // true
        // The above is actually the same as the following, this is what the compiler does
        System.out.println(d.intValue() == i); // true
        System.out.println(d == l); // true
        System.out.println(d == f); // true

        System.out.println(i == f); // true
        System.out.println(c == f); // true

        System.out.println(d == dp); // true
        System.out.println(dp == dp2); // false

        // System.out.println(d.equals(i)); // Won't compile
    }
}
