package javaexamples.cert.shadowvariable;

// This demo shows that when you shadow a static variable with an instance variable, the instance variable takes
// precedence from what was defined in the interface. However, it will depend on the reference type when accessing
// variables.
public class ShadowingAnInterfaceVariable implements ShadowingInterface {
    int someIntToShadow = 0;

    public static void main(String[] args){
        // The following is with the reference type equal to the object being instantiated
        ShadowingAnInterfaceVariable shadowingAnInterfaceVariable = new ShadowingAnInterfaceVariable();
        System.out.println(ShadowingInterface.someIntToShadow); // 20
        System.out.println(shadowingAnInterfaceVariable.someIntToShadow); // 0 - someIntToShadow has been shadowed and so you no longer reference the interface static variable
        // System.out.println(someIntToShadow); //  Does not compile since someIntToShadow cannot be referenced from a static context
        System.out.println(someOtherIntToShadow); // 30 This is the interface static variable - it is not shadowed
        System.out.println(shadowingAnInterfaceVariable.someOtherIntToShadow); // 30 This is the interface static variable - it is not shadowed

        // Now watch what happens when we switch the reference type to the interface
        ShadowingInterface shadowingInterfaceRef = new ShadowingAnInterfaceVariable();
        System.out.println(ShadowingInterface.someIntToShadow); // 20
        System.out.println(shadowingInterfaceRef.someIntToShadow); // 20 - the variable is picked up by the reference type!!!!
        System.out.println(((ShadowingAnInterfaceVariable)shadowingInterfaceRef).someIntToShadow); // 0

    }
}

interface ShadowingInterface {
    int someIntToShadow = 20; // Remember these are static
    int someOtherIntToShadow = 30; // Remember these are static
}
