package javaexamples.cert.statements;

// The loop counter typically ends one more than the final condition when working with pre-post increment of the counter.
public class LoopCounting {

    public static void main(String[] args){
        forLoopCounting();
        doWhileLoopCounting();
        whileLoopCounting();
    }

    private static void forLoopCounting() {
        int i = 0;
        for(; i<10; i++){}
        System.out.println(i); // 10 - 9 is subjected to the update statement making it a 10

        for(i=0; i<=10; i++){}
        System.out.println(i); // 11 - 10 is subjected to the update statement making it a 10
    }

    private static void doWhileLoopCounting() {
        int i = 0;
        do {
            i++;
        } while (i<10);
        System.out.println(i); // 10

        i = 0;
        do {
            i++;
        } while (i<=10);
        System.out.println(i); // 11
    }

    private static void whileLoopCounting() {
        int i = 0;
        while(i < 10){
            i++;
        }
        System.out.println(i); // 10

        i = 0;
        while(i <= 10){
            i++;
        }
        System.out.println(i); // 11
    }
}
