package javaexamples.cert.ternary;

// Rules:
// 1) It is not permitted for either the second or the third operand expression of the ? operator to be an invocation
//    of a void method.
// 2) If one of the operands is of type byte and the other is of type short, then the type of the conditional expression
//    is short.
// 3) If one of the operands is of type T where T is byte, short, or char, and the other operand is a constant expression of
//    type int whose value is representable in type T, then the type of the conditional expression is T. Otherwise, binary numeric
//    promotion (5.6.2) is applied to the operand types, and the type of the conditional expression is the promoted type
//    of the second and third operands.
// 4) If one of the second and third operands is of the null type and the type of the other is a reference type, then the
//    type of the conditional expression is that reference type.
// 5) If the second and third operands are of different reference types, then it must be possible to convert one of the
//    types to the other type (call this latter type T) by assignment conversion (5.2); the type of the conditional
//    expression is T. It is a compile-time error if neither type is assignment compatible with the other type.
// 6) Note that binary numeric promotion performs unboxing conversion (5.1.8) and value set conversion (5.1.13).
public class TernaryExamples {

    public static void main(String[] args){
        // The following won't compile since 10 is an int
        // String someString = true ? "Hello" : 10;

        // However ternary can return different types as shown here
        System.out.println(true ? "Hello" : 10); // Hello
        System.out.println(false ? "Hello" : 10); // 10

        // System.out.println(false ? someVoidMethod() : 10); // Will not compile since method returns void.

        //for (; ; ) {
        //    Math.random() < .05 ? break :continue; // --> break, continue not valid in this context since we expect a value.
        //}
    }

    static void someVoidMethod(){

    }
}
