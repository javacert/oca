package javaexamples.cert.arrays;

import java.util.Arrays;

// Notes:
// The size of the array must evaluate to an int value.
// Java accepts an expression to specify the size of an array, as long as it evaluates to an int value.
// Code to access an array index will fail to compile if you don’t use a char, byte, short, or int.
public class ArrayExamples {

    private static final String someString; // static variables need initialized
    // If we add a static initializer block the compile error will go away
    static{
        someString = "A";
    }

    public static void main(String[] args) {
        anonymousInitializer();
        confirmAnArrayAnObject();
        howToInitializeAnArrayOfPrimitives();
        howToInitializeAnArrayOfObjects();
        arrayDefinitionsAndVarargs();
        outputtingTheContentsOfAStringArray();
        gettingTheLengthOfAnArray();
        trickLengthExample();
        invalidArrayInitialization();
        arraySubSetSort();
        arraysFillExample();
        doFinalConstantsThrowCompileError();
        getClassIsArrayMethod();
    }

    private static void anonymousInitializer() {
        // Anonymous Initializer is only allowed in the declaration
        String [] grades = {"A", "B", "C", "D", "E", "F"}; // This is fine
        String [] moreGrades;
        // moreGrades = {"A", "B", "C", "D", "E", "F"}; // This is NOT fine

        // Compare the following anonymous arrays as well...
        Integer [] integerArray = { 1, 2, 3 };
        Integer [] integerArrayAlt = new Integer[]{ 1, 2, 3 };

        // Be careful, you cannot do this
        int[][]ints = new int[3][2];
        //ints[2] = {1, 2, 3}; // Array initializer not allowed here
        ints[2] = new int[3];
        ints[2] = new int[]{1, 2, 3}; // This works because we are creating a new array object

        Integer[][]intsB = new Integer[3][2];
        // intsB[2] = {1, 2, 3}; // nope!
        intsB[2] = new Integer[]{1, 2, 3}; // This works because we are creating a new array object
    }

    private static void confirmAnArrayAnObject() {
        int[] somePrimitiveArray = new int[]{1, 2, 3};
        if (somePrimitiveArray instanceof Object){
            System.out.println("An array of primitives is of course an object!");
        }

        String[] someObjectArray = new String[]{"A"};
        if (someObjectArray instanceof Object){
            System.out.println("An array of Objects is of course an object!");
        }

        int somePrimitive = 0;
        // if (somePrimitive instanceof Object){} --> Does not compile
    }

    public static void arrayDefinitionsAndVarargs(){
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

    private static void howToInitializeAnArrayOfPrimitives() {
        int[] myIntArrayA = new int[3];
        int[] myIntArrayB = {1,2,3};
        int[] myIntArrayC = new int[]{1,2,3};
        // int[] myIntArrayD = new int[]; --> You need to set the size - this won't compile!!
        // int[] myIntArrayE = new int[3]{1,2,3}; --> You can't do this!
    }

    private static void howToInitializeAnArrayOfObjects() {
        String[] myStringArrayA = new String[3];
        String[] myStringArrayB = {"a","b","c"};
        String[] myStringArrayC = new String[]{"a","b","c"};
    }

    private static void outputtingTheContentsOfAStringArray() {

        // Remember that you need to use Arrays.toString to print the contents ***
        String[] strings = new String[2];
        System.out.println(String[].class);             // class [Ljava.lang.String;
        System.out.println(strings);                    // [Ljava.lang.String;@28d93b30
        System.out.println(strings.toString());         // [Ljava.lang.String;@28d93b30
        System.out.println(Arrays.toString(strings));   // [null, null]
    }

    public static void gettingTheLengthOfAnArray() {
        String[] strings = new String[2];
        System.out.println("Length is " + strings.length);
    }

    public static void trickLengthExample() {
        int x = 0;

        String[] animal = new String[3];
        do {
            animal[x] = "Dog";
        } while (x > animal[x++].length()); // This length is the String length method!!
    }

    private static void invalidArrayInitialization() {
        long size = 0xB;
        System.out.println(size); // 11
        // int [] array = new int[size]; // Incompatible types on size - expected int, received long
        // long [] array = new long[size]; // Incompatible types on size - expected int, received long

        int intSize = 0xB;
        int [] arrayA = new int[intSize];
        arrayA[10] = 1;

        char c = 'a';
        int [] arrayB = new int[c];
        arrayB[c] = 1; // Fine although it will throw a RuntimeException due to an index of 97.

        byte b = 1;
        int [] arrayC = new int[b];
        arrayC[b] = 1;

        Byte wrapperByte = 1;
        int [] arrayD = new int[wrapperByte];
        arrayD[wrapperByte] = 1;

        double d = 1.0;
        // int [] arrayE = new int[d]; // Required int, received double
        // arrayE[d] = 1; // Will not compile, can't access array using a double!
    }

    private static void arraySubSetSort() {
        int[] ints = {3, 6, 1, 4, 0};
        Arrays.sort(ints, 2, 4);

        System.out.println(Arrays.toString(ints)); // [3, 6, 1, 4, 0]

        Arrays.sort(ints, 1, 4);
        System.out.println(Arrays.toString(ints)); // [3, 1, 4, 6, 0]
    }

    private static void arraysFillExample() {
        int x [] = new int [3];
        Arrays.fill(x, 1); // assigns a value to all array entries
        System.out.println(x[2]); // 1
    }

    private static void doFinalConstantsThrowCompileError() {
        final int x = 10;
        int[] someArray = new int[] {1, 2, 3};
        someArray[7] = 5; // No compilation error
        someArray[x] = 5; // No compilation error even with final variable!!
    }

    public static void getClassIsArrayMethod() {
        int[] someArray = new int[]{1, 2, 3};
        System.out.println(someArray.getClass().isArray()); // true
    }
}
