package javaexamples.cert.scope;

public class BlockScopeExamples {

    public static void main(String[] args){
        blockScopeExample();
        scopeInAMethodWithLoopExample();
    }

    private static void blockScopeExample() {
        {
            int i = 0;
        }
        int i = 2; // Out of scope by the time it reaches here!
    }

    private static void scopeInAMethodWithLoopExample() {
        // int i = 20; // Can't have i here though
        for (int i = 0; i < 10; i++) System.out.print(i + " ");
        for (int i = 10; i > 0; i--) System.out.print(i + " ");
        int i = 20; // Observe here - i in the for loops is now out of scope and you can use it here.
        System.out.print(i + " ");
    }
}
