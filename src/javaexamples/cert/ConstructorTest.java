package javaexamples.cert;

public class ConstructorTest {

    private ConstructorTest(){
        System.out.println("Accessing the constructor");
    }

    public static void main (String[] args){
        // Can access here!!!!
        ConstructorTest accessPrivateConstructorFromMain = new ConstructorTest();
    }
}

class OutsideConstructorTest {
    public static void main (String[] args){
        // Cannot access here!!!!
        // javaexamples.cert.ConstructorTest accessPrivateConstructorFromMain = new javaexamples.cert.ConstructorTest();
    }
}
