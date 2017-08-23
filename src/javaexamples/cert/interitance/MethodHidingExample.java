package javaexamples.cert.interitance;

// In method hiding we can call a static method based on the reference.
// With overridden instance methods we can never hide, method is called dynamically at run time based on polymorphic
// argument, whereas static method calls are determined at compile time based on the reference.
public class MethodHidingExample {

    public static void main(String[] args){
        A a  = new B();
        System.out.println(a.i); // Will print 10 instead of 20
        a.staticMethod(); // In A staticMethod
        a.nonStaticMethod(); // In B nonStaticMethod

        B b  = new B();
        System.out.println(b.i); // will print 20
        b.staticMethod(); // In B staticMethod
    }
}

class A {
    int i = 10;
    public static void staticMethod(){
        System.out.println("In A staticMethod");
    }

    public void nonStaticMethod() {
        System.out.println("In A nonStaticMethod");
    }
}

class B extends A {
    int i = 20;
    public static void staticMethod() {
        System.out.println("In B staticMethod");
    }

    public void nonStaticMethod() {
        System.out.println("In B nonStaticMethod");
    }
}