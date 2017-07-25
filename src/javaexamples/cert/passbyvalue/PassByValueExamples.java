package javaexamples.cert.passbyvalue;

// This example demonstrates Java's pass by value.
// Copies of primitives and object references are sent to methods.
// This means that an object's data can be modified within a method and shared with the caller,
// but NOT the reference to the object!
public class PassByValueExamples {

    private int somePrivateInt = 18;

    public static void main(String[] args){
        final PassByValueExamples passByValueExamples = new PassByValueExamples();
        passByValueExamples.somePrivateInt = 16;
        final int[] array = new int[1];
        final String name = "Peter";
        passByValue(passByValueExamples, array, name);

        System.out.println(passByValueExamples.somePrivateInt); // This is an object reference, so the object value is updated to 18
        System.out.println(array[0]);   // Remains as the default int value as 0
        System.out.println(name);       // Remains as "Peter"

        showThatArrayReferencesCanImpactTheOriginal(array);
        System.out.println(array[0]);   // The method call updates the array to 50
    }

    private static void passByValue(PassByValueExamples passByValueExamples, int[] array, String name){
        passByValueExamples.somePrivateInt = 18;
        name = "David";
        array = new int[1]; // Reference is updated here prior to modifying the array, so the original is untouched.
        array[0] = 11; // Remember though that int[] is an object and you could modify the original if you used the original reference
        passByValueExamples = null; // Since object references are copies, this does NOT impact the caller reference
    }

    private static void showThatArrayReferencesCanImpactTheOriginal(int[] array){
        array[0] = 50; // We are modifying the original object here
    }
}
