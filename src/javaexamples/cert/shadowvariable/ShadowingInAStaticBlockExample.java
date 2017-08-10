package javaexamples.cert.shadowvariable;

public class ShadowingInAStaticBlockExample {

    static int x = 2;
    static int z;

    public static void main(String[] args){
        // x here will be 2, but z will be set to 5 below given the order of static initialization
        System.out.println(x + z); // 2 + 5 = 7
    }

    static {
        int x = 5; // This is a shadow and is allowed
        z = x; // z will be set to the shadow x value as 5
    }
}
