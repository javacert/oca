package javaexamples.cert.finalize;

public class FinalizeExamples {

    public static void main(String[] args){
        FinalizeExamples a = new FinalizeExamples();
        a = null; // a now eligable for GC
        System.gc(); // finalize may or may not be called!
    }

    // Watch out of incorrecty named finalize methods
    public void finalizer(){
        System.out.println("I'm finalizing");
    }

    // This is the correct implementation
    // Note that finalize() exists in Object
    // Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.
    public void finalize() throws Exception{
        System.out.println("I'm finalizing");
    }
}
