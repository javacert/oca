package javaexamples.cert.overriding;

public class VariablesNotOverriddenExample extends VariableAccessExample {

    public int someInt = 3;
    public int somePrivateInt = 6;

    // Method variables are not overridden as these examples demonstrate
    public static void main(String[] args){
        new VariablesNotOverriddenExample().testingAccess();
    }

    public void testingAccess(){
        System.out.println(super.someInt); // 1
        System.out.println(this.someInt); // 3
        System.out.println(super.getSomeInt()); // 1
        System.out.println(this.getSomeInt()); // 3
        System.out.println(super.getSomePrivateInt()); // 2
        System.out.println(this.getSomePrivateInt()); // 6
        System.out.println(getSomePrivateInt()); // 6
        // System.out.println(super.somePrivateInt); // --> Does not compile
    }

    public int getSomeInt(){
        return this.someInt;
    }

    public int getSomePrivateInt(){
        return this.somePrivateInt;
    }
}

class VariableAccessExample {
    protected int someInt = 1;
    private int somePrivateInt = 2;

    public int getSomeInt(){
        return this.someInt;
    }

    public int getSomePrivateInt(){
        return this.somePrivateInt;
    }
}
