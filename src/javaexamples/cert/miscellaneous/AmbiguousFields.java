package javaexamples.cert.miscellaneous;

// Having ambiguous fields does not cause any problems but referring to
// such fields in an ambiguous way will cause a compile time error.
public class AmbiguousFields implements I1, I2 {

    public static void main(String[] args){
        AmbiguousFields ambiguousFields = new AmbiguousFields();
        // System.out.println(ambiguousFields.VALUE); // VALUE is ambiguous
        System.out.println(I1.VALUE); // 1
        System.out.println(I2.VALUE); // 2
    }

    public void m1() {

    }
}

interface I1{
    int VALUE = 1;
    void m1();
}
interface I2{
    int VALUE = 2;
    void m1();
}