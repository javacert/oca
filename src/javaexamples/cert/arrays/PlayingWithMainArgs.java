package javaexamples.cert.arrays;

// This example shows 2 things:
// 1) You can overload a method with multi-dimensional arrays
// 2) You can assign an array to a multi-dimensional anonymous initializer. Remember that main args will never be null,
//    but may be an array of length 0
public class PlayingWithMainArgs {

    public static void main(String[][] args) {
        System.out.println(args[0][1]);
    }

    public static void main(String[] args) {
        PlayingWithMainArgs fwa = new PlayingWithMainArgs();
        String[][] newArgs = {args}; // This is fine since you are passing a single dimension array to an anonymous initializer
        fwa.main(newArgs);
    }
}
