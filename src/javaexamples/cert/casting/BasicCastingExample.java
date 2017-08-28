package javaexamples.cert.casting;

// Up-casting is casting to a supertype, while down-casting is casting to a subtype.
// Remember Up to Parent, Down to Child
// ClassCastException is possible when you downcast to a child class
// Up-casting can be occurred implicitly, while Down-casting should be done explicitly (you provide the cast)

// Reference type should be the same as the object type, or a class in the objects class hierarchy.
// This is an up cast assignment and won't need an explicit cast.
// Reference type can never be a direct assignment to a superclass object. In this case an explicit cast is required.
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
