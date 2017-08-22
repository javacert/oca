package javaexamples.cert.statements;

public class WhileLoopExamples {

    public static void main(String[] args){
        unreachableStatement();
    }

    private static void unreachableStatement() {
        // Observe the following, you cannot have a while(false) but you can have if(false). If is an exception to the rule.
        // do {} while (false) will also compile since it is always executed at least once.
        int x = 0;
        //while(false) {
            // Unreachable Statement
        //}

        // Note that while (true) is permitted.
        while(true) {

        }
    }
}
