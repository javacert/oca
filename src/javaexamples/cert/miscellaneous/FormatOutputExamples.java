package javaexamples.cert.miscellaneous;

public class FormatOutputExamples {

    public static void main(String[] args){
        formatExamples();
        moreFormatExamples();
    }

    private static void formatExamples() {
        int n = 808;
        System.out.format("%d", n); // 808
        // In the following we take the number 808, and add zeros to make it 6 digits long
        System.out.format("%06d", n); // 000808
        // Final Output = 808000808
    }

    private static void moreFormatExamples() {
        String toFormat = "aBC";
        System.out.format("%s", toFormat); // aBC
        System.out.format("My name is: %s", "joe"); // My name is: joe
    }
}
