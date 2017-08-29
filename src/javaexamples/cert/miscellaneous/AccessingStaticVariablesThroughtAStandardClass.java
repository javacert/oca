package javaexamples.cert.miscellaneous;

public class AccessingStaticVariablesThroughtAStandardClass {

    public static void main(String[] args){
        SomeClassWithAStaticVariable s = new SomeClassWithAStaticVariable();
        System.out.println(s.x); // 0
        System.out.println(SomeClassWithAStaticVariable.x); // 0
    }
}

class SomeClassWithAStaticVariable{
    public static final int x = 0;
}
