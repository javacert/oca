package javaexamples.cert.wideningandboxing;

public class WideningAndBoxingExamples {

    public void print(byte x){
        System.out.println("byte");
    }

    public void print(int x){
        System.out.println("int");
    }

    public void print(float x){
        System.out.println("float");
    }

    public void print(Object x){
        System.out.println("Object");
    }

    public static void main(String[] args){
        WideningAndBoxingExamples w = new WideningAndBoxingExamples();
        short s = 123;
        w.print(s); // short promoted to int
        w.print(true); // boolean autoboxed to Boolean, which is an object
        w.print(6.789); // double autoboxed to Double, also an object (float would be narrowing)
        w.print(6.789F); // float
        w.print(6L); // float as well
        w.print('c'); // int

        float f = 6L; // Valid
        double d = 6L; // Valid
        double d2 = 10.2F; // Valid
        double d3 = 'c'; // Valid

        //int i = 6L; // Compile error

        int x = 1;
        long y = x * (long)x; // This is fine since x is automatically widened to long any way
        //int z = x * (long)x; // This is not fine - expression widened to long and then assigned to an int
        int za = x * (int)y; // However this is fine
        float fa = x * y; // Fine
        double da = x * y; // Fine
        double db = x * 'c'; // Fine
        // char ch = x * 'c'; // Does not compile since promoted to int
        // char ch2 = (char)x * 'c'; // Does not compile since 'c' promoted to int, and then int expression assigned back to a char
        // char ch3 = (char)x * (char)'c'; // Does not compile since 'c' promoted to int even with cast
        char ch4 = (char)(x * 'c'); // Fine
    }
}
