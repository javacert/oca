package javaexamples.cert.miscellaneous;

public class ImportingStatics {
    public static int seeds = 10;
    public static Integer getInteger() { return 1; }
}

// You could import these statics into another package using:
// 1) import static javaexamples.cert.miscellaneous.seeds;
// 2) import static javaexamples.cert.miscellaneous.getInteger;
// 3) import static javaexamples.cert.miscellaneous.ImportingStatics.*;