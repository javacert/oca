package javaexamples.cert.overloading;

// Overloading Rules:
// 1) Change the method signature --> the number of arguments, the type of arguments and the order of arguments.
// 2) Remember that the return type of method is not part of method signature, so just changing the return type will not overload a method in Java.
// 3) The method name must be the same.
// 4) We cannot overload two methods in Java if they differ only by static keyword, but you can have a static and instance overload

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
