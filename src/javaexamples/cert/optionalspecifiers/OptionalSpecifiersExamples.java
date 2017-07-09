package javaexamples.cert.optionalspecifiers;

public class OptionalSpecifiersExamples {

    public static void main(String[] args) {
        optionalSpecifierTests();
    }

    static public final void optionalSpecifierTests(){ // Notice this order!! final public static is also valid
        // Optional specifiers are static, abstract, final, synchronized, native, strictfp
        // You can have multiple specifiers in the same method, or none at all
        // Java allows the optional specifiers to appear before the access modifier, but not after the return type
        // final static int var1; // Cannot have static in this context
    }
}
