package javaexamples.cert.exceptions;

import java.io.*;

public class ReturnStatementInCatchClauseExample {

    public static void main(String args[]) {
        openFile();
    }

    private static void openFile() {
        try {
            new FileInputStream("file.txt"); // Will throw a FileNotFoundException
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("file not found");
            return; // Observe the return statement here!
        }
        finally {
            System.out.println("finally"); // Even with the return statement, finally will always run!!!!
        }
        System.out.println("Next task.."); // Not hit since it returns after the finally runs.
    }
}
