package javaexamples.cert.statements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ForEachExamples {

    public static void main(String[] args){
        whatCanYouUseWithAForEach();
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
}
