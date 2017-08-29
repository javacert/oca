package javaexamples.cert.arrays;

// It is possible to create an array of interfaces.
// You fill them with objects that implement the interface, but you will only have access to the members of the interface.
public class ArrayOfInterfaces {

    public static void main(String[] args){
        // SomeInterfaceToCreateAnArrayOutOf[] array = new SomeInterfaceToCreateAnArrayOutOf()[20]; // ()[20] invalid!
        SomeInterfaceToCreateAnArrayOutOf[] array = new SomeInterfaceToCreateAnArrayOutOf[20];
        array[0] = new SomeTestClass();
        // array[1] = new String("abc"); // --> Incompatible types

        // System.out.println(array[0].someInstanceVariable); --> Won't compile!
        System.out.println(array[0].someInterfaceConstant); // 5
    }
}

interface SomeInterfaceToCreateAnArrayOutOf{
    int someInterfaceConstant = 5;
}

class SomeTestClass implements SomeInterfaceToCreateAnArrayOutOf{
    int someInstanceVariable = 10;
    int someInterfaceConstant = 20;
}
