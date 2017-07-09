package javaexamples.cert;

public class UnderscoresInNumerics {

    public static void main(String[] args){
        int intA = 1_000_000; // Compiles Fine
        int intB = _1_000_000; // Does not compile! - can't have _ at the start
        int intC = 1_000_000_; // Does not compile! - can't have _ at the end
        Integer integerA = 1_000_000; // Compiles Fine
        Integer integerB = _1_000_000; // Does not compile!
        Integer integerC = 1_000_000_; // Does not compile!


        long longA = 1_000_000; // Compiles Fine
        long longB = _1_000_000; // Does not compile!  - can't have _ at the start
        long longC = 1_000_000_; // Does not compile! - can't have _ at the end
        Long longA = 1_000_000; // Compiles Fine
        Long longB = _1_000_000; // Does not compile!
        Long longC = 1_000_000_; // Does not compile! - can't have _ at the end
        Long longD = 1_000_000.00; // Does not compile! long to double

        float floatA = 1_000_000; // Compiles Fine
        float floatB = _1_000_000f; // Does not compile! - can't have _ at the start
        float floatC = 1_000_000_f; // Does not compile! - can't have _ at the end
        float floatD = 1_000_000.00_00_00f; // Compiles Fine
        float floatE = 1_000_000_.00f; // Does not compile! - can't have _ directly before the .
        float floatF = 1_000_000._00f; // Does not compile! - can't have _ directly after the .
        float floatG = 1_000_000.00_f; // Does not compile! - can't have _ at the end
        float floatH = 1_000_000.00f; // Compiles Fine
        float floatI = 1_000_000.00_00_00; // Does not compile - Underscores are fine, but where is the f?
        float floatJ = 1_0_0_0_0_0_0.0_0_0_0_0_0f; // Compiles Fine

        double doubleA = 1_000_000; // Compiles Fine
        double doubleB = _1_000_000; // Does not compile!  - can't have _ at the start
        double doubleC = 1_000_000_; // Does not compile! - can't have _ at the end
        double doubleD = 1_000_000.00_00_00; // Compiles Fine
        double doubleE = 1_000_000_.00; // Does not compile! - can't have _ directly before the .
        double doubleF = 1_000_000._00; // Does not compile! - can't have _ directly after the .
        double doubleG = 1_000_000.00_; // Does not compile! - can't have _ at the end
    }
}
