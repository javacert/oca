package javaexamples.cert.interitance;

public class AssignmentsRequiringCastsExamples {

    // Rules:
    // 1) A reference to a class CANNOT be assigned to a subclass reference without an explicit cast (A Dog is not necessarily a Beagle)
    // 2) A reference to a class CAN be assigned to a superclass reference without an explicit cast (A Beagle is always a Dog)
    // 3) A reference to an interface CANNOT be assigned to a reference of a class that implements the interface without an explicit cast
    //    ¦__ An interface does not inherit from a class
    // 4) An explicit cast is NOT required to assign a reference to a class that implements an interface to a reference of the interface

    public static void main(String[] args){

        // 1) A reference to a class CANNOT be assigned to a subclass reference without an explicit cast
        Dog dogReferenceA = new Beagle();
        Dog dogReferenceB = new Basset();
        Beagle beagleReferenceA = new Beagle();
        Basset bassetReferenceA = new Basset();
        dogReferenceA = dogReferenceB; // Fine, since both reference are of type dog
        // beagleReferenceA = dogReferenceA; // Won't compile since references differ and requires an explicit cast - A Dog is not necessarily a Beagle!
        beagleReferenceA = (Beagle)dogReferenceA; // Compiles, but will throw a Runtime Error ClassCastException since dogReferenceA is now a Basset

        // 2) A reference to a class CAN be assigned to a superclass reference without an explicit cast
        Beagle beagleReferenceB = new Beagle();
        Dog dogReferenceC = new Beagle();
        dogReferenceC = beagleReferenceB;

        // 3) A reference to an interface CANNOT be assigned to a reference of a class that implements the interface without an explicit cast
        Basset bassetReferenceB = new Basset();
        SleepsLots sleepsLotsReferenceA = new Basset();
        // bassetReferenceB = sleepsLotsReferenceA; // --> Cannot do this since SleepsLots reference may be any dog that SleepsLots
        bassetReferenceB = (Basset)sleepsLotsReferenceA; // Therefore we need a cast!

        // 4) An explicit cast is NOT required to assign a reference to a class that implements an interface to a reference of the interface
        Beagle beagleReferenceC = new Beagle();
        Barks barksReferenceA = new Beagle();
        barksReferenceA = beagleReferenceC; // Since the Beagle reference is a Barks reference also, we don't need the cast
        // beagleReferenceC = barksReferenceA; // --> However we cannot do it the other way around!
    }
}

class Beagle extends Dog {

}

class Basset extends Dog implements SleepsLots {

}

abstract class Dog extends Animal implements Barks {

}

abstract class Animal {

}

interface Barks {

}

interface SleepsLots {

}
