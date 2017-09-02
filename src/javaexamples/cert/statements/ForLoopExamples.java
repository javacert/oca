package javaexamples.cert.statements;

public class ForLoopExamples {

    public static void main(String[] args){
        validConstructsForAForLoop();
        addingMultipleTermsToForStatement();
        redeclareVariableInInitializationBlock();
        usingIncompatibleDataTypesInInitializationBlock();
        usingLoopVariablesOutsideForLoop();
        usingBreakToPreventAnInfiniteLoop();
        crazyLoopConstruct();
        isUpdateStatementRunWhenBreakHit();
        forLoopOrdering();
        moreValidForLoopExamples();
    }

    private static void validConstructsForAForLoop() {

        // Remember in a for loop, all three blocks are optional. This means we can skip
        // initialization, the middle boolean expression, or the update statement at the end.

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

    private static void crazyLoopConstruct() {
        // Observe the comma operator that is permitted in the for loop in the update statement
        // We can put virtually any arbitrary code statements that you want in the update statement - it is sometimes
        // incorrectly referred to as the 'increment expression', but it can do much more.
        for(int i = 0, j = 0; i < 3; i++, System.out.println("This works!"), System.out.println("This also works!"), ++j);
    }

    public static void isUpdateStatementRunWhenBreakHit() {
        // When the break statement is encountered inside a loop, the loop is immediately terminated,
        // and program control resumes at the next statement following the loop.
        int i = 0;
        for(; i < 1; System.out.println("If I break, then I won't be run"), i++) {
            break;
        }
        System.out.println(i); // 0 -  we break the loop and so the update statement in the for loop is NOT run
    }

    // This example shows the order of the for loop
    // 1) Initialization statement int x = 0
    // 2) Loop termination statement x < 1
    // 3) If termination statement has not been met, then execute the code in the for block, x++
    // 4) If break does not exist, then go to the update statement
    // 5) Loop termination statement x < 1
    private static void forLoopOrdering() {
        for(int x = 0; x < 1; System.out.println("x in the update statement = " + x)) {
            System.out.println("x initial value = " + x);
            x++;
            System.out.println("x incremented value = " + x);
        }

        // OUTPUT
        // x initial value = 0
        // x incremented value = 1
        // x in the update statement = 1
    }

    private static void moreValidForLoopExamples() {
        // The following compiles and runs without issue:
        int i = 0;
        for (i=1 ;  i<5  ; i++) continue;
        for (i=0 ;       ; i++) break;
        for (    ; i<5?false:true ;    );
    }
}
