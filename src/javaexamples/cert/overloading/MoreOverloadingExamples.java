package javaexamples.cert.overloading;

// Remember that in overloading primitive will fall into the closest method.
public class MoreOverloadingExamples {

    public static void main(String[] args){
        MoreOverloadingExamples m = new MoreOverloadingExamples();
        System.out.println(m.aMethod((byte)1));     // aMethod(short anInput)
        System.out.println(m.aMethod((short)1));    // aMethod(short anInput)
        System.out.println(m.aMethod(1));    // aMethod(int anInput)
        System.out.println(m.aMethod('a'));  // aMethod(int anInput) ** char goes to int
        System.out.println(m.aMethod((long)1));     // aMethod(long anInput)
        System.out.println(m.aMethod((float)1));    // aMethod(double anInput) ** float goes to double
        System.out.println(m.aMethod((double)1));   // aMethod(double anInput)
    }

    public String aMethod(long anInput) { return "aMethod(long anInput)"; }
    public String aMethod(double anInput) { return "aMethod(double anInput)"; }
    public String aMethod(int anInput) { return "aMethod(int anInput)"; }
    public String aMethod(short anInput) { return "aMethod(short anInput)"; }
}
