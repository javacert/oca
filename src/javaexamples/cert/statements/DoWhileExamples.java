package javaexamples.cert.statements;

// Don't forget the semi-colon after the while condition - results in a compilation error
public class DoWhileExamples {

    public static void main(String[] args){
        watchDoWhileScopeCarefully();
        watchDoWhileConstructionCarefully();
        doWhileScopeExample();
    }

    private static void watchDoWhileScopeCarefully() {
        do {
            int count = 0;
            do {
                count++;
            } while(count < 2);
            break;
        } while(true); // This appears as an infinite loop and it is, but also watch for scope of variables for compile errors
        // System.out.println(count); // --> This won't compile since count is out of scope!!!!!
    }

    private static void watchDoWhileConstructionCarefully() {
        // do () while(false); // --> Must be curly brackets!!!

        // The following will print Hello once, but watch for curly vs parenthesis!
        do {
            System.out.println("Hello");
        } while (false);
    }

    private static void doWhileScopeExample() {
        // Watch for variable scope with the do while loop
        //do {
        //    int x = 3;
        //} while (x < 10); // x is not in scope at this point since defined in the do block!
    }
}
