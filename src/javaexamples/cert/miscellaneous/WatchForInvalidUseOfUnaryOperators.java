package javaexamples.cert.miscellaneous;

import java.util.function.Predicate;

// Watch carefully for use of unary operators such as !
public class WatchForInvalidUseOfUnaryOperators {

    public static void main(String... args) {
        int a = 0;
        int b = 100;
        Predicate<Integer> compare = (var) -> var++ == 10; // This is valid

        // This is not valid !b++ --> You are actually applying the ! to the int b. Valid expression would be !(b++ > 100)
        //if (!b++ > 100 && compare.test(a)) {
        if (!(b++ > 100) && compare.test(a)) {
            System.out.println(a+b);
        }
    }
}
