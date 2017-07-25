package javaexamples.cert.encapsulation;

public class BasicEncapsulationExample {

    // Remember to encapsulate you only have to make private
    private String someEncapsulatedVariable;

    // Adding getter and setters have nothing to do with encapsulation. When you set the variable to private,
    // it is encapsulated. Setters and Getters allow safe access to a private variable, but the do not affect
    // encapsulation.
    public String getSomeEncapsulatedVariable() {
        return someEncapsulatedVariable;
    }

    public void setSomeEncapsulatedVariable(String someEncapsulatedVariable) {
        this.someEncapsulatedVariable = someEncapsulatedVariable;
    }
}
