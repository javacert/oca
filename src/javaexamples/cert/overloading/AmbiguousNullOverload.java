package javaexamples.cert.overloading;

// This example demonstrates what happens when you attempt to pass null to an overloaded method which accepts objects.
// It will print java.io.FileNotFoundException Version - Why? - because it calls the most specific version.
// i.e. FileNotFoundException extends IOException extends Object, so FileNotFoundException is the most specific class.
// Observe that if we add SomeEquallySpecificException as an overloaded method parameter, then we result in an
// ambiguous method call. Why? because both FileNotFoundException and SomeEquallySpecificException extend IOException
// and therefore it is ambiguous which method the null would call.
public class AmbiguousNullOverload {
    public void method(Object o){
        System.out.println("Object Version");
    }
    public void method(java.io.FileNotFoundException s){
        System.out.println("java.io.FileNotFoundException Version");
    }
/*    public void method(SomeEquallySpecificException s){ // --> Having this results in ambiguous method call
        System.out.println("java.io.FileNotFoundException Version");
    }*/
    public void method(java.io.IOException s){
        System.out.println("IOException Version");
    }
    public static void main(String args[]){
        AmbiguousNullOverload tc = new AmbiguousNullOverload();
        tc.method(null);
    }
}

class SomeEquallySpecificException extends java.io.IOException {

}