package javaexamples.cert.interitance;

import java.util.ArrayList;
import java.util.List;

public class AssigningReferenceToObjectExample {

    public static void main(String[] args){
        assignAListToAnObjectExample();
    }

    private static void assignAListToAnObjectExample() {
        // The following will not compile since Object is NOT a List (doesn't implement the List interface)
        //List someList = new Object();

        // It is the same reason the following do not compile either
        //SomeSubClass someSubClass = new Object();
        //SomeSubClass someSubClass = new SomeSuperClass();

        // This is fine since all Objects extend Object
        Object someObject = new ArrayList();
    }
}
