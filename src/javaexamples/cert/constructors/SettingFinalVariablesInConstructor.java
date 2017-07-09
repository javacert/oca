package javaexamples.cert.constructors;

public class SettingFinalVariablesInConstructor {

    static int start = 2;
    // final instance variables must be assigned before constructor completes
    // (i.e. in instance initializer which runs first, or in constructor)
    final int end;

    {
        // end = 5; // Could do it in here
    }

    public SettingFinalVariablesInConstructor(int x){
        x = 4;
        end = x; // This compiles fine!!!
    }

    public void fly(int distance){
        System.out.println(end-start+ " "); // 2
        System.out.println(distance);// 5
    }

    public static void main(String[] args){
        new SettingFinalVariablesInConstructor(10).fly(5);
    }

}
