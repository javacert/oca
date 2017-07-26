package javaexamples.cert.overriding;

import java.io.EOFException;
import java.io.IOException;

public class OverrideExamples extends ClassToOverride {

    public static void main(String[] args) throws Exception{
        new OverrideExamples().someMethodToOverride();
    }

    // This is a valid override - Reasons why:
    // 1) Access modifier is at least accessible or more accessible than the parent class
    // 2) Exception thrown is not new and it is not broader (i.e. it is a subclass of IOException)
    // 3) Return type is the same or covariant (subclass of the return type in the parent override - Integer is a subclass of Number)
    public Integer someMethodToOverride() throws EOFException {
        return 10;
    }

    // The following is also VALID!!! You can drop the exception altogether and it is still a valid override
/*    public Integer someMethodToOverride() {
        return 10;
    }*/

    // Not valid - return type is different and is not covariant
/*    public int someMethodToOverride() throws EOFException {
        return 10;
    }*/

    // Not valid - overridden method has weaker access privileges
/*    private Integer someMethodToOverride() throws EOFException {
        return 10;
    }*/

    // Not valid - exception thrown is broader
/*    public Integer someMethodToOverride() throws Exception {
        return 10;
    }*/
}

class ClassToOverride {

    protected Number someMethodToOverride() throws IOException {
        return 10;
    }
}
