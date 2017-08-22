package javaexamples.cert.constructors;

// Notes
// According to Enthuware, a default constructor is only the constructor that the compiler adds itself, if it
// hasn't already been defined by the programmer. If you add a no-arg constructor manually, then it is not considered
// a default constructor.
public class BasicConstructorExamples extends ParentConstructorExample {

    public BasicConstructorExamples(String someString){
        // If this call to the super constructor was not provided, then there would be a compilation error
        // since the compiler would insert the no-args default call to super(), but the Parent class does not have
        // a default no-arg constructor!
        super(someString);
        // super(); --> Compiler would insert this and compilation would fail :-(
    }

    private BasicConstructorExamples(){
        //super(); // Won't compile since parent doesn't have a no-argument constructor
        super("Some Non-default constructor");
    }; // You can have a semi-colon here but unnecessary

    public static void main(String[] args){
        new BasicConstructorExamples(); // Can reference the private constructor from within the class only
    }
}

class ParentConstructorExample {
    ParentConstructorExample(String someString){

    }
}

class SomeClassToInstantiateClass {
    public static void main(String[] args){
        //new BasicConstructorExamples(); // Can't do this since constructor is marked as private
    }
}