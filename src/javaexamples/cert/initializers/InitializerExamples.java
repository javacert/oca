package javaexamples.cert.initializers;

// A final instance or static variable has to be initialized at the time of declaration. There are 3 ways.
// 1) At the time of declaration: private static final String someString = "ABC"
// 2) Within the constructor (instance variables only)
// 3) Within the static or instance initializer block.
public class InitializerExamples {

    private static final String someString; // final static variables need initialized
    // If we add a static initializer block the compile error will go away
    static{
        someString = "A";
    }

    private final String someInstanceString; // final instance variables need initialized

    InitializerExamples(){
        someInstanceString = "I'm Initialized!";
    }

    // You can also use instance initializer OR constructor, but not both.
/*    {
        someInstanceString = "I'm Initialized!";
    }*/

    public static void main(String[] args) {
        new InitializerExamples();
    }
}
