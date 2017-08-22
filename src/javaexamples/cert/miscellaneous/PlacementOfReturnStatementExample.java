package javaexamples.cert.miscellaneous;

// This example shows that you need to watch for all return statements and ensure that they are all reachable.
public class PlacementOfReturnStatementExample {

    public static void main(String[] args){
        System.out.println(parseFloatA("0.1"));     // 0.1
        System.out.println(parseFloatA("0x.1"));    // Invalid input 0x.1
        System.out.println(parseFloatA("1"));       // 1.0
        System.out.println(parseFloatA("0x1"));     // Invalid input 0x1
    }

    public static float parseFloatA(String s){
        float f;
        try{
            f = Float.valueOf(s).floatValue();
            return f;
        }
        catch(NumberFormatException nfe){
            System.out.println("Invalid input " + s);
            f = Float.NaN;
            return f;
        }
        finally { System.out.println("finally");  }
        // return f; // Unreachable statement since both the try and catch have a return statement
    }

    public static boolean returnStatementPlacementExample(){
        try{
            return true;
        }
        catch(NumberFormatException nfe){
        }
        finally { System.out.println("finally");  }

        return false; // This is fine since it is now reachable
    }
}
