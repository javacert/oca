package javaexamples.cert.interitance;

public class OverridingWithAbstractMethodExample extends SomeChildClassAsAbstract {

    // You need to implement the teach method again since you are extending an abstract class.
    void teach(String student){

    }
}

// You can extend and then make a method abstract again, to be implemented within the child
// Note that if you make the method abstract, you must also make the class abstract.
abstract class SomeChildClassAsAbstract extends SomeClassToInherit {
    abstract void teach(String student);
}

class SomeClassToInherit {
    void teach(String student){

    }
}
