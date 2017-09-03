package javaexamples.cert.overloading;

// Overloading Rules:
// 1) Change the method signature --> the number of arguments, the type of arguments and the order of arguments.
// 2) Remember that the return type of method is not part of method signature, so just changing the return type will not overload a method in Java.
// 3) The method name must be the same.
// 4) We cannot overload two methods in Java if they differ only by static keyword, but you can have a static and instance overload
// 5) Widening is preferred to boxing/unboxing, which in turn, is preferred over var-args --> Widening > Boxing > Varargs

// Therefore, some examples:
// 1) method(Integer) will be bound to method(Integer) (exact match).
//    If that is not available, it will be bound to method(long), and then with method(int...) in that order of preference.
// 2) method(Integer) is never bound to probe(Long) because Integer and Long are different object types and there is no
//    IS-A relation between them. (This holds true for any two wrapper classes).
public class OverloadingExamples {

    public static void main(String[] args){}

    public void buzz(){}

    public static void buzz(int someInt){}

    public void buzz(boolean someBool){}

    protected void buzz(boolean someBool, boolean someOtherBool){}

    // int buzz(boolean someBool, boolean someOtherBool){ return 1; } // --> Won't compile as already defined - only the access mod changed!

    int buzz(boolean someBool, boolean someOtherBool, boolean anotherBool){ return 1; }

    int buzz(boolean someBool, boolean someOtherBool, int someInt){ return 1; }
}

class OverLoadingExamplesSubClass extends OverloadingExamples {
    // Note you can overload and make it private. If the method signature matched and you were overriding,
    // you would end up with a compilation issue since private is a more restrictive access modifier.
    private int buzz(boolean someBool, boolean someOtherBool, int someInt, int someOtherInt){
        return 1;
    }
}
