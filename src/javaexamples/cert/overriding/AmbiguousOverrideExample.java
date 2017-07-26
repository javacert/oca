package javaexamples.cert.overriding;


public class AmbiguousOverrideExample {

    public static void main(String[] args){
        new AmbiguousOverrideExample().playMusic(); // Ambiguous method call
    }

    // With both of these methods in place this results in a compilation issue.
    // playMusic is already defined!!
/*    public void playMusic(){
        System.out.println("Play");
    }*/

    public static int playMusic(){
        System.out.println("Play");
        return 10;
    }
}
