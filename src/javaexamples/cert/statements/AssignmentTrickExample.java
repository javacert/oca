package javaexamples.cert.statements;

public class AssignmentTrickExample {

    public static void main(String[] args){
        final AssignmentTrickExample test = new AssignmentTrickExample();
        System.out.println(test.runTest(false, true)); // up
    }

    private String runTest(boolean a, boolean b) {
        if (a = b) return "up"; // Note that this is an Assignment and evaluates to true!!!
        else return b ? "down" : "middle";
    }
}
