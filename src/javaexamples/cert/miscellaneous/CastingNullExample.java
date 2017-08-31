package javaexamples.cert.miscellaneous;

// This example shows that it is possible to cast null, although it would throw a RuntimeException
public class CastingNullExample {
    public static void main(String[] args){
        castingNull();
    }

    private static void castingNull() {
        Number num = (Integer)null;
        System.out.println(num.byteValue()); // Exception in thread "main" java.lang.NullPointerException
    }
}
