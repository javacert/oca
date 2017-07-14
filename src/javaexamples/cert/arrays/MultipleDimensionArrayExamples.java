package javaexamples.cert.arrays;

import java.util.Arrays;

public class MultipleDimensionArrayExamples {

    public static void main(String[] args){
        waysToInitializeAMultiDimensionArray();
        initializingOnTheOneLine();
        gettingTheLengthOfAMultiDimensionalArray();
        reassigningArrayItemToAnother();
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
        System.out.println(booleanArray.length); // 5
        System.out.println(booleanArray[0].length); // 3
        System.out.println(booleanArray[3].length); // 3
        System.out.println(booleanArray[3][2].length); // 2
        // System.out.println(booleanArray[3][3].length); // ArrayIndexOutOfBoundsException
        System.out.println(booleanArray[3][2][1].length); // 1
        // System.out.println(booleanArray[3][2][1][0].length); // NullPointerException
        // System.out.println(booleanArray[5][3][2].length); // Runtime Exception ArrayIndexOutOfBoundsException
        // System.out.println(booleanArray[3][2][11].length); // Runtime Exception ArrayIndexOutOfBoundsException

        // booleanArray.size;       // Nope
        // booleanArray.size();     // Nope
        // booleanArray.length();   // Nope
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
}
