package javaexamples.cert.arrays;

public class AccessingZeroIndexedArraysExample {

    public static void main(String... args) {

        accessingZeroIndexExampleA();
        // accessingZeroIndexExampleB(); //Not a vararg so you have to pass an array!
        accessingZeroIndexExampleB(new String[3]); // null
        accessingZeroIndexExampleB(new String[]{}); // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        accessingZeroIndexExampleC("1", "2", "3", "4"); // 1
        accessingZeroIndexExampleC(); // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0

        // With no arguments to main, this would throw:
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        System.out.println(args[0] != null
                && args[0].equals("Sunny") && !false ? "Go outside" : "Stay inside");

    }

    private static void accessingZeroIndexExampleA() {
        String[] array = new String[4];
        System.out.println(array[0]); // Prints null
    }

    private static void accessingZeroIndexExampleB(String[] args) {
        System.out.println(args[0]);
    }

    private static void accessingZeroIndexExampleC(String... args) {
        // String... array = new String[4]; --> only methods can use varargs
        System.out.println(args[0]);
    }
}
