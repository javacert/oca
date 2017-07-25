package javaexamples.cert.constructors;

public class BasicConstructorExamples extends ParentConstructorExample {

    public BasicConstructorExamples(String someString){
        // If this call to the super constructor was not provided, then there would be a compilation error
        // since the compiler would insert the no-args default call to super(), but the Parent class does not have
        // a default no-arg constructor!
        super(someString);
        // super(); --> Compiler would insert this and compilation would fail :-(
    }
}

class ParentConstructorExample {
    ParentConstructorExample(String someString){

    }
}