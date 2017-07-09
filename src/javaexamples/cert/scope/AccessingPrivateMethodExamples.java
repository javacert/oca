package javaexamples.cert.scope;

// This shows that an instance reference can access private methods in the same class,
// even if it is a different reference but is the same type.
public class AccessingPrivateMethodExamples {

    private double imPrivateButCanYouAccessMe;

    public static void testTheAccessToPrivateFromADifferentInstance(AccessingPrivateMethodExamples someOtherInstance, int b){
        someOtherInstance.imPrivateButCanYouAccessMe = b;
        // System.out.println(this.imPrivateButCanYouAccessMe); // Cannot access from a static context
        System.out.println(someOtherInstance.imPrivateButCanYouAccessMe); // Cannot access from a static context
    }

    public static void main(String[] args){
        new AccessingPrivateMethodExamples().testTheAccessToPrivateFromADifferentInstance(new AccessingPrivateMethodExamples(), 2); // 2.0
    }
}

class WhatCanIAccess {

    public static void main(String[] args){
        AccessingPrivateMethodExamples a = new AccessingPrivateMethodExamples();
        a.testTheAccessToPrivateFromADifferentInstance(new AccessingPrivateMethodExamples(), 3); // 3.0
        // a.imPrivateButCanYouAccessMe; Can't do this as it is private
    }
}
