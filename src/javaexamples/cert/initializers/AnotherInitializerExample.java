package javaexamples.cert.initializers;

// This example shows that when you first access the main method of AnotherInitializerExample it will load the static
// variables for that first (we are not extending A1 in this example). Therefore the order is as follows:
// 1) "AnotherInitializerExample Loaded" - since we access the main method in this class we initialize the statics first
// 2) "A should have been loaded" - now we are in the main method
// 3) "A1 should not have been loaded" - even though we create a reference variable, we are not initializing or accessing the class
// 4) "A1 Loaded" - finally we access a static variable through the reference variable and initialize the A1 class statics
public class AnotherInitializerExample {

    static { System.out.println("AnotherInitializerExample Loaded"); }
    public static void main(String[] args){
        System.out.println("A should have been loaded");
        A1 a1 = null;
        System.out.println("A1 should not have been loaded");
        System.out.println(a1.i);
    }
}

class A1{
    static int i = 10;
    static { System.out.println("A1 Loaded"); }
}