package javaexamples.cert.strings;

public class StringConcatenationExamples {

    // IMPORTANT TO REMEMBER!!!!!
    // String concatenation and addition have the same precedence.
    // Java evaluates the + operator from left to right - therefore if you have numeric additions
    // followed by String concatenation, then the numeric values will be added together!

    public static void main(String[] args){
        concatenationExample1();
        invalidConcatenationExample();
    }

    private static void concatenationExample1() {
        int a = 5, b = 6, c = 7;
        // Remember order of precedence, * then +
        System.out.println(a + b * c + ""); // 5 + 42 + "" = 47 + "" = "47"
        // System.out.println(a + b * c * ""); // Compile error, cannot apply * operator to string

        // Remember * is done first before the concatenation +
        System.out.println(a + b + "" + a * b); // 11 + "" + "30" = "1130"

        // Evaluated from left to right
        System.out.println(a + b + "" + a + b); // 11 + "" + "5" + "6" = "1156"

        // Evaluated from left to right
        System.out.println("" + a + b + "" + a + b); // "" + "5" + "6" + "" + "5" + "6" = "5656"

        // Remember * /  done first since they take precedence over +
        System.out.println("" + a * b + "" + a / c); // "" + "30" + "" + "0" = "300"
    }

    private static void invalidConcatenationExample() {
        int x = 10, y = 12;
        // In the following since you are now concatenating a String, you cannot use the - operator
        //System.out.println("Answer is : " + x - y); // Operator - cannot be applied to java.lang.String

        // This however compiles fine
        System.out.println(x - y + " is the Answer"); // -2 is the Answer

        // The following works since ++, --, * and / have higher precedence than +
        System.out.println("Answer is : " + x * y); // Answer is : 120
        System.out.println("Answer is : " + x / y); // Answer is : 0
        System.out.println("Answer is : " + x % y); // Answer is : 10
        System.out.println("Answer is : " + x++); // Answer is : 10
        System.out.println("Answer is : " + --x); // Answer is : 10
    }
}
