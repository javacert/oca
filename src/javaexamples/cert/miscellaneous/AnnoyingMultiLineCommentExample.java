package javaexamples.cert.miscellaneous;

public class AnnoyingMultiLineCommentExample {

    int abc;
    String course = //this is a comment
            "eJava";

    public static void main(String[] args){
        String course = /* some comments */ //
        "Hello" /* some text in here */ + "this" +
                // Some comments here
        /* wow */ "and let's finish here";

        System.out.println(course); // Hellothisand let's finish here

        if(true){
            // String course = ""; // --> You can only shadow class level variables!
        }

        String name = "e" + "Ja /*va*/ v";
        System.out.println(name); // eJa /*va*/ v
    }
}
