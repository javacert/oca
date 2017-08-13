package javaexamples.cert.arrays;

import java.util.Arrays;

public class MultipleDimensionArrayExamples {

    public static void main(String[] args){
        waysToInitializeAMultiDimensionArray();
        initializingOnTheOneLine();
        gettingTheLengthOfAMultiDimensionalArray();
        determiningArrayLengthExample();
        reassigningArrayItemToAnother();
        sortingMultiDimensionalArray();
        accessingNotInitializedArray();
    }

    private static void waysToInitializeAMultiDimensionArray() {
        // int[][] twoDimArr = new int[][]; --> Need to set the size for at least the first array
        int[][] twoDimArr = new int[4][5];
        int[][] twoDimArrInitialized = { { 1, 2 }, { 3, 4 } };

        // int[][][] threeDimArr = new int[4][][6]; --> This won't compile
        int[][][] threeDimArr = new int[4][5][6];
        int[][][] threeDimArrInitialized = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

        int[][][][] fourDimArr = new int[4][5][6][5]; // Fine
        int[][][][][] fiveDimArr = new int[4][5][6][5][]; // Fine
        int[] fiveDimArrEdge[][][][] = new int[4][][][][]; // Fine

    }

    private static void initializingOnTheOneLine() {
        boolean[][][] boolsA, moreBoolsA;
        // moreBools = true; --> Won't compile, moreBools is an int[][][]

        moreBoolsA = new boolean[5][][];
        if(moreBoolsA instanceof boolean[][][]){
            System.out.println("Yes I'm a three dimensional array");
        }

        boolean[][][] boolsB, moreBoolsB[][][];
        // boolsB = [5][][]; --> Does not compile
        // boolsB = {{{true}}}; --> Array Initializer is Not Allowed Here
        boolsB = new boolean[5][][];

        //moreBoolsB = new boolean[5][][]; // Required boolean[][][][][][]
        moreBoolsB = new boolean[5][][][][][]; // Required boolean[][][][][][]

        if(moreBoolsB instanceof boolean[][][][][][]){
            System.out.println("Yes I'm a six dimensional array");
        }

    }

    private static void gettingTheLengthOfAMultiDimensionalArray() {
        boolean[][] booleanArray[][][][] = new boolean[5][3][2][1][][];
        System.out.println(booleanArray.length); // 5 - points to first array size
        System.out.println(booleanArray[0].length); // 3 - points to second array size so the following are all the same!!
        System.out.println(booleanArray[1].length); // 3
        System.out.println(booleanArray[2].length); // 3
        System.out.println(booleanArray[3].length); // 3
        System.out.println(booleanArray[4].length); // 3
         // System.out.println(booleanArray[5].length); // ArrayIndexOutOfBoundsException
        System.out.println(booleanArray[0][0].length); // 2 - points to third array size so the following are all the same!!
        System.out.println(booleanArray[1][1].length); // 2
        System.out.println(booleanArray[2][2].length); // 2
        // System.out.println(booleanArray[3][3].length); // ArrayIndexOutOfBoundsException
        System.out.println(booleanArray[3][2][0].length); // 1 - points to fourth array size so the following are all the same!!
        System.out.println(booleanArray[3][2][1].length); // 1
        // System.out.println(booleanArray[3][2][1][0].length); // NullPointerException
        // System.out.println(booleanArray[5][3][2].length); // Runtime Exception ArrayIndexOutOfBoundsException
        // System.out.println(booleanArray[3][2][11].length); // Runtime Exception ArrayIndexOutOfBoundsException

        // booleanArray.size;       // Nope
        // booleanArray.size();     // Nope
        // booleanArray.length();   // Nope
    }

    private static void determiningArrayLengthExample() {
        //-------------------------listing     [0][0]      [1][0]  [1][1]
        String[][] listing = new String[][]{ { "Book" }, { "Game", "29.99" } };
        // THIS IS IMPORTANT - when you initialize using the following:
        // boolean[][] booleanArray = new boolean[5][3];
        // You are initializing all to that size which is why in the previous method gettingTheLengthOfAMultiDimensionalArray
        // all where the same. But here, we are initializing the arrays so they will have
        System.out.println("listing[0][0] " + listing[0][0]); // Book
        System.out.println("listing[1][0] " + listing[1][0]); // Game
        System.out.println("listing[1][1] " + listing[1][1]); // 29.99

        // The primary array (as in listing) points to the first array which has 2 elements
        // Then listing[0] points to the first array at listing[0] which only has Book, so size is 1
        System.out.println(listing.length + " " + listing[0].length); // 2 1
        // Then listing[0] points to the second array at listing[1] which has Game and 29.99, so size is 2
        System.out.println(listing.length + " " + listing[1].length); // 2 2
    }

    private static void reassigningArrayItemToAnother() {
        int[][] game = new int[6][6];
        game[3][3] = 6;

        // int[] obj = game; // This won't compile - Required int[] Found int[][]
        Object justATest = game; // This is legal since all arrays are objects
        Object[] obj = game; // This is legal but dangerous - Only works on Object[]
        // Object[][] objB = game; // This won't compile - Required java.lang.Object[][] Found int[][]

        // What is obj now?
        if(obj instanceof int[][]){
            System.out.println("Here obj is a 2 dimensional array since we assigned it to game");
            System.out.println(obj == game); // true
            System.out.println(Arrays.toString(obj) + " equals " + Arrays.toString(game));
            // In the following remember that the reference limits what you can access, even though they are pointing to the same object
            // System.out.println(obj[3][3] + " equals " + game[3][3]); --> This won't compile, can only do obj[3] and not obj[3][3] given the reference
        }

        // Why dangerous? In the next line the compiler can't protect us from assigning a String to an int[]
        // because the reference is more generic. Throws a runtime exception because it is the wrong type.
        obj[3] = "X"; // Can't put a String in an int array --> java.lang.ArrayStoreException: java.lang.String
        System.out.println(game[3][3]);
    }

    private static void sortingMultiDimensionalArray() {
        String[][] strings = {{"A", "Z"}, {"C", "D", "S"}, {"L"}};

        // Watch here - Arrays has an overloaded method which takes Object[]
        // String implements comparable, but when it tries to cast a multi-dimensional array to Comparable,
        // It tries to cast String[] and not String, so it throws a ClassCastException
        Arrays.sort(strings); // public static void sort(Object[] a)
        System.out.println(strings);

        for(String[] str : strings){
            for(String s : str){
                System.out.println(s);
            }
        }
    }

    private static void accessingNotInitializedArray() {
        int [][]ints = new int[2][];
        System.out.println(Arrays.toString(ints[1])); // null

        // We can't do an Arrays.sort on it - null pointer will be thrown
        //Arrays.sort(ints[1]); // Exception in thread "main" java.lang.NullPointerException

        // If we had initialized it and then sorted the array...
        ints[1] = new int[]{5, 2, 1, 3};
        Arrays.sort(ints[1]);
        System.out.println(Arrays.toString(ints)); // [null, [I@28d93b30]
        System.out.println(Arrays.toString(ints[0])); // null
        System.out.println(Arrays.toString(ints[1])); // [1, 2, 3, 5]
    }
}
