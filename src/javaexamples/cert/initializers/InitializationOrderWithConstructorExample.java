package javaexamples.cert.initializers;

// This example shows that when the parent constructor runs the instance variables in the parent won't yet have been
// initialized, so print will output B 0.
public class InitializationOrderWithConstructorExample extends SomeClassWhichCallsOverriddenMethod{

    // 3) Now we initialize the instance variable after the parent class has finished being constructed
    int x = 4;

    public static void main(String[] args){
        SomeClassWhichCallsOverriddenMethod someClassWhichCallsOverriddenMethod = new InitializationOrderWithConstructorExample();
        someClassWhichCallsOverriddenMethod.print();

        // OUTPUT:
        // B 0
        // B 4
    }

    void print(){
        // 2) We call this from SomeClassWhichCallsOverriddenMethod constructor, but at this point we haven't yet initialized x, which will be default 0

        // 4) We call the print() method from the main method and output B 4
        System.out.println("B " + x);
    }
}

class SomeClassWhichCallsOverriddenMethod {

    SomeClassWhichCallsOverriddenMethod(){
        // 1) This runs first since we don't have any statics to initialize, we call the constructor
        //    We call the print() method in the subclass as it is an overridden method
        print();
    }

    void print(){
        System.out.println("A");
    }
}
