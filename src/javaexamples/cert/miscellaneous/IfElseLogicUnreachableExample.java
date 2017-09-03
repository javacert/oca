package javaexamples.cert.miscellaneous;

// This example shows that in the following if/else block the else statement can never be hit and the compiler will
// not complain. It is also smart enough to figure out that i will be initialized in this example.

// When you try to access a local variable, the compiler makes sure that it is initialized in all the cases.
// If it finds that there is a case in which it may not be initialized then it flags an error.
public class IfElseLogicUnreachableExample {

    public static void main(String[] args){
        unreachableExampleA();
        unreachableExampleB();
        unreachableExampleC();
        unreachableExampleD();
        unreachableExampleE();
    }

    private static void unreachableExampleA() {
        int i;
        if (true){
            if(true){
                System.out.println("Always hits me so i is always initialized!");
                i = 10;
            } else {
                System.out.println("Never hits me!");
            }
        }
        System.out.println(i);
    }

    private static void unreachableExampleB() {
        int i;
        if (true){
            if(true){
                System.out.println("Always hits me!");
            } else {
                System.out.println("Never hits me so i is never initialized!");
                i = 10;
            }
        }
        // System.out.println(i); // Will not compile because i may not have been initialized!
    }

    private static void unreachableExampleC() {
        // This is another example of a statement which ensure val has been initialized since the default case does it.
        // The compiler will not complain.
        int x = 10;
        String val;
        switch(x){
            case 2:
            default:
                val = "I'm always set since I'm the default";
        }
        System.out.println(val);
    }

    private static void unreachableExampleD() {
        int x = 10;
        String val;
        switch(x){
            case 2: break; // If we add a break, then we get a compilation error!
            default:
                val = "I'm always set since I'm the default";
        }
        // System.out.println(val); // System.out.println(val); // Will not compile because val may not have been initialized!
    }

    private static void unreachableExampleE() {
        int x = 10;
        String val;
        switch(x){
            case 2: val = "I'm always set since I'm the default";
            default:
        }
        // System.out.println(val); // Will not compile because val may not have been initialized!
    }
}
