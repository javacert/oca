package javaexamples.cert.exceptions;

public class ReturnStatementInCatchAndFinallyClauseExample {

    public static void main(String args[]) {
        ReturnStatementInCatchAndFinallyClauseExample var = new ReturnStatementInCatchAndFinallyClauseExample();
        System.out.println(var.getInt()); // 20
    }

    // If the catch and finally both have return statements, it will get the value from the finally return.
    int getInt() {
        try {
            String[] students = {"Harry", "Paul"};
            System.out.println(students[5]);
        } catch (Exception e) {
            return 10;
        } finally {
            return 20;
        }
    }
}