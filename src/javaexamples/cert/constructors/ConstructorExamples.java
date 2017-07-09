package javaexamples.cert.constructors;

public class ConstructorExamples {

    // Note that the constructor is private here, where can we access it?
    private ConstructorExamples(){
        System.out.println("Accessing the constructor");
    }

    public static void main (String[] args){
        // Can access here!!!!
        ConstructorExamples accessPrivateConstructorFromMain = new ConstructorExamples();
    }
}

class OutsideConstructorTest {
    public static void main (String[] args){
        // Cannot access the private constructor here!!!!
        // ConstructorExamples accessPrivateConstructorFromMain = new ConstructorExamples();
    }
}
