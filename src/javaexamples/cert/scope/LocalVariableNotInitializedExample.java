package javaexamples.cert.scope;

public class LocalVariableNotInitializedExample {

    static boolean b = false;

    public static void main(String[] args){
        basicExampleA();
        basicExampleB();
    }

    private static void basicExampleA() {

        String str;
        if(b = true) { str = "true"; }
        // str = b ? str : "false"; // Variable 'str' may not have been initialized

        str = "true";
        str = b ? str : "false";
        str = (b ? str : "false");

        System.out.println(str);
    }

    private static void basicExampleB() {
        String name, other; // Note you can create a local variable and not assign it anything, as long as you don;t use it.
    }
}
