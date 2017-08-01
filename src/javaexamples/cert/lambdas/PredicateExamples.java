package javaexamples.cert.lambdas;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateExamples {

    public static void main(String[] args){
        basicFormatOfPredicates();
        trickyPredicateExampleA();
        trickyPredicateExampleB();
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

    private static void trickyPredicateExampleA() {
        // Does not compile because c would be an Object
        //Predicate dash = c -> c.startsWith("-");

        // We can access the .equals method in Object
        Predicate dashA = c -> c.equals(null);

        // Or set the generic type of Predicate to String
        Predicate<String> dashB = c -> c.equals("-");
        System.out.println(dashB.test("-")); // true
    }

    private static void trickyPredicateExampleB() {
        // The Predicate here is of type Object, so we use the Object equals method which compares references
        // In the following case the Strings are different so we get false.
        Predicate clear = c -> c.equals("white");
        System.out.println(clear.test("green")); // false

        // But what about when they are the same in the String Pool?
        // The thing you NEED to remember here is that equals is Overridden in String class, so equals in String class
        // will be called and NOT equals in Object!
        clear = c -> c.equals("white");
        System.out.println(clear.test("white")); // true

        // And when we use new String (so not interned)?
        // Again we call equals in String class and compare the content - it is not a reference comparison!
        clear = c -> c.equals("white");
        System.out.println(clear.test(new String("white"))); // true

        // Not we are doing String intern comparisons - this is comparing references on the String Pool
        clear = c -> c == "white";
        System.out.println(clear.test("white")); // true

        // False as you would expect since new String not on String Pool
        clear = c -> c == "white";
        System.out.println(clear.test(new String("white"))); // false
    }
}
