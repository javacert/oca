package javaexamples.cert.scope;

public class LocalVariableInitializationExample {

    public static void main(String[] args){
        short defaultValue1;
        int defaultValue2;
        double defaultValue3;

        // None of the following would compile since none have been initialized
        // Remember that you must initialize variables in method scope before you use them
        //System.out.println(defaultValue1);
        //System.out.println(defaultValue2);
        //System.out.println(defaultValue3);

        // However if we initialize them we can use them fine
        defaultValue1 = 1;
        defaultValue2 = 2;
        defaultValue3 = 3; // int widened to a double
        System.out.println(defaultValue1); // 1
        System.out.println(defaultValue2); // 2
        System.out.println(defaultValue3); // 3.0
    }
}
