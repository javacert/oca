package javaexamples.cert.miscellaneous;

// When working with complex examples such as these remember these rules:
// 1) Evaluate left to right in all cases
// 2) Any thing in parenthesis is evaluated as one
// 3) * and / are calculated together - try and add the parenthesis to help with calculations - see example6
public class ComplexReassignmentStatementsExample {

    public static void main(String[] args){
        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
        example7();
    }

    private static void example1() {
        int k = 1;
        k += 3 + ++k;
        // 1) k = k + 3 + ++k;
        // 2) k = 1 + 3 + (++k) i.e.
        // 3) k = 1 + 3 + 2; (at this point value of k is 2 because of ++k). But the value of Right Hand Side has not yet been assigned to k.
        // k = 6; 6 is assigned to k thereby overwriting the value of 2.
        System.out.println(k); // 6
    }

    private static void example2() {
        int k = 1;
        System.out.println(++k + k); // 2 + 2 = 4
        k = 1;
        System.out.println(++k + k + --k); //  2 + 2 + 1 = 5
        k = 1;
        k += 3 + ++k + k + --k + k;
        // 1) k = k + 3 + ++k + k + --k + k;
        // 2) k = 1 + 3 + (++k) + k + (--k) + k
        // 3) k = 1 + 3 + 2 + 2 + 1 + 1;
        System.out.println(k); // 10
    }

    // We always evaluate left to right
    private static void example3() {
        int k = 1;
        k += 3 + (++k * 2) - (k-- + 2);
        // 1) k = k + 3 + (++k * 2) - (k-- + 2)
        // 2) k = 1 + 3 + (2 * 2) - (2 + 2)
        // 3) k = 1 + 3 + 4 - 4;
        System.out.println(k); // 4
    }

    private static void example4() {
        int k = 1;
        k += 3 + (++k * 2) + (k++ + 2);
        // 1) k = k + 3 + (++k * 2) + (k++ + 2)
        // 2) k = 1 + 3 + (2 * 2) + (2 + 2)
        // 3) k = 1 + 3 + 4 - 4;
        System.out.println(k); // 12
    }

    private static void example5() {
        int k = 1;
        k += 3 + (++k * 2) + (k++ + 2) + (++k * 3);
        // 1) k = k + 3 + (++k * 2) + (k++ + 2) + (++k * 3)
        // 2) k = 1 + 3 + (2 * 2) + (2 + 2) + (4 * 3)
        // 3) k = 1 + 3 + 4 + 4 + 12;
        System.out.println(k); // 24
    }

    private static void example6() {
        int k = 1;
        k += 3 + ++k * 3 + ++k * 3; // * takes precedence
        // 1) k = k + 3 + (++k * 3) + (++k * 3)
        // 2) k = 1 + 3 + (2 * 3) + (3 * 3)
        // 3) k = 1 + 3 + 6 + 9;
        System.out.println(k); // 19
    }

    private static void example7() {
        int a = 10;
        int b = 20;
        a += (a = 4); // a = a + (a = 4) --> 10 + 4
        b = b + (b = 5); // 20 + (5)
        System.out.println(a + ", " + b); // 14, 25
    }
}
