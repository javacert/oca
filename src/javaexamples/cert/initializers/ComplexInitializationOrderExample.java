package javaexamples.cert.initializers;

// OUTPUT:
// B - Statics first
// SomeBaseClass
// A
// C
// C Hello
// E
public class ComplexInitializationOrderExample extends SomeChildClass {

    ComplexInitializationOrderExample(){
        super("Hello");
        System.out.println("E");
    }

    public static void main(String[] args){
        new ComplexInitializationOrderExample();
    }
}

class SomeBaseClass {
    SomeBaseClass(){
        System.out.println("SomeBaseClass");
    }
}

class SomeChildClass extends SomeBaseClass {
    {System.out.println("A");}
    static{System.out.println("B - Statics first");}
    SomeChildClass(){
        super();
        System.out.println("C");
    }

    SomeChildClass(String a) {
        this(); // We can call another constructor in the same class
        System.out.println("C " + a);
    }
}