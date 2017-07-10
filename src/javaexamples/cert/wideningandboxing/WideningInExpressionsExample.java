package javaexamples.cert.wideningandboxing;

public class WideningInExpressionsExample {

    public static void main(String[] args){
        int tiger = 2;
        short lion = 3;
        long winner = lion+2*(tiger + lion);
        System.out.println(winner); // 13

        // In this expression the short is promoted to an int,
        // and then the resulting int is promoted to a long
        winner = lion+2*tiger + lion;
        System.out.println(winner); // 10

        // However if we try to assign to a short, then it would not compile
        // short thisWontWork = lion+2*tiger + lion;


        // Even if we have 3 different data types this will work,
        // as both the int and the short are promoted to long in the expression,
        // but remember it will also evaluate to a long, so....
        long cat = 5;
        winner = cat + lion * tiger;
        System.out.println(winner); // 11

        // ...what happens when we try to assign to an int?
        //int thisAlsoWontWork = cat + lion * tiger;
    }
}
