package javaexamples.cert.assignments;


// Rules from JLS for an assignment of this type would be:
//    1 Evaluate Left-Hand Operand First
//    2 Evaluate Operands before Operation
//    3 Evaluation Respects Parentheses and Precedence
//    4 Argument Lists are Evaluated Left-to-Right
// Note: Operators are special tokens that represent computations like addition, multiplication and division.
//       The values the operator works on are called operands.
public class ChainedAssignmentExample {

    public static void main(String[] args){
        int i = 0;
        int[] iA = { 10, 20 };
        iA[i] = i = 30;

        //    1 Evaluate Left-Hand Operand First                - iA[i] is iA[0]
        //    2 Evaluate Operands before Operation              - i = 30
        //    3 Evaluation Respects Parentheses and Precedence  - N/A in  this case
        //    4 Argument Lists are Evaluated Left-to-Right      = iA[0] = 30

        System.out.println(iA[0]); // 30

        i = 0;
        iA[i] = i = iA[1] = 90;
        //    1 Evaluate Left-Hand Operand First                - iA[i] is iA[0]
        //    2 Evaluate Operands before Operation              - iA[1] = 90, then i = iA[1], so i equals 90
        //    3 Evaluation Respects Parentheses and Precedence  - N/A in  this case
        //    4 Argument Lists are Evaluated Left-to-Right      = iA[0] = 90

        System.out.println(iA[0]); // 90

        i = 0;
        int j = 10;
        int k = 20;
        int l = i = j = k;
        //    1 Evaluate Left-Hand Operand First                - not an array, so ready for assignment
        //    2 Evaluate Operands before Operation              - j = k, j = 20 ; i = j, i = 20
        //    3 Evaluation Respects Parentheses and Precedence  - N/A in  this case
        //    4 Argument Lists are Evaluated Left-to-Right      = l = i, so l equals 20

        System.out.println(l); // 20
    }
}
