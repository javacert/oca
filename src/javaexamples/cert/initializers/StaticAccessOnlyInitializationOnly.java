package javaexamples.cert.initializers;

// This example shows that if you are accessing a static variable only in a class and you do not instantiate it,
// Then it won't do the same static initialization as when you create an instance of the class.

// A class or interface type T will be initialized immediately before the first occurrence of any one of the following:
// 1) T is a class and an instance of T is created.
// 2) T is a class and a static method declared by T is invoked.
// 3) A static field declared by T is assigned.
// 4) A static field declared by T is used and the field is not a constant variable (§4.12.4).
// 5) T is a top level class (§7.6), and an assert statement (§14.10) lexically nested within T (§8.1.3) is executed.
// 6) A reference to a static field (§8.3.1.1) causes initialization of only the class or interface that actually
//    declares it, even though it might be referred to through the name of a subclass, a subinterface, or a class
//    that implements an interface.
// 7) Invocation of certain reflective methods in class Class and in package java.lang.reflect also causes class or
//    interface initialization.
public class StaticAccessOnlyInitializationOnly {

    public static void main(String[] args){
        System.out.println(Sub.ID); // Prints QBANK only since we don't call the static initializer

        // Note that if we created an instance of Sub and then printed the Sub.ID we would get In SubQBANK
        //Sub sub = new Sub();
        //System.out.println(Sub.ID);
    }
}

class Super { static String ID = "QBANK"; }

class Sub extends Super{
    static { System.out.print("In Sub"); }
}