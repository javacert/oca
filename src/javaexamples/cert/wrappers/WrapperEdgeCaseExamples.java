package javaexamples.cert.wrappers;

public class WrapperEdgeCaseExamples {

    public static void main(String[] args){
        usingWrapperConstructors();
        wrapperPromotionExample();
    }

    private static void usingWrapperConstructors() {
        // Short myShort = new Short(4); // --> Won't compile since the constructor expects a short
        Short myShort = new Short((short)4); // public Short(short value) {

        Long myLongA = new Long(4); // public Long(long value) {
        // Long myLongB = new Long(2.0); // --> Won't compile since the constructor expects a long and not a double
        Long myLongB = new Long((long)2.0);
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
}
