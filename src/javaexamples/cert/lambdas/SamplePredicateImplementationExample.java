package javaexamples.cert.lambdas;

public class SamplePredicateImplementationExample {

    public static void main(String[] args){
        Shoot.prepare(45, d -> d > 5 || d < -5); // Will output true
    }
}

// Lambda expressions can only be used with Functional Interfaces
class Shoot {
    // It is acceptable style to create a nested interface this way if you expect it to
    // be used only from the outer class, so that you do not create a new top-level name.
    public static interface Target { // static keyword not required, but you can have a nested interface!
        boolean needToAim(double angle);
    }

    // This is pretty much the same as the JDK defined Predicate interface without generics
    //interface Predicate<T> {
    //    boolean test(T t);
    //}

    static void prepare(double angle, Target t){
        boolean ready = t.needToAim(angle);
        System.out.println(ready);
    }
}
