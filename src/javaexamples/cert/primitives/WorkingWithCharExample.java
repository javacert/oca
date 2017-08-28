package javaexamples.cert.primitives;

// This example tries to demonstrate that when we assign an integer value to char, it is assigning the integer value.
// For example a char of 'a' is equal to an int of 97 - i.e. ('a' == 97) is true
public class WorkingWithCharExample {

    public static void main(String args[]){
        charsAsInts();
        trickyLoopExample();
        incrementingAChar();
        ambiguousCharExample();
        assigningCharAVeryLargeInt();
    }

    private static void charsAsInts() {

        char c = 97; // We can assign ints to chars, and that value is the actual int value.
        System.out.println(c); // 'a' since println calls valueOf to convert char to new String
        // We can cast to an int and print the numeric value of 97, but this is to ensure correct overloaded version of
        // println is called - c will always represent the integer value of 97
        System.out.println((int)c);

        char c2 = 'a';
        System.out.println(c2); // 'a'
        System.out.println((int)c2); // 97 (Converted on the ASCII chart)
    }

    private static void trickyLoopExample() {
        char i;
        LOOP: for (i=0; i<5; i++){ // We can assign integers to char, so i will be integer value 0 (not '0')
            // Integer 0 or 1, 2 etc. is not same as char '0', '1' or '2' etc.
            switch(i++){
                case '0': System.out.println("A");              // Won't print this because 0 does not equal '0'
                case 1: System.out.println("B"); break LOOP;    // Skips this since we have i++ in switch and i++ in loop
                case 2: System.out.println("C"); break;         // Hits this because char will have integer value 2
                case 3: System.out.println("D"); break;         // Increments twice again and misses this
                case 4: System.out.println("E");                // Hits this and since no break, also prints f
                case 'E' : System.out.println("F");
            }
        }
    }

    private static void incrementingAChar() {
        System.out.println('a' == 97); // true

        char a = 'a';
        char b = 97;
        int c = 97;
        System.out.println(a == b); // true
        System.out.println(a == c); // true
        System.out.println(b == c); // true

        System.out.println(++a == ++b); // true
        System.out.println(a == ++c);   // true

    }

    private static void ambiguousCharExample() {
        // Observe carefully - 'a' and 97 are the same value!
        // This switch will not compile with the following 2 options.
        // You will get a duplicate label 'a' compilation error!
        char c = 97;
        switch(c){
            case 'a': System.out.println("A"); break; // Prints A
            //case 97: System.out.println("B"); break;    // 97 is 'a' so you get duplicate label
        }

        int i = 97;
        switch(i){
            case 'a': System.out.println("I'm actually printed!"); break; // This is printed!
            // case 97: System.out.println("B"); break; // Also duplicate label
        }
    }

    private static void assigningCharAVeryLargeInt() {
        char c = 65535; // capcity of a char is 65535
        // char d = 65536; // Won't compile - Required char, found int
        System.out.println((int)++c); // 0 - loop back to the start again!
        System.out.println((int)++c); // 1
        System.out.println((int)--c); // 0
        System.out.println((int)--c); // 65535
    }
}
