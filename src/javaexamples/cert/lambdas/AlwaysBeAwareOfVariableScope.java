package javaexamples.cert.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Watch carefully when using lambdas for trick scope examples. Below s is not available and would result in a
// compilation error.
public class AlwaysBeAwareOfVariableScope {
    public static void main(String[] args){
        String names[] = {"Roel", "Jeanne", "Paul", "Mushfiq"};
        List<String> list = new ArrayList(Arrays.asList(names));
        if(list.removeIf( (String s) -> { return s.contains("s"); } )){
            // System.out.println(s + " removes");
        }
    }
}
