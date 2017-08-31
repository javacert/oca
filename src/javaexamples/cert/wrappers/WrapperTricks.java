package javaexamples.cert.wrappers;

// A narrowing primitive conversion may be used if the type of the variable is byte, short, or char,
// and the value of the constant expression is representable in the type of the variable.
public class WrapperTricks {

    public static void main(String[] args){
        trickExamplesA();
    }

    private static void trickExamplesA() {
        // This is important to understand - understand this line "constant expression is representable in the type
        // of the variable". This means that at the time of assignment, the constant MUST be a constant.

        // 1) We can assign a final int to a char:
        final int finalInt = 1;
        char charAcceptingAConstant = finalInt;

        // 2) However this will NOT compile:
        int notAFinalInt = 1;
        // char charAcceptingAnInt = notAFinalInt; // Required char, found int

        // 3) The next line will NOT compile since the method does not return a constant expression
        // char one = Integer.parseInt("1");
        char one = (char)Integer.parseInt("1");

        // 4) Again the following will not compile because a constant expression is not returned
        //Character two = Integer.parseInt("2");
        int three = Integer.parseInt("3");
        Integer four = Integer.parseInt("4");

        // 5) Once again, not a constant expression.
        //short five = Integer.parseInt("5");
        //Short six = Integer.parseInt("6");
        short five = (short)Integer.parseInt("5"); // We can cast though
        Short six = (short)Integer.parseInt("6");

        // 6) Still won't work even if the method return is assigned to a final int
        final int constantReturn = Integer.parseInt("6");
        // short seven = constantReturn; // Will not compile
    }
}
