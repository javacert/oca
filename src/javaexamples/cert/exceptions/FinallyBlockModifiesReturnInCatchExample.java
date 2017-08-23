package javaexamples.cert.exceptions;

// This example shows what happens when finally attempts to modify an already set return value in the catch.
// Control in the catch block copies the value of returnVal to be returned before it executes the finally block,
// so the returned value is not modified when finally executes.

// Note in this example it is a primitive, but if working with an object reference we can still change the object
// contents. The reference value returned could not be changed though. Remember pass by value.
public class FinallyBlockModifiesReturnInCatchExample {

    public static void main(String args[]) {
        FinallyBlockModifiesReturnInCatchExample var = new FinallyBlockModifiesReturnInCatchExample();
        System.out.println("In Main:" + var.getInt()); // In Main:10
    }

    int getInt() {
        int returnVal = 10;
        try {
            String[] students = {"Harry", "Paul"};
            System.out.println(students[5]);
        } catch (Exception e) {
            System.out.println("About to return :" + returnVal);
            return returnVal; // We are returning, but finally is still to execute.
        } finally {
            returnVal += 10; // This won't affect the return value set in the catch!!!
            System.out.println("Return value is now :" + returnVal);
        }
        return returnVal;
    }
}