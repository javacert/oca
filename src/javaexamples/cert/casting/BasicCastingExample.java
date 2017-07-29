package javaexamples.cert.casting;

public class BasicCastingExample {

    public static void main(String[] args){
        Object koala = new Koala();

        // Note here that you can cast the koala reference which is an Object, to a CanClimb or HasClaws
        // This is fine because koala implements both of these interfaces and everything extends object.
        CanClimb canClimb = (CanClimb)koala;
        HasClaws hasClaws = (HasClaws)koala;

        System.out.println(canClimb.maxHeight()); // 10
        System.out.println(hasClaws.isSharp());   // true

        // However when we try to cast to SomeRandomInterface from Object, it is allowed, but throws a Runtime Exception
        SomeRandomInterface someRandomInterface = (SomeRandomInterface)koala;
        System.out.println(someRandomInterface.hasMyMethod()); // ClassCastException
    }
}

class Koala implements CanClimb, HasClaws {
    public boolean isSharp(){
        return true;
    }

    public int maxHeight(){
        return 10;
    }
}

interface CanClimb{ int maxHeight(); }
interface HasClaws{ boolean isSharp(); }

interface SomeRandomInterface{ boolean hasMyMethod(); }
