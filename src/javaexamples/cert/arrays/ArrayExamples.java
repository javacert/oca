package javaexamples.cert.arrays;

public class ArrayExamples {

    private static final String someString; // static variables need initialized
    // If we add a static initializer block the compile error will go away
    static{
        someString = "A";
    }

    public static void main(String[] args) {
        arrayDefinitions();
    }

    public static void arrayDefinitions(){
        // String array[] = new String()[5]; // Not valid
        String array[] = new String[5];
        String[] array2 = {"A", "B"};
        // {"A", "B"}; // This is not a valid array, you need to do...
        // new boolean[2]; // Not a valid statement on its own, so...
        varArgMethod(new boolean[2]); // false false, remember primitives will default
        //varArgMethod2(new boolean[2]); // Will not compile
        varArgMethod2(new Boolean[2]); // null null
    }

    public static void varArgMethod(boolean ...varArg){ // ... comes before!
        for(boolean object : varArg) {
            System.out.println(object);
        }
    }

    public static void varArgMethod2(Boolean ...varArg){ // ... comes before!
        for(Boolean object : varArg) {
            System.out.println(object);
        }
    }
}
