package javaexamples.cert.methodsignatures;

// A method signature should look like this
// modifiers type methodName(parameters) [throws Exception]

// Access Modifiers: private, protected, public
// Non-access modifiers: static, final, abstract, synchronized, volatile

// Main point to remember is that the return type must come before the method name!
public class MethodSignatureExamples {

    private static volatile int MY_INT = 0;

    static final int someMethodA(){return 10;}
    final static int someMethodB(){return 10;}
    public final static int someMethodC(){return 10;}
    final public static int someMethodD(){return 10;}
    static final public int someMethodE(){return 10;}
    // volatile static final public int someMethodF(){return 10;} // --> volatile not permitted in a method
    synchronized static final public int someMethodG(){return 10;}
    // abstract synchronized static final public int someMethodH(){return 10;} // --> Cannot have abstract and static

    // The following is an incorrect signature because:
    // The return type should go before the method name and after any access, final or static modifiers
/*    public final int static someMethod(){
        return 10;
    }*/
}

abstract class AbstractMethodSignatureExamples{
    // abstract synchronized final public int someMethodA(){return 10;} // --> Cannot have abstract and synchronized
    // abstract final public int someMethodA(){return 10;} // --> Cannot have abstract and final
    // abstract public int someMethodA(){return 10;} // --> abstract cannot have a body
    abstract public int someMethodA();
}
