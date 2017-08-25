package javaexamples.cert.miscellaneous;

// Basic Rules:
// 1) Top level enums only allows  public and default access modifiers
// 2) Since any other instances should not be allowed to create an enum, the constructor is implicitly private.
// 3) An enum can have static fields and members, and their access modifier can be anything.
// 4) An enum can have not-static fields and members, and their access modifier can be anything.
// 5) While we can not mark a enum as abstract, we can declare a method as abstract.
public enum EnumExample {
    PLUS,
    MINUS,
    TIMES,
    DIVIDE,
    SOMETHING("Parameter");

    private String aString;

    //public EnumExample() { // Cannot be public
    EnumExample() {
        this.aString = aString;
    }

    private EnumExample(String aString) { // Constructors are implicitly private
        this.aString = aString;
    }

    public String aString() {
        return aString;
    }

    public static void main(String[] args){
        System.out.println(EnumExample.DIVIDE);     // DIVIDE
        System.out.println(EnumExample.SOMETHING);  // SOMETHING
    }

    double calculate(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }
}
