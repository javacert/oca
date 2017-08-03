package javaexamples.cert.miscellaneous;


public class VariableScopeExample {

    static int testTheScope;
    static int accessMeWithoutChangingScope = 50;

    int testTheInstanceVariableScope;
    int accessInstanceVarWithoutChangingScope = 60;

    public static void main(String[] args){

        testTheStaticVariableScope();
        testTheInstanceVariableScope();
    }

    private static void testTheStaticVariableScope() {

        // You can redefine another int with the same name as the static
        int testTheScope = 1;

        System.out.println(testTheScope); // 1
        System.out.println(VariableScopeExample.testTheScope); // 0

        // If you don't redefine in the method access is to the class level variable
        System.out.println(accessMeWithoutChangingScope); // 50
        System.out.println(VariableScopeExample.accessMeWithoutChangingScope); // 50
    }

    private static void testTheInstanceVariableScope() {

        VariableScopeExample variableScopeExample = new VariableScopeExample();
        variableScopeExample.callInstanceMethod();
    }

    private void callInstanceMethod() {
        //int testTheInstanceVariableScope;
        //testTheInstanceVariableScope + 10; // --> Compile error - never initialized

        // You can also redefine instance variables in methods
        int testTheInstanceVariableScope = 10;

        System.out.println(testTheInstanceVariableScope); // 10
        System.out.println(this.testTheInstanceVariableScope); // 0

        // As with static, if you don't redefine within the method then you will get the instance variable
        System.out.println(accessInstanceVarWithoutChangingScope); // 60
        System.out.println(this.accessInstanceVarWithoutChangingScope); // 60
    }
}
