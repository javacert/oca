package javaexamples.cert.strings;

public class NullStringReferenceExample {

    public static void main(String[] args){
        String chair, table = "metal";
        // chair = chair + table; // Compiler error since chair has not been initialized
        // System.out.println(chair); // NOTE!!! Outputting a null reference will not print "null" - it might in javascript but NOT Java
    }
}
