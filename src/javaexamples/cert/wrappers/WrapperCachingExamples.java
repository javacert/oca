package javaexamples.cert.wrappers;

// Wrapper classes Byte, Short, Integer, and Long cache objects with values in the range of -128 to 127.
// The Character class caches objects with values 0 to 127.
// Wrapper classes Float and Double don’t cache objects for any range of values.
// In the case of the Boolean class, the cached instances are accessible directly because only two exist: static constants Boolean.TRUE and Boolean.FALSE.
public class WrapperCachingExamples {

    public static void main(String[] args){
        integerCachingExample();
        characterCachingExample();
        booleanCachingExample();
    }

    // Rules to consider:
    // 1) Constructors always create new instances.
    // 2) valueOf returns a cached copy for int values between -128 and 127.
    // 3) Autoboxing returns a cached copy for applicable values.
    private static void integerCachingExample() {
        Integer a = new Integer(127);
        Integer b = new Integer(127);

        System.out.println(a == b); // false - reference comparison

        Integer c = 127; // calls valueOf so will cache
        Integer d = 127; // calls valueOf so will cache

        System.out.println(c == d); // true - cached so comparing the same reference to the same object for auto-boxed int primitive

        Integer e = new Integer(200);
        Integer f = new Integer(200);

        System.out.println(e == f); // false - reference comparison

        Integer g = 200; // calls valueOf so will cache
        Integer h = 200; // calls valueOf so will cache

        System.out.println(g == h); // false - above 127, so these are not cached!

        // Caching implementation is Integer
        //public static Integer valueOf(int i) {
        //    if (i >= IntegerCache.low && i <= IntegerCache.high)
        //        return IntegerCache.cache[i + (-IntegerCache.low)];
        //    return new Integer(i);
        //}

        Integer i = Integer.valueOf("1");
        Integer j = Integer.valueOf("1");
        System.out.println(i == j); // true - valueOf uses caching as shown above.

        System.out.println();
    }

    private static void characterCachingExample() {

        Character a = new Character('a'); // 'a' is 97
        Character b = new Character('a');

        System.out.println(a == b); // false - reference comparison since constructor always creates new objects

        Character c = 97;
        Character d = 97;

        System.out.println(c == d); // true - cached so comparing the same reference to the same object for auto-boxed char primitive

        Character e = 200;
        Character f = 200;

        System.out.println(e == f); // false - above 127, so these are not cached!

        Character g = Character.valueOf('1'); // '1' is 49
        Character h = Character.valueOf('1');
        System.out.println(g == h); // true - valueOf uses caching as shown above.

        System.out.println();
    }

    private static void booleanCachingExample() {

        Boolean a = new Boolean("some random string"); // returns false
        Boolean b = new Boolean("some random string"); // returns false

        System.out.println(a == b); // false

        Boolean c = Boolean.TRUE;
        Boolean d = Boolean.TRUE;

        System.out.println(c == d); // true

        Boolean e = Boolean.FALSE;
        Boolean f = Boolean.FALSE;

        System.out.println(e == f); // true

        Boolean g = new Boolean("true"); // returns true - constructor always returns new object
        Boolean h = new Boolean("true"); // returns true - constructor always returns new object

        System.out.println(g == h); // false

        Boolean i = true; // valueOf
        Boolean j = true; // valueOf

        System.out.println(i == j); // true

        Boolean k = false; // valueOf
        Boolean l = false; // valueOf

        System.out.println(k == l); // true
    }
}
