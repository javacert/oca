package javaexamples.cert.statements;

public class OptionLabelExamples {

    private static int[][] myComplexArray = {{5, 2, 1, 3}, {3, 6, 8, 9}, {5, 7, 12, 7}};

    public static void main(String[] args){
        simpleBreakExample();
        optionalLabelWithADoWhileExample();
        preventingAnInfiniteLoop();
        breakingToAnOptionLabelA();
        breakingToAnOptionLabelB();
        continueToAnOptionLabelA();
        continueToAnOptionLabelB();
    }

    private static void simpleBreakExample() {
        letters: for (char ch='a'; ch<='z'; ch++){
            numbers: for (int n=0; n<=10; n++){
                // break; // --> Breaks out of immediate loop and prints "Break out of the numbers loop"
                // break numbers; // --> Breaks out of immediate loop and prints "Break out of the numbers loop"
                break letters; // --> Breaks to the letters loop and prints "Break out of the letters loop" - exits both loops!
            }
            System.out.println("Break out of the numbers loop");
        }
        System.out.println("Break out of the letters loop");
    }

    private static void optionalLabelWithADoWhileExample() {
        // The following compiles fine and is NOT an infinite loop since we break the loop!
        String race = "";
        loop:
        do{
            race += "x";
            break loop;
        } while(true);
        System.out.println("Got to here! " + race);
    }

    private static void preventingAnInfiniteLoop() {
        t: while (true){
            f: while (true){
                // This would be an infinite loop with just a break statement!
                // break;
                // break f; // --> Still an infinite loop!
                break t; // No longer an infinite loop since we break the outer loop t!
            }
        }
    }

    private static void breakingToAnOptionLabelA() {
        System.out.println();
        System.out.println("breakingToAnOptionLabelA");
        OUTER_LOOP: for (int[] mySimpleArray : myComplexArray){
            INNER_LOOP: for(int i = 0; i<mySimpleArray.length; i++){
                System.out.println(i);
                if(i == 1){
                    System.out.println("Breaking to OUTER_LOOP");
                    break OUTER_LOOP;
                }
            }
            // The following never gets printed since we break to the OUTER_LOOP
            System.out.println("Iterating over mySimpleArray");
        }
        System.out.println("Exited both loops!");
    }

    private static void breakingToAnOptionLabelB() {
        System.out.println();
        System.out.println("breakingToAnOptionLabelB");
        OUTER_LOOP: for (int[] mySimpleArray : myComplexArray){
            INNER_LOOP: for(int i = 0; i<mySimpleArray.length; i++){
                System.out.println(i);
                if(i == 2){
                    System.out.println("Breaking to INNER_LOOP");
                    break INNER_LOOP;
                }
            }
            System.out.println("Iterating over mySimpleArray");
        }
        System.out.println("Exited both loops!");
    }

    private static void continueToAnOptionLabelA() {
        System.out.println();
        System.out.println("continueToAnOptionLabelA");
        OUTER_LOOP: for (int[] mySimpleArray : myComplexArray){
            INNER_LOOP: for(int i = 0; i<mySimpleArray.length; i++){
                System.out.println(i);
                if(i == 1){
                    System.out.println("Continue to OUTER_LOOP");
                    continue OUTER_LOOP;
                }
            }
            // The following never gets printed since we continue to the OUTER_LOOP each time skipping all this code!
            System.out.println("Iterating over mySimpleArray");
        }
        System.out.println("Exited both loops!");
    }

    private static void continueToAnOptionLabelB() {
        System.out.println();
        System.out.println("continueToAnOptionLabelB");
        OUTER_LOOP: for (int[] mySimpleArray : myComplexArray){
            INNER_LOOP: for(int i = 0; i<mySimpleArray.length; i++){
                System.out.println(i);
                if(i == 2){
                    System.out.println("Continue to INNER_LOOP");
                    continue INNER_LOOP;
                }
            }
            System.out.println("Iterating over mySimpleArray");
        }
        System.out.println("Exited both loops!");
    }
}
