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
    }
}

class Employee {
    static void defaultPlan() {
        System.out.println("Basic");
    }
}

class Programmer extends Employee implements SomeInterfaceWithAStaticMethod {
}

interface SomeInterfaceWithAStaticMethod {
    static void someStaticMethod(){
        System.out.println("Hello");
    }
}