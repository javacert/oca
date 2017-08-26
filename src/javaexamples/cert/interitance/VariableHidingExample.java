package javaexamples.cert.interitance;

// This example shows that you can hide both final instance and static variables when you extend a class.
// The reference will determine which variable you are working with.
public class VariableHidingExample extends SomeClassWithVariableToHide {

    int someVariableToHide = 20; // This variable hides the same variable in the parent class
    static int someStaticVariableToHide = 2;

    public static void main(String[] args){
        SomeClassWithVariableToHide variableHidingExample = new VariableHidingExample();
        // Remember it is the reference that determines what variable you will get
        System.out.println(variableHidingExample.someVariableToHide); // 10
        System.out.println(((VariableHidingExample)variableHidingExample).someVariableToHide); // 20

        System.out.println(variableHidingExample.someStaticVariableToHide); // 1
        System.out.println(((VariableHidingExample)variableHidingExample).someStaticVariableToHide); // 2

        // variableHidingExample.someStaticVariableToHide = 10; // Can't modify a final variable
        ((VariableHidingExample)variableHidingExample).someStaticVariableToHide = 10;
    }
}

class SomeClassWithVariableToHide {
    final int someVariableToHide = 10; // You can hide final variables!
    final static int someStaticVariableToHide = 1;
}
