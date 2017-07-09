package javaexamples.cert.initializers;

public class InitializerExamples {

    private static final String someString; // static variables need initialized
    // If we add a static initializer block the compile error will go away
    static{
        someString = "A";
    }

    public static void main(String[] args) {
        new InitializerExamples();
    }
}
