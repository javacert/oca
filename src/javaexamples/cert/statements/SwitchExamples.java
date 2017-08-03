package javaexamples.cert.statements;

// Data types supported are int/Integer, byte/Byte, short/Short, char/Character, String, enum values
// You cannot use long/Long, double/Double
public class SwitchExamples {

    public static void main(String[] args){
        testingDataTypes();
        performingCalculationsInSwitchExpression();
        usingContinueWithSwitch();
    }

    // The compiler needs the expression to be known at compile time in order to compile a switch
    // This means you can only use literals, enum constants, or final constant variables for case constants!

    // private static void testingDataTypes(final int blue) { // This is NOT a constant expression since blue is not known at compile time
    private static void testingDataTypes() { // This is NOT a constant expression since blue is not known
        int colorOfRainbow = 10;
        // int red = 5; - this won't compile - it has to be a constant!!!
        // final long red = 5; // cannot use long in switch
        // final double red = 5; // colorOfRainbow is an int, so you must switch with an int
        //final short red = 5; // This works fine
        final int red = 5; // This works fine since red will always be 5

        final int notYetDefined;
        notYetDefined = 6; // NOT A COMPILE TIME CONSTANT!!

        switch(colorOfRainbow){ // This doesn't have to be a compile time constant, only the case statements
            default:
                System.out.println("Home");
            case red:
                System.out.println("Away");

/*            case notYetDefined:
                System.out.println("Away");*/

/*            case blue: // see commented method above
                System.out.println("Away");*/

        }
    }

    private static void performingCalculationsInSwitchExpression() {
        final int x = 0;
        final int y = 2;

        // The following switch prints C only, since it is the last expression - observe that it has no break
        // but since it is the last expression it is fine. Remember default is only hit if
        // 1) The switch expression evaluation doesn't have a matching case
        // 2) A case doesn't have a break and it moves onto default
        switch(x+y){ // You can do this!
            case x : { System.out.println("A"); } // You can put in brackets
            case 1 : System.out.println("C");
            default : System.out.println("default"); break; // You don't need brackets though
            case y : System.out.println("C");
        }
        System.out.println("");

        // The following will print E, followed by defaultA since we didn't add a break, but default does
        switch(1){
            case x : { System.out.println("D"); }
            case 1 : System.out.println("E");
            default : System.out.println("defaultA"); break;
            case y : System.out.println("F");
        }
        System.out.println("");

        // The following will print defaultB only
        // It goes to the default and then breaks. If the break was not there, it would print R as well.
        switch(10){
            case x : { System.out.println("P"); }
            case 1 : System.out.println("Q");
            default : System.out.println("defaultB"); break;
            case y : System.out.println("R");
        }
        System.out.println("");

        // The following will print Z only
        // It goes to case 1, even though there is no break it is the last statement
        switch(1){
            default : System.out.println("defaultC"); break;
            case 1 : System.out.println("Z");
        }
        System.out.println("");

        // The following will print defaultD
        // It will go to default and then break
        switch(5){
            default : System.out.println("defaultD"); break;
            case 1 : System.out.println("X");
        }
        System.out.println("");

        // Here we remove the break from default
        // Output is defaultE, followed by Got me too!
        switch(5){
            default : System.out.println("defaultE");
            case 1 : System.out.println("Got me too!");
        }
    }

    private static void usingContinueWithSwitch() {
        // Does not compile with continue --> compiler states continue outside of loop
        switch(5){
/*            case 1 : System.out.println("Got me too!"); continue;
            default : System.out.println("defaultE");*/
        }
    }
}
