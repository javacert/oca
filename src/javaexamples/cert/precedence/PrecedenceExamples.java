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
    }

    private static void precedenceExampleA() {
        int fish = 1 + 2 * 5 >= 2 ? 4 : 2; // 4 : (1 + 2 * 5) >= 2 ? 4 : 2
        int mammals = 3 < 3 ? 1 : 5 >= 5 ? 9 : 7; // 9
        System.out.println(fish + mammals); // 13
    }
}
