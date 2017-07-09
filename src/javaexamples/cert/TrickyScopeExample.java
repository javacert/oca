package javaexamples.cert;

public class TrickyScopeExample {

    private static int yesterday = 1;
    int tomorrow = 10;

    private static void someMethod(){
        System.out.println("Hello");
    }

    public static void main(String[] args){
        TrickyScopeExample trickyScopeExample = new TrickyScopeExample();
        int today = 20, tomorrow = 40;
        System.out.println(trickyScopeExample.tomorrow);
        System.out.println(trickyScopeExample.yesterday); // Note we can access static variables in this way
        System.out.println(TrickyScopeExample.yesterday); // Note we can access static variables in this way as well

        trickyScopeExample.someMethod(); // Note we can access static methods in this way
        TrickyScopeExample.someMethod(); // Note we can access static methods in this way as well

        trickyScopeExample = null;
        trickyScopeExample.someMethod(); // This static method call works even on a null reference!!!

    }
}
