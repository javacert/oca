package javaexamples.cert.statements;

public class DoWhileExamples {

    public static void main(String[] args){
        watchDoWhileScopeCarefully();
        watchDoWhileConstructionCarefully();
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
}
