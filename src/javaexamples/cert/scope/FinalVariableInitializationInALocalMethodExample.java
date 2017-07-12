package javaexamples.cert.scope;

public class FinalVariableInitializationInALocalMethodExample {

    public static void main(String[] args){
        System.out.println(localFinalVariableExample(5, 2));
    }

    // In this example you can see that final variables can be assigned once within a method
    // Remember for instance final variables they must be assigned by the time the constructor runs
    // static initializers --> instance initializers --> constructors
    private static String localFinalVariableExample(int toy, int age) {
        final String game;
        if(toy<2)
            game = age > 1 ? "Tennis" : "Gold";
        else
            game = age > 3 ? "Ball" : "Swim";

        // game = "Can't assign me!"; --> Variable game might have already been assigned
        return game;
    }
}
