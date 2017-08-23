package javaexamples.cert.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// This example shows that if you rethrow a checked exception, then you also need to declare that exception and
// surround the calling code in a try/catch.
public class RethrowCheckedExceptionExample {

    public static void main(String args[]) {
        // Now that openFile throws FileNotFoundException we must use a try/catch
        try {
            openFile();
        } catch (FileNotFoundException e) {
            System.out.println("I'm catching the exception!"); // This gets printed!
            e.printStackTrace();
        }
    }

    private static void openFile() throws FileNotFoundException { // You must declare a checked exception if you rethrow
        try {
            new FileInputStream("file.txt"); // Will throw a FileNotFoundException
        }
        catch (FileNotFoundException fnfe) {
            // Rethrow the caught checked exception.
            throw fnfe; // 'Unhandled Exception' without the throws declaration if you rethrow
        }
        System.out.println("I won't get printed"); // Not printed
    }
}
