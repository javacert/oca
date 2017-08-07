package javaexamples.cert.wrappers;

public class CompareNullWrapperRefToPrimitive {

    public static void main(String[] args){
        compareNullReferenceToPrimitive();
    }

    private static void compareNullReferenceToPrimitive() {
        Integer intWrapper = null;
        int primitiveInt = 5;
        boolean canCompare = intWrapper == primitiveInt;
        System.out.println(canCompare); // Exception in thread "main" java.lang.NullPointerException

        intWrapper = new Integer(5);
        canCompare = intWrapper == primitiveInt;
        System.out.println(canCompare); // true (if we remove the above exception code of course!)
    }
}
