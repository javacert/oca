package javaexamples.cert.statements;

public class SwitchExamples {

    public static void main(String[] args){
        //testingDataTypes(5);
        testingDataTypes();
    }

    // The compiler needs the expression to be known at compile time in order to compile a switch
    // This means you can only use literals, enum constants, or final constant variables!

    // private static void testingDataTypes(final int blue) { // This is NOT a constant expression since blue is not known at compile time
    private static void testingDataTypes() { // This is NOT a constant expression since blue is not known
        int colorOfRainbow = 10;
        // int red = 5; - this won't compile - it has to be a constant!!!
        // final long red = 5; // cannot use long in switch
        // final double red = 5; // colorOfRainbow is an int, so you must switch with an int
        //final short red = 5; // This works fine
        final int red = 5; // This works fine since red will always be 5

        switch(colorOfRainbow){
            default:
                System.out.println("Home");
            case red:
                System.out.println("Away");
/*            case blue:
                System.out.println("Away");*/

        }
    }
}
