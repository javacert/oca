package javaexamples.cert.wrappers;

// When you create an Integer using the new keyword, it creates a new Integer every time.
// However, Integer caches values between -128 and 127.
public class IntegerExamples {

    public static void main(String[] args){
        workingWithNullIntegerWrapper();
        passingNullToAMethodWithAnIntegerWrapper(null);
        usingEqualsWithDifferentWrapperClasses();
        parsingADoubleValue();
    }

    private static void workingWithNullIntegerWrapper() {
        Integer imNull = null;
        imNull++; // java.lang.NullPointerException
        imNull--; // java.lang.NullPointerException
    }

    private static int passingNullToAMethodWithAnIntegerWrapper(Integer someInteger) {
        return someInteger++; // java.lang.NullPointerException when someInteger is null

        // Why?
        // Because the Java compiler would call obj.intValue() to get object's int value, passing
        // null to the increment() method will throw a NullPointerException
    }

    // You can’t compare wrapper instances for equality using equals() or ==, if they are not of the same class
    private static void usingEqualsWithDifferentWrapperClasses() {
        Integer a = new Integer(100);
        Integer b = new Integer(100);

        System.out.println(a.equals(b)); // true

        Short c = new Short((short)100); // Remember the cast!
        System.out.println(c.equals(b)); // false
        System.out.println(a.equals(c)); // false

        // System.out.println((a == c)); // cannot compare since different objects


        //public boolean equals(Object obj) {
        //    if (obj instanceof Short) {
        //        return value == ((Short)obj).shortValue();
        //    }
        //    return false;
        //}
    }

    private static void parsingADoubleValue() {
        System.out.println(Integer.parseInt("12.3")); // java.lang.NumberFormatException: For input string: "12.3"
        System.out.println(Double.parseDouble("12.3")); // 12.3
    }
}
