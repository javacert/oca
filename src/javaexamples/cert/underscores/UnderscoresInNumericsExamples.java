package javaexamples.cert.underscores;

public class UnderscoresInNumericsExamples {

    public static void main(String[] args){

        int intA = 1_000_000; // Compiles Fine
        //int intB = _1_000_000; // Does not compile! - can't have _ at the start
        //int intC = 1_000_000_; // Does not compile! - can't have _ at the end
        int intD = 1____3; // Compiles fine as 13
        int intE = 0xCAFE_BABE;
        int intF = 0xCAFEBABE;
        int intG = 0b1111_0000_1100_1100;
        // int intG = 0b_1111_0000_1100_1100; // Can't have 0b_
        Integer integerA = 1_000_000; // Compiles Fine
        //Integer integerB = _1_000_000; // Does not compile!
        //Integer integerC = 1_000_000_; // Does not compile!

        long longA = 1_000_000L; // Compiles Fine
        //long longB = _1_000_000L; // Does not compile!  - can't have _ at the start
        //long longC = 1_000_000_L; // Does not compile! - can't have _ at the end
        long longD = 1______________3; // Compile fine as 13
        Long longWrapperA = 1_000_000L; // Compiles Fine
        //Long longWrapperB = _1_000_000L; // Does not compile!
        //Long longWrapperC = 1_000_000_L; // Does not compile! - can't have _ at the end
        //Long longWrapperD = 1_000_000.00; // Does not compile! long to double

        //char charA = 1_000_000; // Incompatable types int to char
        char charA = 1_000; // Compiles Fine
        Character charWrapperA = 1_000; // Compiles Fine - note the character wrapper is not Char

        float floatA = 1_000_000; // Compiles Fine
        //float floatB = _1_000_000f; // Does not compile! - can't have _ at the start
        //float floatC = 1_000_000_f; // Does not compile! - can't have _ at the end
        float floatD = 1_000_000.00_00_00f; // Compiles Fine
        //float floatE = 1_000_000_.00f; // Does not compile! - can't have _ directly before the .
        //float floatF = 1_000_000._00f; // Does not compile! - can't have _ directly after the .
        //float floatG = 1_000_000.00_f; // Does not compile! - can't have _ at the end
        float floatH = 1_000_000.00f; // Compiles Fine
        //float floatI = 1_000_000.00_00_00; // Does not compile - Underscores are fine, but where is the f?
        float floatJ = 1_0_0_0_0_0_0.0_0_0_0_0_0f; // Compiles Fine
        float floatK = 3.234_567f; // Compiles Fine as 3.234567

        double doubleA = 1_000_000; // Compiles Fine
        //double doubleB = _1_000_000; // Does not compile!  - can't have _ at the start
        //double doubleC = 1_000_000_; // Does not compile! - can't have _ at the end
        double doubleD = 1_000_000.00_00_00; // Compiles Fine
        //double doubleE = 1_000_000_.00; // Does not compile! - can't have _ directly before the .
        //double doubleF = 1_000_000._00; // Does not compile! - can't have _ directly after the .
        //double doubleG = 1_000_000.00_; // Does not compile! - can't have _ at the end
    }
}
