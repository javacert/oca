package javaexamples.cert.interitance;

// The output of this example is:
// "You would think this is not output in this example, but it is!!!"
// Reason is that we are accessing a private method from within the class.
// If we switch the main to the concrete class implementation, you can see that the method is not accessible
// We need to switch the reference - remember reference is important when it comes to overriding

public abstract class AccessingPrivateExamples {

    public int hiddenVariable;

    private void somePrivateMethod() {
        System.out.println("You would think this is not output in this example, but it is!!!");
    }

    public void somePublicMethod() {
        System.out.println("Let's practice overriding - AccessingPrivateExamples");
    }

    protected int somePublicMethodToTryAndOverride() throws RuntimeException {
        return 1;
    }

    public static void somePublicStaticMethod() {
        System.out.println("Let's practice hiding - AccessingPrivateExamples");
    }

    public static void someOtherPublicStaticMethod() {
        System.out.println("Let's practice hiding - AccessingPrivateExamples");
    }

    public static void main(String[] args){
        AccessingPrivateExamples accessingPrivate = new AccessingPrivateConcreteImpl();
        accessingPrivate.somePrivateMethod();
    }
}

class AccessingPrivateConcreteImpl extends AccessingPrivateExamples {

    public int hiddenVariable = 1;

    protected void somePrivateMethod(){
        System.out.println("Is this some kind of trick?");
    }

    public void somePublicMethod() {
        System.out.println("Let's practice overriding - AccessingPrivateConcreteImpl");
        //super.somePublicMethod();
    }

    // The following will not compile since Exception is more general than RuntimeException
/*    public int somePublicMethodToTryAndOverride() throws Exception {
        return 1;
    }*/

    // The following will not compile since the access modifier is more restrictive
    // error is - attempting to assign a weaker access privileges private, was protected
/*    private int somePublicMethodToTryAndOverride() throws RuntimeException {
        return 1;
    }*/

    public static void somePublicStaticMethod() {
        System.out.println("Let's practice hiding - AccessingPrivateConcreteImpl");
    }

//    public void someOtherPublicStaticMethod() {
//        System.out.println("Let's practice hiding - AccessingPrivateExamples");
//    }
    // ---> This will not compile since there is a static method with the same name!!!

    public static void main(String[] args){
        AccessingPrivateExamples accessingPrivate = new AccessingPrivateConcreteImpl();
        // accessingPrivate.somePrivateMethod(); // Method not accessible with this reference

        // We need to do...
        AccessingPrivateConcreteImpl accessingPrivateConcrete = new AccessingPrivateConcreteImpl();
        accessingPrivateConcrete.somePrivateMethod(); // Method not accessible with this reference
        // Output is: Is this some kind of trick?

        accessingPrivate.somePublicMethod(); // Let's practice overriding - AccessingPrivateConcreteImpl
        accessingPrivateConcrete.somePublicMethod(); // Let's practice overriding - AccessingPrivateConcreteImpl
        System.out.println(accessingPrivate.hiddenVariable); // 0 - accessing in parent class
        System.out.println(accessingPrivateConcrete.hiddenVariable); // 1 - variable is hidden

        AccessingPrivateExamples.somePublicStaticMethod(); // Let's practice hiding - AccessingPrivateExamples
        AccessingPrivateConcreteImpl.somePublicStaticMethod(); // Let's practice hiding - AccessingPrivateConcreteImpl
    }
}
