package javaexamples.cert.wrappers;

public class WrapperSizeAndBytesPropertyExamples {

    public static void main(String[] args){
        byteSizeAndBytes();
        characterSizeAndBytes();
        shortSizeAndBytes();
        integerSizeAndBytes();
        longSizeAndBytes();
        floatSizeAndBytes();
        doubleSizeAndBytes();
    }

    private static void byteSizeAndBytes() {
        System.out.println(Byte.SIZE); // 8
        System.out.println(Byte.BYTES); // 1 --> public static final int BYTES = SIZE / Byte.SIZE (8);
    }

    private static void characterSizeAndBytes() {
        System.out.println(Character.SIZE); // 16
        System.out.println(Character.BYTES); // 2 --> public static final int BYTES = SIZE / Byte.SIZE (8);
    }

    private static void shortSizeAndBytes() {
        System.out.println(Short.SIZE); // 16
        System.out.println(Short.BYTES); // 2 --> public static final int BYTES = SIZE / Byte.SIZE (8);
    }

    private static void integerSizeAndBytes() {
        System.out.println(Integer.SIZE); // 32
        System.out.println(Integer.BYTES); // 4 --> public static final int BYTES = SIZE / Byte.SIZE (8);
    }

    private static void longSizeAndBytes() {
        System.out.println(Long.SIZE); // 64
        System.out.println(Long.BYTES); // 8 --> public static final int BYTES = SIZE / Byte.SIZE (8);
    }

    private static void floatSizeAndBytes() {
        System.out.println(Float.SIZE); // 32
        System.out.println(Float.BYTES); // 4 --> public static final int BYTES = SIZE / Byte.SIZE (8);
    }

    private static void doubleSizeAndBytes() {
        System.out.println(Double.SIZE); // 64
        System.out.println(Double.BYTES); // 8 --> public static final int BYTES = SIZE / Byte.SIZE (8);
    }
}
