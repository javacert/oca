package javaexamples.cert.scope;

public class FinalKeywordTrickExamples {

    final protected int someFinalVariableA = 4;
    protected final int someFinalVariableB = 4;
    // protected int final someFinalVariableC = 4; // --> return type must appear immediately before method

    // private final Object contents; // --> Having final here is an issue:
    // 1) It is not initialized
    // 2) There is a setter for a final variable and this is not compatible
    private Object contents;

    public Object getContents() {
        return contents;
    }

    public void setContents(Object someObjectToSet) {
        this.setContents(someObjectToSet);
    }
}
