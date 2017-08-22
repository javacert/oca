package javaexamples.cert.overriding;

public class OverridingToStringExample {

    static int si = 10;

    public static void main(String args[]) {
        new OverridingToStringExample();
    }

    public OverridingToStringExample() {
        System.out.println(this); // public void println(Object x)
    }

    // Need to remember that when we pass this we are passing the object.
    // In this example we call println with the object which calls the toString method.
    // Since this class overides the toString method we call that method here.

    //public void println(Object x) {
    //    String s = String.valueOf(x);
    //    synchronized (this) {
    //        print(s);
    //        newLine();
    //    }
    //}

    //public static String valueOf(Object obj) {
    //    return (obj == null) ? "null" : obj.toString();
    //}

    public String toString() {
        return "TestClass.si = " + this.si;
    }
}