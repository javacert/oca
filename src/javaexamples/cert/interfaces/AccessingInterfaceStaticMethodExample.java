package javaexamples.cert.interfaces;

// A static method in an interface can’t be called using a reference variable. It must be called using the interface name.
// Unlike an interface, if you define a static method in a base class, it can be accessed using either a reference
// variable or the class name.
public class AccessingInterfaceStaticMethodExample {

    public static void main(String[] args) {
        Employee emp = new Programmer();
        emp.defaultPlan(); // You can call a static method in a class using the reference
        Programmer pgr = new Programmer();
        pgr.defaultPlan();
        Employee.defaultPlan(); // You can call a static method in a class using the class name
        Programmer.defaultPlan();

        // pgr.someStaticMethod(); // Static method may be invoked on containing interface class only
        SomeInterfaceWithAStaticMethod.someStaticMethod(); // Can ONLY call static methods this way when contained in an interface!
        // Programmer.someStaticMethod(); // Static method may be invoked on containing interface class only

        SomeInterfaceWithAStaticMethod anInterfaceReference;
        // anInterfaceReference.someStaticMethod(); // --> Can't access the static method in this way.
    }
}

class Employee {
    static void defaultPlan() {
        System.out.println("Basic");
    }

    // static void someStaticMethod(){} // Uncomment me and you get a compile error in Programmer!
}

class Programmer extends Employee implements SomeInterfaceWithAStaticMethod {
    // Note that static methods in an interface don't conflict with instance methods, but they do with static
    // methods in the class hierarchy. This is because we only access static methods in an interface through the Interface name.
    void someStaticMethod(){}
}

interface SomeInterfaceWithAStaticMethod {
    static void someStaticMethod(){
        System.out.println("Hello");
    }
}