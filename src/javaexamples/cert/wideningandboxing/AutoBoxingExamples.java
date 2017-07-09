package javaexamples.cert.wideningandboxing;

public class AutoBoxingExamples {

    // This will compile since dAsPrim will be autoboxed to Double
    double dAsPrim = new Double(1_000_000.00);

    Double dAsWrapper = new Double(1_000_000.00);

    // This will not compile since double is not an object and will not have a constructor
    // Double d = new double(1_000_000.00);
}
