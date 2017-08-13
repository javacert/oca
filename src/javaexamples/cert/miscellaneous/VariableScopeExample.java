package javaexamples.cert.miscellaneous;

public class VariableScopeExample {

    // Example A: Test the initialization order
    static int testTheOrderBefore;
    static {
        testTheOrder = 1; // We can assign and use the static variable before its definition in the class
        testTheOrder = testTheOrderBefore;
        // testTheOrder = testTheStaticAssignment; // Illegal forward reference
        // testTheOrder = testTheInstanceAssignment; // Non-static field referenced from a static context
    }
    // Same with instance initialization
    {
        testTheInstanceAssignment = 1;
        testTheInstanceAssignment = testTheStaticAssignment;
    }
    static int testTheOrder;
    static int testTheStaticAssignment;
    int testTheInstanceAssignment;
    static {
        testTheOrder = testTheStaticAssignment; // Illegal forward reference
        // testTheOrder = testTheInstanceAssignment; // Non-static field referenced from a static context
    }

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
