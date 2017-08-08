package javaexamples.cert.overriding;

// This class demonstrates covariant return types for method overriding
// Overriding methods can change the return type only within the bounds of covariant returns.
// It simply means that the overriding method can return a subtype of the return type contained within the super class.
public class CovariantReturnTypeExample {}

class Alpha {

    Alpha method(){
        return new Alpha();
    }
}

class Beta extends Alpha {

    Beta method(){
        return new Beta();
    }

    // The following would throw a compiler error stating an incompatible return type
    //C method(){
    //    return new C();
    //}
}

// C does not extend A nor B so cannot be considered a covariant return type
class Charlie {

}

class Delta extends Alpha {

    // The following will throw a compiler error stating an incompatible return type
    Delta method(){
        return new Delta();
    }

    // The following would throw a compiler error stating an incompatible return type
    // Remember that it must be a subtype for a covariant return.
    //Object method(){
    //    return new Object();
    //}
}