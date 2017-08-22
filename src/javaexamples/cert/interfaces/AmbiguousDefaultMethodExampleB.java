package javaexamples.cert.interfaces;

// This example shows that since MyInterface extends BaseInterface1 and BaseInterface2, there is no ambiguity
// of the getName default method. It effectively overrides the base implementation in these 2 interfaces.
// Actually BaseInterface1 and BaseInterface2 are redundant in this example since they only create 1 method.
// By not implementing MyInterface below would result in a compilation issues since getName becomes ambiguous.
public class AmbiguousDefaultMethodExampleB implements BaseInterface1, BaseInterface2, MyInterface {

    public static void main(String ar[]) {
        new AmbiguousDefaultMethodExampleB().getName();
    }
}

// Since the interface extends these it overrides the default method.
interface MyInterface extends BaseInterface1, BaseInterface2 {
    default void getName() {
        System.out.println("Just me");
    }
}

interface BaseInterface1 {
    default void getName() {
        System.out.println("Base 1");
    }

}
interface BaseInterface2 {
    default void getName() {
        System.out.println("Base 2");
    }

}
