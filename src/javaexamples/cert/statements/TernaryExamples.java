package javaexamples.cert.statements;

// A ternary operator only evaluates one of the two right hand expressions at run-time.
public class TernaryExamples {

    public static void main(String[] args){
        trickyExample();
        onlyOneExpressionRunAtRuntimeExample();
    }

    private static void trickyExample() {
        String lion = "Lion";
        String tiger = "Tiger";

        // The following is not valid since a return variable is expected but instead a statement is encountered.
        // String statement = 248 < 500 ? lion : tiger = " is Bigger";

        // By surrounding in brackets this works fine
        String statementA = 248 < 500 ? lion : (tiger = " is Bigger");
        String statementB = 248 > 500 ? lion : (tiger = " is Bigger");
        System.out.println(statementA); // Lion
        System.out.println(statementB); //  is Bigger
    }

    private static void onlyOneExpressionRunAtRuntimeExample() {

        int y = 1;
        int z = 2;

        // This example shows that only the left hand side was executed at Runtime in this particular example.
        // Only 1 expression will be evaluated at Runtime based on whether the expression evaluates to true or false.
        final int x = y < 10 ? y++ : z++;
        System.out.println(y + " " + z); // 2 2
    }
}
