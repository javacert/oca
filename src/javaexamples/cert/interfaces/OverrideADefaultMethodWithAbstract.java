package javaexamples.cert.interfaces;

// This example shows that if you extend an interface with a default method, you can override it and make it abstract.
// You MUST implement the method in this case if you implement the interface with the abstract method
public class OverrideADefaultMethodWithAbstract implements SomeInterfaceMakingTheDefaultMethodAbstractAgain {

    // You MUST implement the abstract method otherwise you will get a compilation error
    @Override
    public void someDefaultMethod() {

    }
}

class WhatHappensToMe implements SomeInterfaceMakingTheDefaultMethodAbstractAgain, SomeInterfaceOverridingDefaultMethod {

    // Since we have ambiguity here (a default method and an abstract version) we need to override otherwise be faced
    // a compilation issue.
    @Override
    public void someDefaultMethod() {

    }
}

interface SomeInterfaceMakingTheDefaultMethodAbstractAgain extends SomeInterfaceOverridingDefaultMethod {
    void someDefaultMethod();
}

interface SomeInterfaceOverridingDefaultMethod extends SomeInterfaceWithDefaultMethod {
    default void someDefaultMethod(){
        System.out.println("I am overriding the default method!");
    }
}

interface SomeInterfaceWithDefaultMethod{
    default void someDefaultMethod(){
        System.out.println("I can be overridden!");
    }
}