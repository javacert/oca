package javaexamples.cert.operators;

// This example is because I am a dumbass and forgot what 0, 1, 2 % 3 are.
// 0 % 3 = 0
// 1 % 3 = 1
// 2 % 3 = 2
// There for we have the following loop:
// count is 0 | sum is 0
// count is 1 | sum is 1
// count is 2 | sum is 3
// count is 3 | sum is 3 (no change)
// count is 4 | sum is 7
// count is 5 | sum is 12
// count is 6 | sum is 12 (no change)
// count is 7 | sum is 19
// count is 8 | sum is 27
// count is 9 | sum is 27 (no change)
// count is 10 | sum is 37
// count is 11 | sum is 48 (remember that count++ will increment once more to 11)
public class ModulusExample {

    public static void main(String[] args){
        modulusExample();
    }

    private static void modulusExample() {
        int count = 0, sum = 0;
        do{
            if(count % 3 == 0) continue;
            sum+=count;
        }
        while(count++ < 11);
        System.out.println(sum); // 48
    }
}
