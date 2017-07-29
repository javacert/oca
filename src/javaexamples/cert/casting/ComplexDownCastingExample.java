package javaexamples.cert.casting;

public class ComplexDownCastingExample {

    public static void main(String[] args){
        SoccerBall soccerBall = new SoccerBall();
        // This compiles fine since soccerBall is both Equipment and a Ball
        Equipment equipmentA = (Equipment)(Ball)soccerBall; // Notice both these casts are redundant, SoccerBall is already a Ball and Equipment
        Equipment equipmentB = (Equipment)(SoccerBall)(Ball)(Equipment)(Ball)(Object)(Ball)(Equipment)(SoccerBall)soccerBall;
        Equipment equipmentC = (SoccerBall)(Ball)(Equipment)(Ball)(Object)(Ball)(Equipment)(SoccerBall)soccerBall;
        Equipment equipmentD = (Equipment)(Round)soccerBall;
        Equipment equipmentE = (Equipment)(Round)(Equipment)soccerBall;
        Round roundA = (Round)(Equipment)soccerBall;
        // Equipment equipmentWontCompile = (Ball)soccerBall; // This however would not compile since Ball is not Equipment

        // SoccerBall soccerBallB = (Ball)soccerBall; // --> Does not compile

        Ball ball = new SoccerBall();
        // Equipment equipmentF = ball; // --> Does not compile since a Ball is not Equipment
        // This compiles and runs fine since soccerBall is both Equipment and a Ball, and can be cast to both
        Equipment equipmentG = (Equipment)ball;

        // Note the following examples - thr following text is from the Java docs
        // If Ball is not a final class, then, if there exists a supertype X of a compile-time reference type, and a supertype Y of Ball, such
        // that both X and Y are provably distinct parameterized types, and that the erasures of X and Y are the same, a compile-time error occurs.
        // Otherwise, the cast is always legal at compile time (because even if Ball does not implement the compile-time reference type, a subclass of Ball might).
        // If S is a final class , then S must implement T, or a compile-time error occurs.
        SomeRandomInterface someRandomInterfaceA = (SomeRandomInterface)ball; // ClassCastException
        SomeRandomInterface someRandomInterfaceB = (SomeRandomInterface)equipmentA; // ClassCastException
        SomeRandomClass someRandomClassA = (SomeRandomClass)equipmentA; // ClassCastException

        // The following will not compile because we know that ball is not SomeRandomClass
        //SomeRandomClass someRandomClassB = (SomeRandomClass)ball; // --> Won't compile - inconvertible types
        // The following will compile because we first cast ball into Object and then the compiler thinks,
        // Object could well be SomeRandomClass and will not throw a compile error
        SomeRandomClass someRandomClassB = (SomeRandomClass)(Object)ball; // ClassCastException at Runtime
    }
}

class SoccerBall extends Ball implements Equipment {

}

abstract class Ball implements Round {

    public static void main(String[] args){
        System.out.println("Hey look at me, I'm an abstract class with a main method!!");
    }
}

interface Equipment {

}

interface Round {

}

class SomeRandomClass {}