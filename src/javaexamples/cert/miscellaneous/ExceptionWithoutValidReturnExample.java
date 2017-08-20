package javaexamples.cert.miscellaneous;

public class ExceptionWithoutValidReturnExample {

    public static int m1() throws Exception {
        throw new Exception("Some Exception");

        // WHOAAA no return statement when you throw an exception!!!!
    }
}
