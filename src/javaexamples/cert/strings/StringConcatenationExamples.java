package javaexamples.cert.strings;

public class StringConcatenationExamples {

    // IMPORTANT TO REMEMBER!!!!!
    // Java evaluates the + operator from left to right - therefore if you have numeric additions
    // followed by String concatenation, then the numeric values will be added together!

    public static void main(String[] args){
        concatenationExample1();
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
}
