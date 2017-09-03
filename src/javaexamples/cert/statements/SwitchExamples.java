package javaexamples.cert.statements;

// Data types supported are int/Integer, byte/Byte, short/Short, char/Character, String, enum values
// You cannot use long/Long, double/Double, float/Float, boolean/Boolean (due to exact values of float and double being difficult) OR Object
// You CANNOT use null in a switch statement.
// You cannot have duplicate case values.
// A switch case cannot have the value null.
// Case values must be compile time constants, as in they should be final or enums
// The switch variable must be big enough to hold all the case constants. For example, if the switch variable is of type char,
//    then none of the case constants can be greater than 65535 because a char's range is from 0 to 65535, or -128 to 127 for a byte
// No two of the case constant expressions associated with a switch statement may have the same value.
// At most one default label may be associated with the same switch statement.
// A final array contains variables which may not be compile time constants - watch for final arrays.
// You can nest switch statements
// Switch statements are more efficient than a set of nested if statements
// The switch statement compares the String object in its expression with the expressions associated
//    with each case label as if it were using the String.equals method; consequently, the comparison of String
//    objects in switch statements is case sensitive.
// The Java compiler generates generally more efficient bytecode from switch statements that use String objects than
//    from chained if-then-else statements.
// At most one default label may be associated with the same switch statement.
// The comparison of String objects in switch statements is case sensitive since it uses String.equals method.
public class SwitchExamples {

    public static void main(String[] args){
        testingDataTypes();
        performingCalculationsInSwitchExpression();
        usingContinueWithSwitch();
        switchWithDefaultOnly();
        switchWithNoCasesOrDefault();
        switchWithEmptyCasesAndEmptyFinally();
        switchStatementWithComplexStatements();
        objectInASwitchIsNotAllowed();
        wrapperUsageIsAllowed();
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

    private static void switchWithDefaultOnly() {
        switch (1) { default : break; }
    }

    private static void switchWithNoCasesOrDefault() {
        switch (1) { }
    }

    private static void switchWithEmptyCasesAndEmptyFinally() {
        switch (1) {
            case 1: {}{}
            case 2:
            case 0: {};
            default:
            case 4:
        }
    }

    private static void switchStatementWithComplexStatements() {
        // You can have complex statements within a switch statement.
        int k = 9, s = 5;
        switch (k) {
            default:
                if (k == 10) {
                    s = s * 2;
                } else {
                    s = s + 4;
                    break;
                }
            case 7:
                s = s + 3;
        }
        System.out.println(s); // 9
    }

    private static void objectInASwitchIsNotAllowed() {
        final Object a = new Object();
        //switch(a){ // --> Incompatible types: Found java.lang.Object, required: char, byte, short, int, Character, Byte, Short, Integer, String or enum
            //case null: // --> null is not a valid case
            //case a: // --> Object is not a valid case
        //}
    }

    private static void wrapperUsageIsAllowed() {

        Integer conditionA = new Integer("1");
        switch (conditionA) {
            case 1:
                System.out.println("1"); // Prints 1
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
        }

        // Remember, Unboxing and then Widening (BW) IS allowed.
        Byte conditionB = 2;
        switch (conditionB) {
            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println("B"); // Prints B
                break;
            case 3:
                System.out.println("C");
                break;
        }

    }
}
