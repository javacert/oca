package javaexamples.cert.miscellaneous;

// This example shows that you can use variables declared on the same line since they will be initialized to their
// default value as you move from left to right.
public class InitializingOnOneLineExample {

    static int x, y = 10, z = x * y;
    static int i = 5, j = 10, k = x * y + (i + j);

    // static int a = 5, b = 10, c = d, d = 10; // Will not compile! Using d before it is defined.

    public static void main(String[] args){
        System.out.println(z); // 0
        System.out.println(k); // 15
    }
}
