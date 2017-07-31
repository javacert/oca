package javaexamples.cert.exceptions;

// This example demonstrates that you need to declare checked exceptions otherwise you will receive a compilation error.
public class IncorrectlyDeclaringNewCheckedExceptionExample {
    public static void main(String[] args) /* throws Exception */{
        try {
            System.out.println("A");
        } catch(RuntimeException e){
            System.out.println("A");
        } finally {
            // You cannot add the following line without adding 'throws Exception' to the method signature
            //throw new Exception("I'm a new Checked Exception!");
        }
    }
}
