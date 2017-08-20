package javaexamples.cert.statements;

public class IfElseExamples {
    public static void main(String[] args){
        basicIfElseExample();
        ifElseWithReturnExampleWhichCompiles();
        trickIfElseWithReturnExample();
        danglingElseProblem(new String[]{"Only 1"});
    }

    private static void basicIfElseExample() {
        boolean isSomething = true;
        if(isSomething){
            // Do something
        } else if (!isSomething){

        } // You don't have to have the else here!
    }

    private static boolean ifElseWithReturnExampleWhichCompiles() {
        boolean someBoolean = false;
        if (someBoolean){
            return true;
        } else { // REMEMBER YOU CANNOT HAVE A CONDITION WITH THE ELSE!
            return false; // This compiles because there is no conditional logic!
        }
    }

    private static boolean trickIfElseWithReturnExample() {
        boolean someBoolean = false;
        // The following block will NOT compile since the return is ambiguous and might never be executed. Watch!
        if (someBoolean){
            return true;
        } else if (!someBoolean) { // Another condition here which might never evaluate to true
            return false;
        }

        // We must add the following to remove the compilation error from above.
        return true;
    }

    private static void danglingElseProblem(String[] args) {

        // The following if/else will print nothing -
        // The else statement actually belongs to the inner if statement (known as dangling if) since
        // we cannot be sure what statement the else was actually intended for!
        if(args[0].equals("open"))
            if(args[1].equals("someone"))
                System.out.println("Hello!");
        else System.out.println("Go Away " + args[1]);
    }
}
