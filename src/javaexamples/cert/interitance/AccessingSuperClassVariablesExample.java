package javaexamples.cert.interitance;

public class AccessingSuperClassVariablesExample {

    public static void main(String[] args){
        new SomeSubClass().accessingSuperClassVariables();
    }
}

class SomeSubClass extends SomeSuperClass {
    public void accessingSuperClassVariables(){
        System.out.println(count);          // 0
        System.out.println(this.count);     // 0
        System.out.println(super.count);    // 0
    }
}

class SomeSuperClass {
    protected int count;
}
