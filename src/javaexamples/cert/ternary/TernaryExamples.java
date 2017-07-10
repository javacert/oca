package javaexamples.cert.ternary;

public class TernaryExamples {

    public static void main(String[] args){
        // The following won't compile since 10 is an int
        // String someString = true ? "Hello" : 10;

        // However ternary can return different types as shown here
        System.out.println(true ? "Hello" : 10); // Hello
        System.out.println(false ? "Hello" : 10); // 10
    }
}
