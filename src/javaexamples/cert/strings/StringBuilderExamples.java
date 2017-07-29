package javaexamples.cert.strings;

public class StringBuilderExamples {

    public static void main(String[] args){
        builderExample1();
    }

    private static void builderExample1() {
        StringBuilder s1 = new StringBuilder("meow");
        StringBuilder s2 = new StringBuilder("meow");

        // Reference comparison and they are not the same
        if (s1 == s2){
            System.out.println("A"); // Not output
        }

        // StringBuilder does not override Object's .equals() function, so we have a reference comparison here again
        if (s1.equals(s2)){
            System.out.println("B"); // Not output
        }

        // This compares the 2 Strings fine and returns true
        if (s1.toString().equals(s2.toString())){
            System.out.println("C"); // Outputs C
        }

        // Will not compile as an invalid comparison 9 StringBuilder reference to a String
/*        if (s1 == "meow"){
            System.out.println("D");
        }*/

        // This is a tricky one - it appears at first sight that we have a String pool reference comparison here.
        // However look in the implementation and you will find: return new String(value, 0, count);
        // So we do not intern the String in this case using the new String approach.
        if(s1.toString() == "meow"){
            System.out.println("E"); // Not output
        }
    }
}
