package javaexamples.cert.strings;

import javax.print.attribute.standard.MediaSize;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

// If a String is formed by concatenating two String literals it will also be interned.
// This will add to String pool: String twoLiterals = "goo" + "d";
// This will not add to String pool:
//        String anotherString = "goo";
//        anotherString += 'd';
public class StringFromCharStringPoolExample {

    public static void main(String[] args) {
        exampleA();
        exampleB();
    }

    private static void exampleA() {
        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd'};
        String newStr = "";
        for (char ch : myCharArr) {
            newStr = newStr + ch;
        }

        String anotherString = "goo";
        anotherString += 'd';

        String poolString = "good";

        String concatString = "goo";
        concatString = concatString + "d";

        String twoLiterals = "goo" + "d";

        boolean b1 = newStr == myStr;
        boolean b2 = newStr.equals(myStr);
        boolean b3 = myStr == anotherString;
        boolean b4 = poolString == anotherString;
        boolean b5 = myStr == concatString;
        boolean b6 = myStr == poolString;
        boolean b7 = myStr == twoLiterals;
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4 + " " + b5 + " " + b6 + " " + b7);
    }

    private static void exampleB() {
        String hello = "Hello", lo = "lo";
        System.out.print((hello == "Hello") + " "); // true
        System.out.print((hello == ("Hel"+"lo")) + " "); // true
        System.out.print((hello == ("Hel"+lo)) + " "); // false
        System.out.println(hello == ("Hel"+lo).intern()); // true
    }

}
