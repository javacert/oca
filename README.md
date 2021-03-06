# oca
Examples for the OCA Certification

General Tips:

- Watch for missing imports when the first shows line numbers and they start with 1
- Check where variable is defined and whether it is in scope
- Watch for key words used in naming things (e.g. switch as a class name)
- GC - watch for incoming object reference parameters and remember the caller still has a reference to that object.
- GC - primitives though are copies, but cannot be set to null so go out of scope when the method returns
- Watch for questions on Cohesion vs Coupling
    --> Cohesion measures the strength of relationship between pieces of functionality within a given module.
        For example, in highly cohesive systems functionality is strongly related.
        Low cohesion would mean that the class does a great variety of things but is not focused on what it should do.
    --> Coupling - how much change in one class would bring about a change in another class. Watch for access modifier
        and composition - reliance on another class which have not been declared private, not using an interface.
    --> High cohesion and Loose coupling are good design.
- static and instance class member variables get initialized with reasonable default values as determined by the compiler.
- Method local variables need to be initialized before using them.
- The signature of a method is used to uniquely identify a method - it consists of:
    --> Method Name
    --> Number of parameters
    --> Type of Parameters
    --> Order of the parameters
- Return types and thrown exceptions are not considered to be a part of the method signature.
- Java Math package exists in java.lang.Math
- Precedence Rules (highest to lowest precedence):
    --> Post-unary operators: expression++, expression--
    --> Pre-unary operators: ++expression, --expression
    --> Other unary operators: +, -, !
    --> Multiplication/Division/Modulas: *, /, %
    --> Addition/Subtraction: +, -
    --> Shift Operators: <<, >>, >>>
    --> Relational Operators: <, >, <=, >=
    --> Equal to, not equal to: ==, !=
    --> Logical Operators: &, ^, |
    --> Short-circuit logical operators: &&, ||
    --> Ternary operators: something ? true : false ;
    --> Assignment operators: =, +=, -=, *=, /+, %=, &=, ^=, !=, <<=, >>=, >>>=
- Default package is not really a package, so not every class has to belong to a package.
- Which packages are automatically imported? java.lang & The package with no name (default) (contrary to above statement).
- Always check that a wrapper object has been initialized before being operated on (++ or -- etc) as it will throw a runtime exception.
- Member variables refer to class variables.
- Watch out in loops for continue or break and possible unreachable statements.
- Watch for out of alignment if/else statements so that it looks as though the else applies to another if/else block.
- Using an interface is always more appropriate if it can be used because it allows the class to extend another class when needed.
- Remember when you are given a file name, e.g. "in file Test.java", then if you have a public class definition it must have the same name!
- Always check constructors are actually constructors (look for return types)
- For methods that have a start and end index e.g. substring - The same pattern is used for almost all other methods in standard java 
    library classes. The first index is included but the last one is not. (In some cases we will have length, and so output should
    always match the length parameter (StringBuilder append(char[], start, length), insert(index, char[], offset, length)))
- Take extra care when determining reference assignments. Think is-a relationship. If b is-a a and so b extends a, then you can assign
    b to a reference variable of either a or b.
- State vs Type:
    1) Interfaces, classes, and enums are all "types". Java allows a class to implement multiple interfaces. 
       In this way, Java supports multiple inheritance of types.
    2) "State", on the other hand, is represented by instance fields. 
       Only a class can have instance fields and therefore, only a class can have a state.
       Interfaces are always implicitly static, even if you don't specify the keyword static explicitly. Therefore, an interface does not have any state.
    3) Java allows a class to implement multiple interfaces. An interface is a "type" and does not contain any state. 
       This implies that Java supports multiple type inheritance.
       A class contains state and extending a class means inheriting the state. 
       Since Java does not allow a class to extend from multiple classes, it means that Java does not support multiple state inheritance.
    --> This means the following 2 statements are true:
    1) Multiple inheritance of state includes ability to inherit instance fields from multiple classes.
    2) Multiple inheritance of type includes ability to implement multiple interfaces and/or ability to extend from multiple classes.
    3) Java supports multiple type inheritance but not multiple state inheritance.
    4) If you see a class implementing 2 or more interfaces, then assume this illustrates Java's support for multiple inheritance of type.
- Widening conversions are:
    1) From a byte to a short, an int, a long, a float, or a double
    2) From a short to an int, a long, a float, or a double
    3) From a char to an int, a long, a float, or a double
    4) From an int to a long, a float, or a double
    5) From a long to a float or a double
    6) From a float to a double
- Type Promotion Rules:
    1) All byte and short values are promoted to int.
    2) If one operand is a long, the whole expression is promoted to long.
    3) If one operand is a float, the entire expression is promoted to float.
    4) If any of the operands is double, the result is double.
- There no unsigned keyword in java. A char can be used as an unsigned integer if required.
- Don't be thrown by continue statements at the end on a loop block since they will be redundant.
- The restrictiveness of access modifiers is as follows: private>default>protected>public
- Boolean class does not have a no-args constructor.
- Always watch for scope of variables no matter what the question appears to be about!
- Watch for GC questions - remember that the exact number of objects GC'd will never be known for certain (look for eligible wording).
- ALWAYS ALWAYS ALWAYS check constructors for return types.
- All keywords in Java are lowercase (instanceof).
- The java command uses . to separate packages.
- Java SUPPORTS functional programming.
- Always check date classes that they do not contain the form - new LocalDate(2017, 1, 1) - remember their constructors are private
- Only byte code is platform independent in Java. The JRE, JVM, JDK are all platform dependent.
- Always remember that 2 static methods with the same name and signature in a parent and child class, is not overriding but hiding.
  You can access both depending on the reference type.
- 5 Golden Rules of widening, boxing and varargs:
    1) Primitive Widening > Boxing > Varargs. - significant when overloading! 
    2) Widening and Boxing (WB) not allowed. Example:
            // Long l = 10; // Cannot do! Need widened and then boxed
            Long l = 10L;
    3) Unboxing and then Widening (BW) allowed. Example:
            Integer i2 = 10;
            double d2 = i2;
            double d3 = new Integer(10); // Fine!
    4) While overloading, Widening + vararg and Boxing + vararg can only be used in a mutually exclusive manner i.e. not together.
    5) Widening between wrapper classes not allowed. Example:
            Integer intToWiden = 10;
            // Double someDouble = intToWiden; // Not allowed.
- There are 19 specific conversions on primitive types called the widening primitive conversions:
    1) byte to short, int, long, float or double
    2) short to int, long, float or double
    3) char to int, float, long or double
    3) int to long, float or double
    4) long to float or double
    5) float to double
- Remember that String and date time objects are immutable. Look for application of change without an assignment to a variable!
- Remember that a static method in a class hierarchy will conflict with instance methods in the hierarchy with the same name and signature.
  However it will NOT conflict with static methods from an interface, since they can only be accessed through the Interface name itself.
- None of the new date related classes have public constructors. Watch out for use of the new keyword always.
- final only means that subclasses cannot hide (in case of static methods, and static or non-static fields) or override (in case of instance methods) that method.
- Exceptions is a mechanism (vague statement examples):
    1) That you can use to determine what to do when something unexpected happens.
    2) Once you catch an exception, you can log the details.
- Any exception thrown in a static block is wrapped into ExceptionInInitializerError and then that ExceptionInInitializerError is thrown.
- All sub-classes of Throwable are checked except sub-classes of Error and RuntimeException.
- Period / Duration have static methods and therefore do not support aggregated chaining.
- Most of the methods of LocalDate (as well as LocalTime and LocalDateTime) return an object of the same class.
  This allows you to chain the calls as done in this question. However, these  methods return a new object each time
  but aggregate the change from the previous method in the chain. Period / Duration will simply use the last change in the chain.
- The native keyword can only be used on methods, not on classes and instance variables.
- A subclass is free to have a static or instance method with the same signature as that of a private instance or static method of a super class.