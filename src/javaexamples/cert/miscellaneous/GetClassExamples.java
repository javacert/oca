package javaexamples.cert.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class GetClassExamples {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("mrx");
        String s = sb.toString();

        // The getClass method always returns the Class object for the actual object on
        // which the method is called irrespective of the type of the reference.
        System.out.println(list.getClass()); // class java.util.ArrayList
        System.out.println(sb.getClass()); // class java.lang.StringBuilder
        System.out.println(s.getClass()); // class java.lang.String
    }
}
