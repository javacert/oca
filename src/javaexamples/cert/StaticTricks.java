package javaexamples.cert;

import javaexamples.cert.rope.*;

public class StaticTricks {
    private static Rope rope1 = new Rope();
    private static Rope rope2 = new Rope();
    {
        System.out.println("Dummy, this is an instance initialize and is never run in this example");
    }
    public static void main(String[] args){
        rope1.length = 2;
        rope2.length = 8;

        // length in Rope is statuc and shared between all instances!!!!!!!
        System.out.println(rope1.length);
        System.out.println(rope2.length);
    }
}


