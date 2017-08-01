package javaexamples.cert.finalize;

public class FinalizeExamples {

    public static void main(String[] args){
        FinalizeExamples a = new FinalizeExamples();
        a = null; // a now eligable for GC
        System.gc(); // finalize may or may not be called!
    }

    // Watch out of incorrectly named finalize methods
    public void finalizer(){
        System.out.println("I'm finalizing");
    }

    public void finalize(String someString){
        System.out.println("I'm not a valid finalize method since I have a parameter!");
    }

    // This is the correct implementation
    // Note that finalize() exists in Object --> protected void finalize() throws Throwable { }
    // Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.
    public void finalize() throws Exception {
        System.out.println("I'm finalizing");
    }
}
