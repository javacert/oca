package javaexamples.cert.wrappers;

import java.util.HashMap;
import java.util.Map;

public class WrapperSizesInOrderExample {

    public static void main(String[] args){
        int byteSize = Byte.SIZE;
        int charSize = Character.SIZE;
        int intSize = Integer.SIZE;
        int longSize = Long.SIZE;
        int floatSize = Float.SIZE;
        int doubleSize = Double.SIZE;

        Map<Object, Integer> mySortingMap = new HashMap<>();
        mySortingMap.put(Double.class, Double.SIZE);
        mySortingMap.put(Character.class, Character.SIZE);
        mySortingMap.put(Integer.class, Integer.SIZE);
        mySortingMap.put(Byte.class, Byte.SIZE);
        mySortingMap.put(Float.class, Float.SIZE);
        mySortingMap.put(Long.class, Long.SIZE);

        System.out.println(mySortingMap);
        // class java.lang.Byte=8,
        // class java.lang.Long=64,
        // class java.lang.Integer=32,
        // class java.lang.Double=64,
        // class java.lang.Character=16,
        // class java.lang.Float=32}

        // Order of size is byte, char, int, float, long, double

        Map<Object, String> myRangeMap = new HashMap<>();
        myRangeMap.put(Byte.class, (Math.pow(2, Byte.SIZE) / 2) + " - " + ((Math.pow(2, Byte.SIZE) / 2) - 1));
        myRangeMap.put(Short.class, (Math.pow(2, Short.SIZE) / 2) + " - " + ((Math.pow(2, Short.SIZE) / 2) - 1));
        myRangeMap.put(Character.class, "" + (Math.pow(2, Character.SIZE)-1)); // Remember char is only in the positive
        myRangeMap.put(Integer.class, (Math.pow(2, Integer.SIZE) / 2) + " - " + ((Math.pow(2, Integer.SIZE) / 2) - 1));
        myRangeMap.put(Long.class, (Math.pow(2, Long.SIZE) / 2) + " - " + ((Math.pow(2, Long.SIZE) / 2) - 1));

        System.out.println(myRangeMap);
        // class java.lang.Byte=128.0 - 127.0,
        // class java.lang.Long=9.223372036854776E18 - 9.223372036854776E18,
        // class java.lang.Integer=2.147483648E9 - 2.147483647E9,
        // class java.lang.Character=65535.0,
        // class java.lang.Short=32768.0 - 32767.0
    }
}
