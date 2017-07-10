package javaexamples.cert.operators;

public class DecrementIncrementExamples {

    public static void main(String[] args){
        intro();
        example1();
        example2();
        example3();
        example4();
        example5();
    }

    // Note that in the following expressions, when you see an a++,
    // the value taken at that point will be a, but it is post-incremented
    // immediately after the value is taken, so in i = a++ + a++ when a is 5,
    // the first a++ will return 5, but in the second part + a++, a will be 6,
    // so it will be 5 + 6 giving 11, and a will be 7
    private static void intro() {
        int a=5, i;

        i=a++ + a++;
        System.out.println(a + " " + i); // 7 11
    }

    private static void example1() {
        int plan = 1;
        plan = plan++ + --plan; // 2
        if(plan == 1){
            System.out.println("Plan A");
        }else {
            if (plan == 2) System.out.println("Plan B");
            else System.out.println("Plan C");
        }
    }

    private static void example2() {
        int a=5, i;

        i=++a + ++a + a++;
        // ++a(5) = 6
        // 6 + ++a(6) = 6 + 7 = 13
        // 13 + a(++) = 13 + 7(post-increment) = 20
        // a++(7) = 8
        System.out.println(a + " " + i); // 8 20
    }

    private static void example3() {
        int a=5, i;

        i=a++ + ++a + ++a;
        // a++ = 5(post-increment)
        // 5 + ++a(6) = 5 + 7 (Note that the post-increment is applied now) = 12
        // 11 + ++a(7) = 12 + 8 = 20
        // a = 8
        System.out.println(a + " " + i); // 8 20
        // i=5 + 7 + 8; (a=8)
    }

    private static void example4() {
        int a=5;

        a=++a + ++a + a++;
        // ++a + ++a = 6 + 7 = 13
        // 13 + a++(7) = 20
        System.out.println(a); // 20
    }

    // Expressions are evaluated left to right. Parentheses just express grouping, they don't express ordering of evaluation.
    private static void example5() {
        int a = 10;
        a = ++a * ( ++a + 5); // 11 * (12 + 5)
        System.out.println(a); //187
    }
}
