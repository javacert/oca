package javaexamples.cert.scope;

public class TrickyScopeExamples {

    private static int yesterday = 1;
    int tomorrow = 10;

    private static void someMethod(){
        System.out.println("Hello");
    }

    public static void main(String[] args){
        TrickyScopeExamples trickyScopeExamples = new TrickyScopeExamples();
        int today = 20, tomorrow = 40;
        System.out.println(trickyScopeExamples.tomorrow);
        System.out.println(trickyScopeExamples.yesterday); // Note we can access static variables in this way
        System.out.println(TrickyScopeExamples.yesterday); // Note we can access static variables in this way as well

        trickyScopeExamples.someMethod(); // Note we can access static methods in this way
        TrickyScopeExamples.someMethod(); // Note we can access static methods in this way as well

        trickyScopeExamples = null;
        trickyScopeExamples.someMethod(); // This static method call works even on a null reference!!!

    }
}
