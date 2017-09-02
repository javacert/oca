package javaexamples.cert.wrappers;

// Notes:
// 1) long remainderUnsigned(long dividend, long divisor) --> Returns the unsigned remainder from dividing the first
//    argument by the second where each argument and the result is interpreted as an unsigned value. Uses %
// 2) long divideUnsigned(long dividend, long divisor) --> Returns the unsigned quotient of dividing the first argument
//    by the second where each argument and the result is interpreted as an unsigned value. Uses /
public class LongExamples {

    public static void main(String[] args){
        remainderUnsignedExampleA();
        remainderUnsignedExampleB();
        divideUnsignedExampleA();
        divideUnsignedExampleB();
    }

    private static void remainderUnsignedExampleA() {
        Long long1 = 10L;
        Long long2 = 9l;
        System.out.println(Long.remainderUnsigned(long1, long2)); // 1
    }

    private static void remainderUnsignedExampleB() {
        Long long1 = -10L;
        Long long2 = 9l;
        System.out.println(Long.remainderUnsigned(long1, long2)); // 6
    }

    private static void divideUnsignedExampleA() {
        Long long1 = 10L;
        Long long2 = 9l;
        System.out.println(Long.divideUnsigned(long1, long2)); // 1
    }

    private static void divideUnsignedExampleB() {
        Long long1 = -10L;
        Long long2 = 9l;
        System.out.println(Long.divideUnsigned(long1, long2)); // 2049638230412172400
    }
}
