package javaexamples.cert.miscellaneous;

// Note that for is a keyword and so cannot be used as a label (or any other keywords). But you can use any other
// identifier as a label. For example the following would be valid:
//      String String = "";   // This is valid.
//      String : for(int i = 0; i< 10; i++) // This is valid too!
public class StrangeLabelUsageExample {

    public static void main(String[] args){
        int c = 0;
        JACK: while(c<8){
            JILL: System.out.println(c);

            // if(c > 3) break JILL; // Undefined label since out of scope - need to be within the JILL block {   }
        }

        // Observe how you can create labels for any singular statement.
        // Watch when this happens and there is a break or a continue - it won't compile if the label is out of scope of the loop.
        SOME_RANDOM_LABEL: if(true)System.out.println("This one statement works fine");

        // In the following case the label is for a block (above it was for a statement i.e. no curly braces)
        LABEL_FOR_A_BLOCK: {
            if (true){
                break LABEL_FOR_A_BLOCK; // Break out of entire block and continue with the println statement below.
            }
        }
        System.out.println("I broke out of the LABEL_FOR_A_BLOCK block");
    }
}
