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


// Wrapper Assignment Rules:
// 1) Direct assignment (e.g. Float f = 10F;) must use the correct type when assigning but byte/short/char can be
//    assigned an int value (implicit narrowing e.g. Byte b = 10;) is fine.
// 2) All wrapper classes have a single parameter constructor which accepts a String representation of the value
//    (excluding Character which only accepts a char)
// 3) When using a wrapper constructor, you must pass the correct type or a type that will widen to fit.
//    e.g. Short s1 = new Short((byte)10); is fine, so is Double d7 = new Double(10L);

public class CommonWrapperMethodExamples {

    public static void main(String[] args){

        constructorExample();
        basicWrapperExamples();
        numericWrapperInheritValueMethodFromNumber();
        moreExamples();
        assignmentToPrimitives();
        assignmentThroughConstructors();
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

    private static void assignmentToPrimitives() {

        // Remember these rules:
        // 1) Widening and then Boxing (WB) not allowed.

        Byte b = 10;
        Character c = 10;
        Short s = 10;
        Integer i = 10;

        // Long l = 10; // Cannot do!
        Long l = 10L;

        // Float f = 10; // Cannot do!
        Float f = 10F;

        // Double d = 10; // Cannot do!
        Double d = 10.0;

        // 2) Unboxing and then Widening (BW) allowed.
        Integer i2 = 10;
        double d2 = i2;
        double d3 = new Integer(10);

        // 3) Widening between wrapper classes not allowed
        Integer intToWiden = 10;
        // Double someDouble = intToWiden; // Will not compile!
    }

    private static void assignmentThroughConstructors() {

        // Boolean b1 = new Boolean(); // No zero arg constructor
        Boolean b1 = new Boolean("True");
        Boolean b2 = new Boolean(Boolean.TRUE);
        Boolean b3 = Boolean.TRUE;

        // Character c1 = new Character(); // No zero arg constructor
        Character c1 = new Character((char)10);
        Character c2 = new Character((char)(byte)10);
        // Character c3 = new Character((short)10); // Will not compile
        Character c4 = new Character('a');
        // Character c5 = new Character("a"); // // No constructor which accepts a string

        // Byte by1 = new Byte(); // No zero arg constructor
        Byte by1 = new Byte((byte)10);
        Byte by2 = new Byte("10");

        // Short s1 = new Short(); // No zero arg constructor
        Short s1 = new Short((byte)10); // This works!
        //Short s1 = new Short((Byte)10); // Does not compile
        Short s2 = new Short((short)10); // This works!
        // Short s2 = new Short((int)10); // Does not compile
        Short s3 = new Short("10");

        // Integer i1 = new Integer(); // No zero arg constructor
        Integer i1 = new Integer((byte)10);
        Integer i2 = new Integer((byte)10);
        Integer i3 = new Integer((short)10);
        Integer i4 = new Integer(10);
        Integer i5 = new Integer("10");

        // Long l1 = new Long(); // No zero arg constructor
        Long l1 = new Long((byte)10);
        Long l2 = new Long((byte)10);
        Long l3 = new Long((short)10);
        Long l4 = new Long((int)10);
        Long l5 = new Long(10);
        Long l6 = new Long((long)10);
        Long l7 = new Long(10L);
        Long l8 = new Long("10");

        // Float f1 = new Float(); // No zero arg constructor
        Float f1 = new Float((byte)10);
        Float f2 = new Float((byte)10);
        Float f3 = new Float((short)10);
        Float f4 = new Float((int)10);
        Float f5 = new Float(10);
        Float f6 = new Float((long)10);
        Float f7 = new Float(10L);
        Float f8 = new Float(10F);
        Float f9 = new Float("10");

        // Double d1 = new Double(); // No zero arg constructor
        Double d1 = new Double((byte)10);
        Double d2 = new Double((byte)10);
        Double d3 = new Double((short)10);
        Double d4 = new Double((int)10);
        Double d5 = new Double(10);
        Double d6 = new Double((long)10);
        Double d7 = new Double(10L);
        Double d8 = new Double(10F);
        Double d9 = new Double(10.0);
        Double d10 = new Double("10");
        Double d11 = new Double("10.0");
    }
}
