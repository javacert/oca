package javaexamples.cert.imports;

import javaexamples.cert.imports.someotherstaticpackage.SomeMoreStaticMethods;

import static javaexamples.cert.imports.someotherstaticpackage.SomeMoreStaticMethods.*;
// static import javaexamples.cert.imports.someotherstaticpackage.SomeMoreStaticMethods.*; // --> Import must come first
import static javaexamples.cert.imports.SomeStaticMethods.*;

public class ImportExamples {
    public static void main(String[] args){
        // System.out.println(someDefaultAccessStaticMethod()); // --> Can access package-private in another package
        System.out.println(someOtherStaticMethod()); // 10
        System.out.println(SomeMoreStaticMethods.someOtherStaticMethod()); // 10

        System.out.println(someLocalPackageStaticMethod()); // 50
        System.out.println(SomeStaticMethods.someLocalPackageStaticMethod()); // 50 --> Don't need an import since in same package
    }
}

class SomeStaticMethods {

    static int someLocalPackageStaticMethod(){
        return 50;
    }
}
