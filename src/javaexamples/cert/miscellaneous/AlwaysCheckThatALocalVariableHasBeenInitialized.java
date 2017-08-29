package javaexamples.cert.miscellaneous;

// Check, check again that a local variable has absolutely, 100% been initialized. Look for trick if/else-if statements
// that mean there is a path where the variable would not have been initialized.
public class AlwaysCheckThatALocalVariableHasBeenInitialized {

    public static void main(String... args) {
        exampleA();
        exampleB();
    }

    private static void exampleA() {
        double price = 10;
        String model;
        if (price > 10)
            model = "Smartphone";
        else if (price <= 10)       // --> WATCH FOR THIS - this conditional logic won't guarantee model will be initialized!
            model = "landline";

        // System.out.println(model); // --> Compilation error
    }

    private static void exampleB() {
        double price = 10;
        String model;
        if (price > 10)
            model = "Smartphone";

        if (price <= 10)       // --> WATCH FOR THIS - there are various forms for when a local variable will not be initialized!
            model = "landline";

        // System.out.println(model); // --> Compilation error
    }
}
