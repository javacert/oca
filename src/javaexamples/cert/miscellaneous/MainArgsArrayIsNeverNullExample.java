package javaexamples.cert.miscellaneous;

// The args array to main is never null.
// If the program is run without any arguments, args points to a String array of length 0.
// A zero length array is still an instance of Object which holds zero elements
public class MainArgsArrayIsNeverNullExample {

    public static void main(String[] args)  {

        System.out.println(args.length); // 0
        int[] someZeroArray = {};
        System.out.println(someZeroArray.length); // 0
        int[] someOtherZeroArray = new int[0];
        System.out.println(someOtherZeroArray.length); // 0
        int[] someOtherZeroLengthArray = new int[]{};
        System.out.println(someOtherZeroLengthArray.length); // 0

        boolean hasParams = (args == null ? false : true);
        if(hasParams){
            System.out.println("has params");
        }

        {
            System.out.println("no params");
        }
    }
}
