package javaexamples.cert.casting;

public class ComplexCastingExample {

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
        // This compiles fine since soccerBall is both Equipment and a Ball, and can be cast to both
        Equipment equipmentG = (Equipment)ball;
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
