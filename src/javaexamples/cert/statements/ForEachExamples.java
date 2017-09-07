package javaexamples.cert.statements;

import java.util.*;

// Every for-each loop can be rewritten as a do-while loop
// Every for-each loop can be rewritten as a traditional for loop
// Every for-each loop can be rewritten as a while loop
public class ForEachExamples {

    public static void main(String[] args){
/*        whatCanYouUseWithAForEach();
        cannotUsePredefinedVariable();
        arrayNotCorrectlyInitialized(null);
        watchForUnreachableCodeWithContinueBreak();*/
        youCannotReassignPrimitivesOrReferenceVariables();
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

    private static void youCannotReassignPrimitivesOrReferenceVariables() {

        // 1) You cannot modify the value since forEach loops makes a copy of the array.
        int[] intArray = new int[]{1, 2, 3};
        for (int i : intArray){
            i = 10;
        }
        System.out.println(Arrays.toString(intArray)); // [1, 2, 3]

        // 2) You cannot modify the reference since forEach loops makes a copy of the array.
        Integer[] integerArray = new Integer[]{1, 2, 3};
        for (int integerRef : integerArray){
            integerRef = new Integer(10);
        }
        System.out.println(Arrays.toString(integerArray)); // [1, 2, 3]

        // 3) Although you cannot modify the reference, you can modify the contents of the object.
        StringBuilder[] sbArray = new StringBuilder[]{new StringBuilder("abc"), new StringBuilder("abc"), new StringBuilder("abc")};

        for (StringBuilder sb : sbArray){
            sb.append("def");
        }
        System.out.println(Arrays.toString(sbArray)); // [abcdef, abcdef, abcdef]
    }
}