package javaexamples.cert.initializers;

/*  OUTPUT:
    I'm a static initialization block in the top most parent class
    I'm a static initialization block in the top most parent class and I'm called in order I appear!
    I'm a static initialization block in the parent class
    I'm a static initialization block in the child class
    I'm a static variable in the child class and you will notice I'm called in order 10
    I'm an instance initialization block in the top most parent class
    I'm the constructor in the top most parent class
    I'm an instance initialization block in the parent class
    I'm the constructor in the parent class
    I'm an instance initialization block in the child class
    I'm the constructor in the child class

    1 - First all static items are initialized (variable declarations and static initializers), superclass first right to child class (if the class hasn't been previously initialised)..
    2 - The super() call in the child constructor, whether explicit or implicit right up to top most parent.
    3 - Then all instance member variables are initialized (variable declarations and instance initializers) in order they appear in file.
    4 - Remaining body of constructor after super() is executed.
    5 - Moves up the hierarchy to the class being instantiated.

    From main(), InitializationOrderExamples is created using new but the superclass (right up the chain) is always created first.
    Static blocks are always run before the object is created, and as the first step each object is created moving from top most parent to child
    Static block of parent is executed first because it is loaded first and static blocks are called when the class is loaded.
    We start with the static initialization in the top most parent class since it is loaded first
    Then the parent is loaded and all static initialization is completed there
    Then the child is loaded and all static initialization is completed there

    Then we call the constructor on the child InitializationOrderExamples, and the first statement is either super (or this)
    This calls all the way to the top of the chain and then initializes the top most parent class by initializing all instance members
    Remaining body of constructor after super() is executed (since child classes will rely on attributes from the parent)
    Moves up the hierarchy (parent to child) repeating instance initialization and constructor execution.
*/

public class InitializationOrderExamples extends AbstractClassToTestInitializationOrder {

    { System.out.println("I'm an instance initialization block in the child class"); }

    public InitializationOrderExamples(){
        super();
        System.out.println("I'm the constructor in the child class");
    }

    static {
        System.out.println("I'm a static initialization block in the child class");
    }

    static int staticVariable = 10;

    static {
        System.out.println("I'm a static variable in the child class and you will notice I'm called in order " +  staticVariable);
    }

    public static void main(String[] args){
        new InitializationOrderExamples();
    }
}

abstract class AbstractClassToTestInitializationOrder extends StaticBlockOrderIsParentClassFirst {
    static { System.out.println("I'm a static initialization block in the parent class"); }
    public AbstractClassToTestInitializationOrder(){
        super();
        System.out.println("I'm the constructor in the parent class");
    }
    { System.out.println("I'm an instance initialization block in the parent class"); }
}

abstract class StaticBlockOrderIsParentClassFirst {
    static { System.out.println("I'm a static initialization block in the top most parent class"); }
    static { System.out.println("I'm a static initialization block in the top most parent class and I'm called in order I appear!"); }
    public StaticBlockOrderIsParentClassFirst(){
        super();
        System.out.println("I'm the constructor in the top most parent class");
    }
    { System.out.println("I'm an instance initialization block in the top most parent class"); }
}
