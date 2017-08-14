package javaexamples.cert.wrappers;

public class CommonWrapperMethodExamples {

    public static void main(String[] args){

        // valueOf will return a wrapper object from a primitive
        int myPrimInt = Integer.valueOf(5); // Compiler shows an error with unnecessary boxing
        // myPrimInt = Integer.valueOf(5L); // Doesn't compile for long
        myPrimInt = Integer.valueOf("5");
        System.out.println(myPrimInt++); // Prints 5
        System.out.println(myPrimInt); // Prints 6
        System.out.println(++myPrimInt); // Prints 7
        Integer myIntegerWrapper = Integer.valueOf(5); // Compiler shows an error with unnecessary boxing

        // parseInt will parse the String into a primitive int
        Integer myWrappedInt = Integer.parseInt("7"); // Compiles fine, but value is boxed to an Integer
        int myPrimInt2 = Integer.parseInt("7"); // Compiles fine, no need for the boxing feature!!

        Boolean b = Boolean.valueOf(true); // Creates a boolean wrapper without autoboxing
        b = Boolean.parseBoolean("yes"); // Yes is not valid
        System.out.println(b); // false
        b = Boolean.parseBoolean("true"); // Returns a boolean primitive (autoboxing required for assignment)
        System.out.println(b); // true
        b = Boolean.getBoolean("FALSE"); // Returns a boolean primitive (autoboxing required for assignment)
        System.out.println(b); // false
    }
}
