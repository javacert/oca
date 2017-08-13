package javaexamples.cert.interfaces;

// Interface rules to note
// 1) In Java 8, we can have static and default methods in interfaces but there are some rules
//    -- you cannot override Object class methods using the default method
// 2) Both static and default methods are public
public class InterfaceExamples {

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
