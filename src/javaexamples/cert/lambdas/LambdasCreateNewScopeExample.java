package javaexamples.cert.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// This example shows that lambda expressions always create a new scope. If a variable is already in scope such as s
// in this example, then the lambda will not compile.
public class LambdasCreateNewScopeExample {

    public static void main(String args[]){

        String s = "already exists";

        String names[] = {"Roel", "Jeanne", "Paul", "Mushfiq"};
        List<String> list = new ArrayList(Arrays.asList(names));
        //list.removeIf( (String s) -> { return s.contains("s"); } );
    }
}
