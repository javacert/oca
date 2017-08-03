package javaexamples.cert.statements;

public class ForLoopExamples {

    public static void main(String[] args){
        validConstructsForAForLoop();
        addingMultipleTermsToForStatement();
        redeclareVariableInInitializationBlock();
        usingIncompatibleDataTypesInInitializationBlock();
        usingLoopVariablesOutsideForLoop();
        usingBreakToPreventAnInfiniteLoop();
    }

    private static void validConstructsForAForLoop() {

        // for(;;);             // Valid, but will create an infinite loop
        // for(;;){}            // Valid, but will create an infinite loop
        // for(int x = 0;;);    // Valid, but will create an infinite loop
        // for(;true == true;); // Valid, but will create an infinite loop
        // for(int i = 0;;i++); // Valid, but will create an infinite loop

        for(int type = 0; type < 10;){
            type++;
        }

        // for(int x = 10, y = 6; x < y; System.out.println(x--);){ // Can only have 1 statement so semi-colon not allowed
        for(int x = 10, y = 6; x < y; System.out.println(x--)){ // 2 10

        }
    }

    private static void addingMultipleTermsToForStatement() {
        int x = 0;
        for(long y = 0, z = 4; x < 5 && y < 10; x++, y    ++){
            // This is fine
        }
    }

    private static void redeclareVariableInInitializationBlock() {
        int x = 0;
        // In the following example, the compiler tried to create the long x, but it has already been defined as an int.
        // for(long y = 5, x = 10; x < 20; x++){} // --> You cannot redeclare x since it has already been declared

        // However you can do this
        for(x = 10; x < 20; x++){}

        // And you can even do this since x and y have already been declared
        long y = 10;
        for(y = 20, x = 10; x < 20 && y < 30; x++, y++){}
    }

    private static void usingIncompatibleDataTypesInInitializationBlock() {
        // You cannot declare a long and an int type within the 1 for loop
        // for(long a = 2, int b = 10 ;a < b; a++, b++){} // --> Does not compile
    }

    private static void usingLoopVariablesOutsideForLoop() {
        for(long a = 2, b = 10 ;a < b; a++){}
        // System.out.println(a); // --> a is out of scope, will not compile
    }

    private static void usingBreakToPreventAnInfiniteLoop() {
        for(long a = 2, b = 10 ;a < b;){
            System.out.println(a + " " + b); // 2 10
            // This would be an infinite loop, but we can add in a break so it only executes once
            break;
            // Note that continue would not help break the infinite loop!
            // continue;
        }
    }
}
