package javaexamples.cert.constructors;

public class PrivateConstructorScopeExamples {

    // Note that the constructor is private here, where can we access it?
    private PrivateConstructorScopeExamples(){
        System.out.println("Accessing the constructor");
    }

    public static void main (String[] args){
        // Can access here!!!!
        PrivateConstructorScopeExamples accessPrivateConstructorFromMain = new PrivateConstructorScopeExamples();
    }
}

class OutsideConstructorTest {
    public static void main (String[] args){
        // Cannot access the private constructor here!!!!
        // ConstructorExamples accessPrivateConstructorFromMain = new ConstructorExamples();
    }
}
