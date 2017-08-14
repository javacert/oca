package javaexamples.cert.miscellaneous;

// Using an instance variable before its declaration is called a forward reference. If an instance variable tries to
// forward reference another instance variable during initialization, the result in a compile-time error.

// The declaration of a member needs to appear textually before it is used only if the member is an instance
// (respectively static) field of a class or interface C and all of the following conditions hold:

// The usage occurs in an instance (respectively static) variable initializer of C or in an instance
// (respectively static) initializer of C.
//      --> The usage is not on the left hand side of an assignment.
//      --> The usage is via a simple name.
//      --> C is the innermost class or interface enclosing the usage.
//      --> If the declaration of a member does not precede a use of that member, and the above conditions are met,
//          a compile-time error occurs

// In a nutshell - What you cannot do though, is declare a class variable 'a' that depends on another class
// variable 'b' that has not been declared yet.
public class IllegalForwardReferenceExamples {


    static int testTheOrderBefore;
    static {
        testTheOrder = 1; // We can assign and use the static variable before its definition in the class - Rule 2
        testTheOrder = testTheOrderBefore;
        testTheStaticAssignment = 0;
        // testTheOrder = testTheStaticAssignment; // Illegal forward reference
    }
    static int testTheOrder;
    static int testTheStaticAssignment;

    // Rule 1: The usage occurs in an instance (respectively static) variable initializer of C or in an instance
    // (respectively static) initializer of C.
    //      --> Not here - these are static variables
    // Rule 2: The usage is not on the left hand side of an assignment.
    //      --> No. The testTheStaticAssignment is on the right hand side of an assignment and has not been declared yet.
    // Rule 3: The usage is via a simple name.
    //      --> Yes. "testTheOrder & testTheStaticAssignment;" are simple names.
    // Rule 4: C is the innermost class or interface enclosing the usage.
    //      --> Yes. The innermost class Program is enclosing this reference testTheStaticAssignment.

    {
        testTheInstanceAssignment = 1;
        testTheInstanceAssignment = testTheStaticAssignment;
        // testTheInstanceAssignment = testTheInstanceForwardRefAssignment; // Illegal forward reference
    }
    int testTheInstanceAssignment;
    int testTheInstanceForwardRefAssignment;


    // The following is fine when we are forward reference static variables for instance variables only.
    int _ = $;
    {
        int _ = $;
        // int _ = $_; // Illegal forward reference
    }
    static int $ = 2;
    int $_ = 5;
}
