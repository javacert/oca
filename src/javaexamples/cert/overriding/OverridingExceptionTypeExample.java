package javaexamples.cert.overriding;

// This class demonstrates that when obeying the override rules, it is only Checked Exceptions which must be more general
// You can throw RuntimeExceptions and Errors and it won't impact the override.
public class OverridingExceptionTypeExample extends SomeOtherClassWithAMethodToOverride {

    // This compiles fine because:
    // 1) Access modifier is more accessible. Making this private would result in a compilation error
    //      ---> default (private, package-private, protected, public)
    // 2) Integer is a convariant of Number, and so is fine to override in this way
    // 3) ArrayIndexOutOfBoundsException is a RuntimeException and you can throw any number of those as part of the override
    // Observe how the compiler indicates that ArrayIndexOutOfBoundsException is redundant since RuntimeException is more general
    protected Integer supply() throws RuntimeException, ArrayIndexOutOfBoundsException {
        return null;
    }

    // The following will not compile!
    // Remember, the overriding method should not throw CHECKED exceptions that are new or broader
    // that the ones declared in the overridden method. Exception is a CHECKED EXCEPTION here.
/*    public String supply() throws Exception {
        return null;
    }*/
}

class SomeOtherClassWithAMethodToOverride extends ClassWithAMethodToOverride{
    // This compiles fine because:
    // 1) Number is a convariant of Object, and so is fine
    // 2) NullPointerException is a RuntimeException and you can throw any number of those as part of the override
    // 3) Error is not a Checked Exception and again will not impact the override
    Number supply() throws NullPointerException, Error {
        return null;
    }
}

class ClassWithAMethodToOverride{
    Object supply(){
        return null;
    }
}
