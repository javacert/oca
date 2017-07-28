package javaexamples.cert.exceptions;

// This example shows that you only need to handle Checked exceptions (those that extend Exception and not RuntimeException)
// You can throw RuntimeExceptions without receiving a compilation error, but if you throw any Checked exception you
// MUST handle either by passing up to the calling method using a throws declaration, or with a try/catch catching the
// checked exception.

public class YouOnlyNeedToCatchForCheckedExceptionsExample {

    private static void testingCheckedException() {
        // I don't need to surround with try/catch since it is a RuntimeException
        new Citadel().openDrawBridgeThrowsRuntimeException();

        // I DO need to surround with try/catch since it is a Checked Exception (extends Exception but not RuntimeException)
        try {
            new Citadel().openDrawBridgeThrowsException();
        } catch (Exception e) {

        }
    }
}

class CastleUnderSiegeException extends Exception{}
class KnightAttackingException extends CastleUnderSiegeException{}

class Citadel {
    public void openDrawBridgeThrowsRuntimeException() throws RuntimeException /* , CastleUnderSiegeException */ {
        try {
            throw new KnightAttackingException();
        } catch (Exception e){
            throw new ClassCastException(); // Unchecked or RuntimeException, so not required to be handled!
        } finally {
            // The following won't compile since CastleUnderSiegeException is a checked exception and must be handled
            // either with a throws declaration, or a try/catch
            // throw new CastleUnderSiegeException();

            // This works though since we catch the exception there and then.
            try {
                throw new CastleUnderSiegeException();
            } catch (CastleUnderSiegeException e){

            }
        }
    }

    public void openDrawBridgeThrowsException() throws Exception {
        try {
            throw new KnightAttackingException();
        } catch (Exception e){
            throw new ClassCastException();
        } finally {
            throw new CastleUnderSiegeException();
        }
    }
}
