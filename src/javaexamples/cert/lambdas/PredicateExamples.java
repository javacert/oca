package javaexamples.cert.lambdas;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateExamples {

    public static void main(String[] args){
        basicFormatOfPredicates();
    }

    private static void basicFormatOfPredicates() {
        Predicate<StringBuilder> p1 = (StringBuilder b) -> {return true;};
        Predicate<StringBuilder> p2 = (StringBuilder b) -> true;
        Predicate<StringBuilder> p3 = b -> true;
        Predicate<StringBuilder> p4 = (b) -> true;
        Predicate<StringBuilder> p5 = (b) -> {return b.substring(2).contains("abc");};
        Predicate<StringBuilder> p6 = (b) -> {return true;};

        // Supplier does not take an incoming parameter
        Supplier<Integer> s1 = () -> {return 5;};
        Supplier<Integer> s2 = () -> 5;
    }
}
