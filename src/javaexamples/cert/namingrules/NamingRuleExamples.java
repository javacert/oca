package javaexamples.cert.namingrules;

public class NamingRuleExamples {

    public static void main(String[] args){
        int Integer = 0; // This is fine, although not a good naming convention since it is the name of a Wrapper
        //Integer int = 0; // This won't compile because int is a reserved word

        // int 787Abc = 0; // This won't compile
    }

    // Invalid name of a method
/*    public static void 1_someMethod(){

    }*/

    // Valid name of a method
    public static void $__1__someMethod(){

    }

    // Valid name of a method
    public static void __1__someMethod(){

    }
}

//Valid name of a class
class _____ {

}

//Valid name of a class
class $$$ {

}
