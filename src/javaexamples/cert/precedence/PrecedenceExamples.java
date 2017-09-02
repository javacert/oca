package javaexamples.cert.precedence;

// Rules:
// Precedence Rules (highest to lowest precedence):
//        --> Post-unary operators: expression++, expression--
//        --> Pre-unary operators: ++expression, --expression
//        --> Other unary operators: +, -, !
//        --> Multiplication/Division/Modulas: *, /, %
//        --> Addition/Subtraction: +, -
//        --> Shift Operators: <<, >>, >>>
//        --> Relational Operators: <, >, <=, >=
//        --> Equal to, not equal to: ==, !=
//        --> Logical Operators: &, ^, |
//        --> Short-circuit logical operators: &&, ||
//        --> Ternary operators: something ? true : false ;
//        --> Assignment operators: =, +=, -=, *=, /+, %=, &=, ^=, !=, <<=, >>=, >>>=

// So remember that + * have a higher precedence than a ternary
public class PrecedenceExamples {

    public static void main(String[] args){
        precedenceExampleA();
        precedenceExampleB();
        precedenceExampleC();
    }

    private static void precedenceExampleA() {
        int fish = 1 + 2 * 5 >= 2 ? 4 : 2; // 4 : (1 + 2 * 5) >= 2 ? 4 : 2
        int mammals = 3 < 3 ? 1 : 5 >= 5 ? 9 : 7; // 9
        System.out.println(fish + mammals); // 13
    }

    private static void precedenceExampleB() {
        boolean b1 = false;
        boolean b2 = false;
        // In this example since != and == has higher precedence than =, b1 != b2 is evaluated first, which is false
        // Then b2 = false, so it will print false
        if (b2 = b1 != b2) {
            System.out.println("true");
        } else {
            System.out.println("false"); // Prints false
        }
    }

    private static void precedenceExampleC() {
        boolean b1 = true;
        boolean b2 = false;
        // In this example since != and == has higher precedence than =, b1 != b2 is evaluated first, which is true
        // Then b2 = false, so it will print false
        if (b2 = b1 != b2) {
            System.out.println("true"); // Prints true
        } else {
            System.out.println("false");
        }
    }
}
