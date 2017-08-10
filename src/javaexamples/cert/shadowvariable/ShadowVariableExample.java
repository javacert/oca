package javaexamples.cert.shadowvariable;

public class ShadowVariableExample {

    static int x = 0;
    int y = 0;

    public static void main(String[] args){
        ShadowVariableExample shadowVariableExample = new ShadowVariableExample();
        shadowVariableExample.shadowMyVariables();
    }

    private void shadowMyVariables() {
        if (x == 0){
            System.out.println(x + " " + y); // 0 0
            int x = 10; // 10 for the scope of this if block
            int y = 15; // 15 for the scope of this if block
            System.out.println(x + " " + y); // 10 15
        }
        System.out.println(x + " " + y); // 0 0
        int x = 20; // 20 until the end of the method
        int y = 30; // 30 until the end of the method
        System.out.println(x + " " + y); // 20 30
    }
}
