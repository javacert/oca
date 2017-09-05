package javaexamples.cert.initializers;

public class ReallyComplexInitializerExample {

    public static void main(String[] args){

        // No initialization of static will be done given the following.
        // Note if class containing main had static initializer blocks, then they will be run.
        SomeMadClassInAHierarchySubClass someMadClassInAHierarchySubClass = null;

        someMadClassInAHierarchySubClass = new SomeMadClassInAHierarchySubClass();

        // OUTPUT:
        // Remember all statics (variables and initializers) from super to sub class are inialized first
        // G J D
        // Then from super-most class to sub-class, instance initializers and then the constructors.
        // H I F E
    }
}

class SomeMadClassInAHierarchySubClass extends SomeMadClassInAHierarchySuperClass {
    static {
        System.out.println("D");
    }

    SomeMadClassInAHierarchySubClass() {
        System.out.println("E");
    }

    {
        System.out.println("F");
    }

    static String someStaticString = "Static String in SomeMadClassInAHierarchySubClass";
}

class SomeMadClassInAHierarchySuperClass implements SomeInterfaceInAHierarchy {

    static {
        System.out.println("G");
    }

    {
        System.out.println("H");
    }

    SomeMadClassInAHierarchySuperClass() {
        System.out.println("I");
    }

    static String someStaticString = "Some Static String";

    static {
        System.out.println("J");
    }
}

interface SomeInterfaceInAHierarchy {
    static String someStaticString = "Some Static String in an Interface";

    /*static {
        // Not valid in an interface.
    }*/

    static void someStaticMethodInAnInterface(){
        System.out.println("K");
    }
}
