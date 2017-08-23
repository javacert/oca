package javaexamples.cert.exceptions;

public class TrickyOverrideExceptionExample extends OverrideExceptionClass {

    public static void main(String[] args){
        TrickyOverrideExceptionExample t = new TrickyOverrideExceptionExample();
        OverrideExceptionClass o = new TrickyOverrideExceptionExample();

        t.eat();
        // The following will throw a compilation error - why?
        // Because even though we have overridden it in the child class, the compiler doesn't know this
        // (determined at runtime) so it thinks we are trying to call the version which throws a checked exception
        // Remember, the compiler looks at the reference and sees that o method throws a checked exception. The
        // compiler doesn't care that it may be overridden at runtime.
        // o.eat(); // --> Would need to be surrounded by a try/catch!
    }

    public void eat(){
        System.out.println("Does not throw Exception");
    }
}

class OverrideExceptionClass {
    public void eat() throws Exception {
        System.out.println("Throws Checked Exception");
    }
}