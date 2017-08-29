package javaexamples.cert.casting;

import java.util.Set;
import java.util.function.Predicate;

// The following rules cover the common compile-time cases:
// 1) When the OldType and the NewType are classes, one class must be a subclass of the other
// 2) When both OldType and the NewType are arrays, both arrays must contain reference types (not primitives) and it
//    must be legal to cast an element of OldType to an element of NewType
// 3) You can always cast between an interface and a non-final object

// The following rules cover the common runtime cases:
// 1) If NewType is a class, the class of the expression being converted must be NewType of inherited from NewType
// 2) In NewType is an interface, the class of the expression being converted must implement NewType
public class AnotherCastingExample{

    // Casting to Interfaces - we can cast to any interface and we don't get a compile time exception
    Roamable varA = (Roamable)new Phone(); // Would throw a ClassCastException
    Roamable varB = (EvenMoreRoamable)new Phone(); // Would throw a ClassCastException
    Set setExtendsCollection = (Set)new Phone(); // We can cast to any interface - will result in a runtime exception
    EvenMoreRoamable varD = (EvenMoreRoamable)new Phone(); // Would throw a ClassCastException
    Predicate varE = (Predicate)new Phone(); // Would throw a ClassCastException

    // EXCEPT in the case the class being cast is a final class and DOES NOT implement that interface.
    // Roamable varC = (EvenMoreRoamable)new AnotherPhone(); // Won't compile since AnotherPhone is a final interface

    // When the OldType and the NewType are classes, one class must be a subclass of the other
    // IOException varB = (IOException)new Phone(); //--> Doesn't compile - Phone and IOException have no relationship

    // Casting from super class may work, so it is allowed (during compilation).
    // Casting from a totally different class is not allowed
    Integer a = 1;
    // String b = (String)a; // compile error
    String b = (String)(Object)a; // runtime error
}

interface EvenMoreRoamable extends Roamable{}
interface Roamable{}
class Phone {}
final class AnotherPhone {}
