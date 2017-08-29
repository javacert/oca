package javaexamples.cert.lambdas;

public class CustomFunctionalInterfaceExample {
    public static void main(String arguments[]) {
        Person person = new Person();
        Moveable moveable = (x) -> Person.MIN_DISTANCE + x;

        System.out.println(person.name +
                person.height +
                person.result +
                person.age +
                moveable.move(20)); // null0.0false025
    }
}

// This is a functional interface and can be used with a lambda.
interface Moveable {
    int move(int distance);
}

class Person {
    static int MIN_DISTANCE = 5;
    int age;
    float height;
    boolean result;
    String name;
}