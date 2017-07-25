package javaexamples.cert.encapsulation;

// This example shows that 2 instances of the same class may access each other's private attributes!
public class TwoClassInstancesAccessingEachOthersPrivateAttributesExample {

    public static void main(String[] args){
        SomeClassWithPrivateAttributes someClassWithPrivateAttributesA = new SomeClassWithPrivateAttributes("A");
        SomeClassWithPrivateAttributes someClassWithPrivateAttributesB = new SomeClassWithPrivateAttributes("B", someClassWithPrivateAttributesA);

        System.out.println(someClassWithPrivateAttributesB.getOtherClassPrivateAttribute());
        // someClassWithPrivateAttributesB.somePrivateAttribute; // --> Can't access it here, only within the same class!
    }
}

class SomeClassWithPrivateAttributes{

    private SomeClassWithPrivateAttributes someClassWithPrivateAttributes;

    private String somePrivateAttribute;

    public SomeClassWithPrivateAttributes(String someString){
        this.somePrivateAttribute = someString;
    }

    public SomeClassWithPrivateAttributes(String someString, SomeClassWithPrivateAttributes someClassWithPrivateAttributes){
        this.somePrivateAttribute = someString;
        this.someClassWithPrivateAttributes = someClassWithPrivateAttributes;
    }

    // This method returns the private variable of the other class instance and demonstrates that this is possible.
    // BUT ONLY WITHIN THE SAME CLASS!!
    public String getOtherClassPrivateAttribute(){
        return this.someClassWithPrivateAttributes.somePrivateAttribute;
    }
}
