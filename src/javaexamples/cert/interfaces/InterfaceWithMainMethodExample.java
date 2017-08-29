package javaexamples.cert.interfaces;

// This demo shows that interfaces can have a static main method, but they are not called and must exist in the class itself.
// Why? - main is not accessible since static methods in interfaces and classes are not related. Remember to access a static
// method in an interface you must reference through the interface name e.g. InterfaceName.someStaticMethod(). You cannot
// shadow a static method from an interface either - they are completely distinct.

// Note that you can't implement an inner interface from containing class, it is not accessible.
// Why couldn't you have a static method in an inner interface? Because you can only access static methods through the
// interface reference and in this case we will never have a reference to an anonymous interface implementation.
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