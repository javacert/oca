package javaexamples.cert.interfaces;

// This example shows that since BaseInterface2A extends BaseInterface1A, the getName method is NOT ambiguous in this
// case. The version in BaseInterface2A will always be used.
public class AmbiguousDefaultMethodExampleC implements BaseInterface1A, BaseInterface2A {

    public static void main(String ar[]) {
        new AmbiguousDefaultMethodExampleB().getName();
    }
}

interface BaseInterface1A {
    default void getName() {
        System.out.println("Base 1");
    }

}

interface BaseInterface2A extends BaseInterface1A {
    default void getName() {
        System.out.println("Base 2");
    }

}
