package javaexamples.cert.miscellaneous;

// Rules:
// The left operand of instanceof MUST be an object and not a primitive.
// Right operand of instanceof MUST be a class name.
// Notice that with instanceof a primitive is NOT autoboxed into Short
public class InstanceOfExamples {
    public static void main(String[] args) {
        short s = 9;
        //System.out.println(s instanceof Short); // Inconvertible types, cannot cast short to Short
    }
}
