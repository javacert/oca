package javaexamples.cert.miscellaneous;

public class StrangeLabelUsageExample {

    public static void main(String[] args){
        int c = 0;
        JACK: while(c<8){
            JILL: System.out.println(c);

            // if(c > 3) break JILL; // Undefined label since out of scope
        }

        // Observe how you can create labels for any singular statement.
        // Watch when this happens and there is a break or a continue - it won't compile if the label is out of scope of the loop.
        SOME_RANDOM_LABEL: if(true)System.out.println("This one statement works fine");
    }
}
