package javaexamples.cert.casting;

// Downcasting is allowed when there is a possibility that it succeeds at run time:
public class DownCastingExamples {

    public static void main(String[] args){

        Object o1 = getSomeObject();
        String s1 = (String) o1; // this is allowed because o could reference a String

        Object o2 = new Object();
        String s2 = (String) o2; // this will fail at runtime, because o doesn't reference a String

        Object o3 = "a String";
        String s3 = (String) o3; // this will work, since o references a String

        Integer i = getSomeInteger();
        // String s = (String) i; // --> the compiler will not allow this, since i can never reference a String
    }

    public static Object getSomeObject() {
        return new Object();
    }

    public static Integer getSomeInteger() {
        return new Integer(1);
    }
}
