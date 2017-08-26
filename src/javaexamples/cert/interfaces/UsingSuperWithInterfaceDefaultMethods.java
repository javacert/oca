package javaexamples.cert.interfaces;

// A class (or an interface) can invoke a default method of an interface that is explicitly mentioned in the class's
// implements clause (or the interface's extends clause) by using the same syntax i.e. <InterfaceName>.super.<methodName>.
public class UsingSuperWithInterfaceDefaultMethods implements SomeInterfaceWithDefaultMethodToAccessUsingSuperB {

    public void hello() {
        // super.hello(); // This is NOT valid.       
        // A.super.hello(); // This is NOT valid because TestClass does not implement A directly.       
        SomeInterfaceWithDefaultMethodToAccessUsingSuperB.super.hello(); // This is valid.    
    }
}

interface SomeInterfaceWithDefaultMethodToAccessUsingSuperB extends SomeInterfaceWithDefaultMethodToAccessUsingSuperA {

    default void hello() {
        //super.hello(); // This is NOT valid.      
        SomeInterfaceWithDefaultMethodToAccessUsingSuperA.super.hello(); // This is valid.   
    }
}

interface SomeInterfaceWithDefaultMethodToAccessUsingSuperA {

    default void hello() {}
}