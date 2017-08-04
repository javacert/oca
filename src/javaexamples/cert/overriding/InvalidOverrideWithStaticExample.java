package javaexamples.cert.overriding;

// This example shows that static methods are not overridden
public class InvalidOverrideWithStaticExample {

    public static void main(String[] args){
        A a = new B();
        a.method(); // Prints A

        B b = new B();
        b.method(); // Prints B
    }
}

class A {
    static void method(){
        System.out.println("A");
    }
}

class B extends A {
    protected static void method(){
        System.out.println("B");
    }

    // void method(){} // --> Cannot override static method
}
