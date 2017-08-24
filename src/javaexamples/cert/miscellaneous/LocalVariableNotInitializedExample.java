package javaexamples.cert.miscellaneous;

import java.util.ArrayList;

// This example shows something important. On line 11 we check if percent is < 10 and since percent is a final variable
// the compiler knows that this condition will always return true, and so the shadowed variables will always be
// initialized. If we remove the final, then the compiler won't know if they will always be initialized and will throw
// a compilation error.
public class LocalVariableNotInitializedExample {

    static final double percent = 0; // Remove the final here and we get a compilation error
    int offset = 10, base = 50;

    public static double calc(double value) {
        int coupon, offset, base;
        if (percent < 10) { // This must result in true always otherwise the variables might not be initialized!
            coupon = 15;
            offset = 20;
            base = 10;
        }
        return coupon * offset * base * value / 100;
    }

    public static void main(String[] args) {
        System.out.println(calc(100));
    }
}


// Watch out for code that tries to use an uninitialized local variable.
// Because such variables aren't initialized with even a null value, you can't print their value using the
// System.out.println method. Such code won't compile.
class VariablesAreNotInitializedInLocalScope {
    public static void main(String[] args) {
        ArrayList<String> list;
        //if (list!=null)      // --> This line won't compile - local variables are NOT assigned a value, not even null
        //    list.add("1");

        //System.out.println(list); // --> This line won't compile - local variables are NOT assigned a value, not even null

        int x;
        // System.out.println(x); // --> This line won't compile
    }
}