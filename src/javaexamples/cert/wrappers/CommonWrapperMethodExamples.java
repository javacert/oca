package javaexamples.cert.wrappers;

// Remember that wrapper classes for primitives (java.lang.Boolean, java.lang.Integer, java.lang.Long,
// java.lang.Short etc.) are final and so they cannot be extended.
// java.lang.Number, is not final. Integer, Long, Double etc. extend Number.
// java.lang.System is final
// Watch out for null wrapper references with ++ or -- etc - throw RuntimeException

// Wrapper Creation:
// You can create objects of all the wrapper classes in multiple ways:
//      1) Assignment - By assigning a primitive to a wrapper class variable (autoboxing)
//      2) Constructor - By using wrapper class constructors
//      3) Static methods - By calling static method of wrapper classes, like, valueOf()

// All wrapper classes (except Character) define a constructor that accepts a String argument representing the
// primitive value that needs to be wrapped. Watch out for exam questions that include a call to a no-argument
// constructor of a wrapper class. None of these classes define a no-argument constructor

// All six numeric wrapper classes inherit all six ***Value() methods from their common superclass, Number.

// All parse methods (e.g. Byte.parseByte) throw NumberFormatException except Boolean.parseBoolean().
// This method returns false whenever the string it parses is not equal to "true" (case-insensitive comparison).
// Character does NOT have a parse method.

// The valueOf() method returns an object of the corresponding wrapper class when it's passed an argument of a primitive type or String
// valueOf is used as part of the boxing process, while intValue()/doubleValue() is used as part of the unboxing process during runtime.

// Wrapper classes are immutable. Adding a primitive value to a wrapper class variable doesn’t modify the value of the
// object it refers to. The wrapper class variable is assigned a new object.
public class CommonWrapperMethodExamples {

    public static void main(String[] args){

        constructorExample();
        basicWrapperExamples();
        numericWrapperInheritValueMethodFromNumber();
        moreExamples();
    }

    private static void constructorExample() {
        // Note the following constructor which accepts a string representation (except Character)
        // Character char = new Character("a"); // --> Does not compile.
        Boolean bool1 = new Boolean("true");
        Byte byte1 = new Byte("10");
        Double double1 = new Double("10.98");
    }

    private static void basicWrapperExamples() {

        // valueOf will return a wrapper object from a primitive
        int myPrimInt = Integer.valueOf(5); // Compiler shows an error with unnecessary boxing
        // myPrimInt = Integer.valueOf(5L); // Doesn't compile for long
        myPrimInt = Integer.valueOf("5");
        System.out.println(myPrimInt++); // Prints 5
        System.out.println(myPrimInt); // Prints 6
        System.out.println(++myPrimInt); // Prints 7
        Integer myIntegerWrapper = Integer.valueOf(5); // Compiler shows an error with unnecessary boxing

        System.out.println(Integer.parseInt("123ABCD", 16)); // 19114957 - parseInt(String s, int radix)
        System.out.println(Integer.parseInt("123_45")); // java.lang.NumberFormatException: For input string: "123_45"

        // Character.valueOf("C");
        Character.valueOf('C');
        Double double1 = Double.valueOf(10);
        Double double2 = Double.valueOf(10.0);
        Double double3 = Double.valueOf(3L);
        // Integer integer1 = Integer.valueOf(3L); --> Does not compile

        // Character.parseChar() --> Does NOT EXIST.

        // parseInt will parse the String into a primitive int
        Integer myWrappedInt = Integer.parseInt("7"); // Compiles fine, but value is boxed to an Integer
        int myPrimInt2 = Integer.parseInt("7"); // Compiles fine, no need for the boxing feature!!

        Boolean b = Boolean.valueOf(true); // Creates a boolean wrapper without autoboxing
        b = Boolean.parseBoolean("yes"); // Yes is not valid
        System.out.println(b); // false
        b = Boolean.parseBoolean("true"); // Returns a boolean primitive (autoboxing required for assignment)
        System.out.println(b); // true
        b = Boolean.getBoolean("FALSE"); // Returns a boolean primitive (autoboxing required for assignment)
        System.out.println(b); // false

        int someUnboxedInt = Integer.valueOf(6); // valueOf returns an Integer Object and then it is unboxed
        int somePrimitiveReturn = Integer.parseInt("6"); // parseInt returns primitive int, so no unboxing required.
    }

    private static void numericWrapperInheritValueMethodFromNumber() {
        Integer someInteger = new Integer(10);        // 10
        System.out.println(someInteger.byteValue());        // 10.0
        System.out.println(someInteger.doubleValue());      // 10
        System.out.println(someInteger.longValue());        // 10
        System.out.println(someInteger.intValue());         // 10
        System.out.println(someInteger.shortValue());       // 10
        System.out.println(someInteger.floatValue());       // 10.0
    }

    private static void moreExamples() {
        int i1 = Integer.parseInt("1"); // returns primitive
        boolean b1 = Boolean.parseBoolean("TruE");
        System.out.println(i1 + " " + b1); // 1 true

        int i2 = Integer.valueOf("2"); // returns wrapper
        boolean b2 = Boolean.valueOf("False");
        System.out.println(i2 + " " + b2); // 1 false
    }
}
