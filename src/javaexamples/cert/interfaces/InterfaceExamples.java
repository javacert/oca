package javaexamples.cert.interfaces;

// Interface rules to note
// 1) In Java 8, we can have static and default methods in interfaces but there are some rules
//    -- you cannot override Object class methods using the default method
// 2) Both static and default methods are public
// 3) A static method in an interface can’t be called using a reference variable. It must be called using the interface name.
//    -- Unlike an interface, if you define a static method in a base class, it can be accessed using either a reference
//       variable or the class name.
// 4) You can declare a top-level interface with only the following non-access modifiers: abstract & strictfp
// 5) A Top-level interface can’t be defined as private or protected.
// 6) All members of an interface - variables, methods, inner interfaces, and inner classes (yes, an interface can define
//    a class within it) are inherently public because that’s the only modifier they can accept.
// 7) the variables of an interface are implicitly public, final, and static. You must initialize all variables in
//    an interface, or your code won’t compile.
// 8) Interface methods are implicitly abstract. To define default or static methods, you must explicitly use the
//    keyword default or static with the method declaration in an interface.
// 9) You must implement an abstract method of an interface using the explicit access modifier public. Remember you are
//    overriding and must follow the rules of overriding (Access modifier can only be the same of less restrictive).
// 10) While overriding a default method, you must not use the keyword default.
//     Rules for overriding default and regular methods are the same.
// 11) The static methods in a class and the interface that it implements are not related to each other.
//     A static method in a class does not hide or override the static method in the interface that it implements
//     like it would in a standard class.
public strictfp class InterfaceExamples {

    public static void main(String[] args){

        // This demonstrates an anonymous interface implementation
        SomeStandardInterface i = new SomeStandardInterface() {
            @Override
            public void someStandardMethod() {
                System.out.println("Hello there from an anonymous interface class!");
            }
        };
        // The above can be replaced with a lambda in Java 8 (Predicate etc)
        i.someStandardMethod(); // Hello there from an anonymous interface class!

        InterfaceExamples interfaceExamples = new InterfaceExamples();
        interfaceExamples.someInstanceMethod(); // Hello there from an anonymous abstract class!
    }

    void someInstanceMethod(){
        // The following demonstrates an inner abstract class and an anonymous implementation
        SomeInnerAbstractClass someInnerAbstractClass = new SomeInnerAbstractClass(){
            @Override
            void someInnerAbstractClassMethod() {
                System.out.println("Hello there from an anonymous abstract class!");
            }
        };
        someInnerAbstractClass.someInnerAbstractClassMethod();
    }

    abstract class SomeInnerAbstractClass {
        abstract void someInnerAbstractClassMethod();
    }
}

interface TryingToOverrideObjectMethodsInADefault {
    // Default method 'equals' overrides a member of 'java.lang.Object'
    // default boolean equals(Object e){ return true; }
}

abstract interface SomeStandardInterface { // abstract implied if not provided since all interfaces are abstract
    abstract void someStandardMethod(); // other than default and static methods, other methods are all abstract
}
