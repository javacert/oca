package javaexamples.cert.interfaces;

// This demo shows that interfaces can have a static main method, but they are not called and must exist in the class.
// Note that you can't implement an inner interface from containing class, it is not accessible
public class InterfaceWithMainMethodExample implements SomeOuterInterfaceWithMainMethod /* , InterfaceWithMainMethod */ {

    public static void main(String args[]){
        //SomeInnerClass a = new SomeInnerClass(); // ---> Cannot be referenced from a static process
    }

    interface SomeInnerInterfaceWithMainMethod {
        public static void main(String args[]){} // main method is allowed in interface, but is not executed
    }

    class SomeInnerClass implements SomeInnerInterfaceWithMainMethod {
        // The following will not compile --> Inner classes cannot have static implementations!!
        // public static void main(String args[]){}
    }
}

// Even though we have a static main method here and InterfaceWithMainMethodExample implements this interface,
// We receive the following runtime error when we attempt to run the application:
// Exception in thread "main" java.lang.NoSuchMethodException: javaexamples.cert.interfaces.InterfaceWithMainMethodExample.main([Ljava.lang.String;)
interface SomeOuterInterfaceWithMainMethod {
    public static void main(String[] args){
        System.out.println("I'm printed from SomeOuterInterfaceWithMainMethod");
    }
}