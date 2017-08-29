package javaexamples.cert.statements;

// This is an important example around reassigning reference variables in a forEach loop.
// Watch out for code that uses an enhanced forEach loop and its loop variable to change the values of its
// elements in the collection that it iterates.

// The loop variable in the enhanced for loop refers to a copy of the array or list element.
// If you modify the state of the loop variable, the modified object state will be reflected in the array.
// But if you assign a new object to the loop variable, it won’t be reflected in the list or the array
// that’s being iterated.

// Use the for-each loop to iterate over arrays and collections. Don’t use it to initialize, modify, or filter them.
public class ComplexForEachExample {
    public static void main(String args[]) {
        EJavaCourse courses[] = { new EJavaCourse(), new EJavaCourse() };
        courses[0].courseName = "OCA";
        for (EJavaCourse c : courses) c = new EJavaCourse();
        for (EJavaCourse c : courses) System.out.println(c.courseName);
    }
}

class EJavaCourse {
    String courseName = "Java";
}
