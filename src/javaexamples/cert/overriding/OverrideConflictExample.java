package javaexamples.cert.overriding;

public class OverrideConflictExample {

    public static void main(String[] args){
    }
}

// The following can never compile since Woodwind already has a version of play which
// has a return type of Short (which extends number). We cannot override and implement
// given the below signature since it conflicts with the Short version. If the interface
// had defined the return type as Number, then this would be fine since Short would be
// a covariant return type of Number.
/*class Saxophone extends WoodWind implements Horn {

    public Integer play() {
        return 3;
    }
}*/

abstract class WoodWind {
    public Short play() {
        return 3;
    }
}

interface Horn {
    public Integer play();
}
