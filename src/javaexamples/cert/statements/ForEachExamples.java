package javaexamples.cert.statements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ForEachExamples {

    public static void main(String[] args){
        whatCanYouUseWithAForEach();
        cannotUsePredefinedVariable();
        arrayNotCorrectlyInitialized(null);
        watchForUnreachableCodeWithContinueBreak();
    }

    private static void whatCanYouUseWithAForEach() {
        // You can use the forEach loop with arrays and collections
        System.out.println("int array");
        int[] intArray = new int[]{1, 2, 3, 4};
        for (int i : intArray){
            System.out.println(i);
        }

        System.out.println("string array");
        String[] stringArray = new String[]{"1", "2", "3", "4"};
        for (String s : stringArray){
            System.out.println(s);
        }

        System.out.println("ArrayList");
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        for (Integer i : al){
            System.out.println(i);
        }

        System.out.println("HashMap");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("A", "A");
        for(Map.Entry<String, String> entry : hm.entrySet()) {
            System.out.println(entry); // A=A
        }
    }

    private static void cannotUsePredefinedVariable() {
        Object o = null;
        Collection c = new ArrayList();
        c.add("A");
        c.add("B");
        // for (o : c) {} // INVALID!! Cannot use an existing / pre-defined variable in the declaration part
        for (Object other : c) {}
        for (final Object another : c) {} // Note that final is the only modifier that is allowed here
    }

    private static void arrayNotCorrectlyInitialized(int[][] ia) {
        // Would throw a Runtime Exception if ia is not properly initialized
        for(int i : ia[0]){

        }
    }

    private static void watchForUnreachableCodeWithContinueBreak() {
        String [] someArray = {"A", "B", "C"};
        for (String s : someArray){
            continue;
            // System.out.println("Can't reach me here!"); // Unreachable Statement
        }

        for (String s : someArray){
            break;
            // System.out.println("Can't reach me here!"); // Unreachable Statement
        }

        for (String s : someArray){
            if(true){
                continue;
            } else {
                break;
            }
            //System.out.println("You can never reach me so I will throw a compiler error!"); // Unreachable Statement!
        }
    }
}
