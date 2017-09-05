package javaexamples.cert.strings;

// Notes:
// StringBuilder is in the java.lang package
// StringBuilder does NOT override the equals method, so it will always be a reference comparison.
// StringBuilder does NOT have a toCharArray method.
// |-- String does have that method and also has a constructor that accepts a char array.
// StringBuilder does NOT have trim method (has trimToSize though).
// StringBuilder DOES have reverse method, but String does not.
// StringBuilder's toString() will always return a new String object - watch for its usage in comparison with Strings.

// Some common methods:
// 1) setLength(int) - Sets the length of this String buffer. If the newLength argument is less than the current
//    length of the string buffer, the string buffer is truncated to contain exactly the number of characters given
//    by the newLength argument.
// 2) ensureCapacity(int) - Ensures that the capacity of the buffer is at least equal to the specified minimum.
// 3) append(CharSequence s, int start, int end) - Appends a sub-sequence of the specified CharSequence to this sequence.
// 4) insert(int dstOffset, CharSequence s, int start, int end) - Inserts a sub-sequence of the specified CharSequence into this sequence.
// 5) replace(int start, int end, String str) - Replaces the characters in a substring of this sequence with characters in the specified String.
// 6) substring(int start, int end) - Returns a new String that contains a sub-sequence of characters currently contained in this sequence.
// 7) delete(int start, int end) - deletes characters of length end - start
public class StringBuilderExamples {

    public static void main(String[] args){
        builderExample1();
        insertExample();
        insertBooleanExample();
        insertBeyondSizeExample();
        toStringNotRequiredExample();
        methodChainingProblems();
        substringExample();
        reverseExample();
        someOtherStringBuilderMethods();
        stringBuilderCapacity();
        appendExample();
        clearingAStringBuilder();
        concatenateStringBuilderWithString();
        deleteNothingExample();
        appendingTrueFalse();
        settingCapacityExample();
        ensureCapacityExample();
        increaseCapacityExample();
        setLengthExample();
    }

    private static void builderExample1() {
        StringBuilder s1 = new StringBuilder("meow");
        StringBuilder s2 = new StringBuilder("meow");

        // Reference comparison and they are not the same
        if (s1 == s2){
            System.out.println("A"); // Not output
        }

        // StringBuilder does not override Object's .equals() function, so we have a reference comparison here again
        if (s1.equals(s2)){
            System.out.println("B"); // Not output
        }

        // This compares the 2 Strings fine and returns true
        if (s1.toString().equals(s2.toString())){
            System.out.println("C"); // Outputs C
        }

        // Will not compile as an invalid comparison 9 StringBuilder reference to a String
/*        if (s1 == "meow"){
            System.out.println("D");
        }*/

        // This is a tricky one - it appears at first sight that we have a String pool reference comparison here.
        // However look in the implementation and you will find: return new String(value, 0, count);
        // So we do not intern the String in this case using the new String approach.
        if(s1.toString() == "meow"){
            System.out.println("E"); // Not output
        }
    }

    private static void insertBooleanExample() {
        StringBuilder sb = new StringBuilder("aAaA");
        System.out.println("Last Index of A = " + sb.lastIndexOf("A")); // Last Index of A = 3
        sb.insert(sb.lastIndexOf("A"), true); // remember insert inserts before the index
        System.out.println("insertBooleanExample = " + sb); // insertBooleanExample = aAatrueA
    }

    private static void insertExample() {
        StringBuilder sb = new StringBuilder("123");
        char[] name = {'J', 'a', 'v', 'a'}; // (int index, char[] str, int offset, int len)
        // Remember when we have a length parameter as below, the number of characters inserted should match that length, so 3 in this case
        sb.insert(1, name, 1, 3);
        System.out.println(sb); // 1ava23
    }


    private static void insertBeyondSizeExample() {
        // Insert must be a valid index otherwise StringIndexOutOfBoundsException is thrown
        StringBuilder sb = new StringBuilder("cl").insert(2, "own");
        System.out.println(sb); // clown
        sb = new StringBuilder("cl").insert(3, "own"); // StringIndexOutOfBoundsException
        System.out.println(sb); // Never gets here
    }

    private static void toStringNotRequiredExample() {
        System.out.println(new StringBuilder("You don't need to use toString with me!"));
        // When you look at the underlying implementation you can see why println does not need to use the toString:
        // public void println(Object x) {
        //     String s = String.valueOf(x);
        //     synchronized (this) {
        //         print(s);
        //         newLine();
        //     }
        // }

        // public static String valueOf(Object obj) {
        //     return (obj == null) ? "null" : obj.toString();
        // }

        String lookAtThis = new StringBuilder("But you do need toString when assigning to a String!").toString();
    }

    private static void methodChainingProblems() {
        // The following line will NOT compile because the sb reference is not available until after the chained calls have completed.
        //StringBuilder sb = new StringBuilder("radical").insert(sb.length(), "robots");

        StringBuilder sb = new StringBuilder("radical");
        sb.insert(sb.length(), "robots"); // Remember it inserts before the index, so at the end in this case
        System.out.println(sb); // radicalrobots

        sb.insert(sb.length() + 1, "arecool"); // StringIndexOutOfBoundsException because of the +1
        System.out.println(sb); // radicalrobots
    }

    private static void substringExample() {
        StringBuilder sb = new StringBuilder("radical");
        // Again the index is from the position before 2, so r(0), a(1), d(2), so from d forward
        // The parameter in this example is the start index
        System.out.println(sb.substring(2)); // dical

        sb = new StringBuilder("radical");
        // The parameter in this example is the start and the end index
        System.out.println(sb.substring(2, 4)); // di

        // Now be Careful here!
        sb = new StringBuilder("radical");
        sb.substring(2, 4);
        System.out.println(sb); // "radical"

        // StringBuilder subString returns a new String which makes sense, you would remove characters for the original
        // if you wanted to modify the original StringBuilder value (append, delete, deleteCharAt all return existing ref)
        // From StringBuilder:
        //public String substring(int start, int end) {
        //    if (start < 0)
        //        throw new StringIndexOutOfBoundsException(start);
        //    if (end > count)
        //        throw new StringIndexOutOfBoundsException(end);
        //    if (start > end)
        //        throw new StringIndexOutOfBoundsException(end - start);
        //    return new String(value, start, end - start);
        //}

        // StringBuilder has a delete which returns reference to current StringBuilder
        //public StringBuilder delete(int start, int end) {
        //    super.delete(start, end);
        //    return this;
        //}

        // And even more careful here!
        sb = new StringBuilder("radical");
        sb.append("more").insert(5, "Hello").substring(2, 4); // append and insert modify original, but not substring
        System.out.println(sb); // "radicHelloalmore"
    }

    private static void reverseExample() {
        StringBuilder sb = new StringBuilder("radical");
        System.out.println(sb.reverse()); // lacidar

        // Note that reverse is NOT available for String
        String a = "radical";
        //a.reverse();
    }

    private static void someOtherStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("abc");
        char c = sb.charAt(1);
        sb.insert(1, "def"); // Does not exist in String
        int num = sb.length();

        System.out.println(c); // b
        System.out.println(sb); // adefbc
        System.out.println(num); // 6

        // Returning the reference like this makes no difference
        // sb.insert(1, "def"); would apply the changes either way
        sb = sb.insert(1, "def"); // Does not exist in String
        System.out.println(sb); // adefdefbc
    }

    // The initial capacity of a StringBuilder is 16, plus the length of the String Argument
    private static void stringBuilderCapacity() {
        StringBuilder s = new StringBuilder("1Z0");
        s.append("-808"); // This will not factor into the initial capacity
        System.out.println("StringBuilder length() is " + s.length()); // StringBuilder length() is 7
        System.out.println("StringBuilder capacity() is " + s.capacity()); // StringBuilder capacity() is 19

        s = new StringBuilder("1234567890");
        System.out.println("StringBuilder capacity() is " + s.capacity()); // StringBuilder capacity() is 26 (10 + 16)
        s.append("12345678901234567890"); // Let's bust the current capacity
        // New capacity is calculated using: Twice the old capacity, plus 2.
        System.out.println("StringBuilder capacity() is " + s.capacity()); // StringBuilder capacity() is 54 ((26 *2) + 2)
    }

    private static void appendExample() {
        char[] chars = {'1', 'Z', '0', '-', '8', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(chars, 0, chars.length-1); // Start at index 0, include 5 characters (note output should always match the length paramater)
        System.out.println(sb); // 1Z0-8 (Note the output is 5 characters matching the length)
        sb.append('0'); // NOTE HERE - this is fine!
        System.out.println(sb); // 1Z0-80
        sb.append("8");
        System.out.println(sb); // 1Z0-808

        // These are the overloaded methods for append - all return a StringBuilder reference
        //public StringBuilder append(StringBuffer sb) {
        //public StringBuilder append(boolean b) {
        //public StringBuilder append(char c) {
        //public StringBuilder append(int i) {
        //public StringBuilder append(long lng) {
        //public StringBuilder append(float f) {
        //public StringBuilder append(double d) {
        //public StringBuilder append(char[] str, int offset, int len) {
        //public StringBuilder append(char[] str) {
        //public StringBuilder append(CharSequence s, int start, int end) {
        //public StringBuilder append(CharSequence s) {

        StringBuilder goingBeyond = new StringBuilder();
        goingBeyond.append(new char[]{'d', 'a', 'v', 'i', 'd'}, 2, 4); // java.lang.ArrayIndexOutOfBoundsException - 4 characters not available
        System.out.println(goingBeyond);

        StringBuilder anotherSb = new StringBuilder();
        anotherSb.append(new char[]{'d', 'a', 'v', 'i', 'd'}, 2, 3); // start at index 2, include 3 characters
        System.out.println(anotherSb); // vid

        anotherSb = new StringBuilder();
        anotherSb.append(new char[]{'d', 'a', 'v', 'i', 'd'}, 0, 4); // start at position 0, include 4 characters
        System.out.println(anotherSb); // davi

        anotherSb = new StringBuilder();
        anotherSb.append("hello", 0, 4); // append character from string "hello" between 0-4 (4 characters)
        System.out.println(anotherSb); // hell
    }

    private static void clearingAStringBuilder() {
        StringBuilder sb = new StringBuilder("ABCDEF");
        sb.delete(0, sb.length()); // start - end index (length is 6 so delete 0 thru index 6)
        System.out.println(sb.length()); // 0

        sb = new StringBuilder("ABCDEF");
        sb.setLength(0);
        System.out.println(sb.length()); // 0

        sb = new StringBuilder("ABCDEF");
        sb = new StringBuilder();
        System.out.println(sb.length()); // 0

        // Edge Case
        sb = new StringBuilder("START");
        sb.setLength(30);
        sb.append("END");
        System.out.println(sb + " " + sb.length()); // START                         END 33
    }

    private static void concatenateStringBuilderWithString() {
        // You can concatenate a StringBuilder with String directly without using toString method since that happens
        // implicitly.
        String someString = new StringBuilder("ABC") + "DEF";
        System.out.println(someString);
    }

    private static void deleteNothingExample() {
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb.delete(1, 1)); // abc - note that this deletes nothing!
        System.out.println(sb.delete(1, 10)); // a - note that this deletes all the characters and does not throw a RuntimeException
        System.out.println(sb.delete(2, 1)); // java.lang.StringIndexOutOfBoundsException
    }

    private static void appendingTrueFalse() {
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb.append(true));            // abctrue
        System.out.println(sb.append(false));           // abctruefalse
        System.out.println(sb.append(Boolean.TRUE));    // abctruefalsetrue
        System.out.println(sb.append(Boolean.FALSE));   // abctruefalsetruefalse
    }

    private static void settingCapacityExample() {
        StringBuilder sb1 = new StringBuilder(100); // public StringBuilder(int capacity)

        StringBuilder sb2 = new StringBuilder(); // default capacity is 16
        sb2.ensureCapacity(20); // (Current capacity (16) * 2) + 2 = 34
        System.out.println(sb2.capacity());

        StringBuilder sb3 = new StringBuilder();
        sb3.ensureCapacity(100); // 100
        System.out.println(sb3.capacity());
    }

    private static void ensureCapacityExample() {
        // The ensure capacity method ensures that the capacity is at least equal to the specified minimum. If the current
        // capacity is less that the argument, then a new internal array is allocated with a greater capacity.
        // The new capacity is twice the old capacity plus 2.

        // 1) Initial Capacity = 16 + 6 (new StringBuilder("ABCDEF")) = 22
        StringBuilder sb = new StringBuilder("ABCDEF");
        sb.delete(4, 6); // Has no impact to initial capacity!

        sb.ensureCapacity(22);
        System.out.println(sb.capacity()); // 22 - No change since current capacity is already 22

        sb.ensureCapacity(23); // (Current capacity (22) * 2) + 2
        System.out.println(sb.capacity()); // 46
    }

    private static void increaseCapacityExample() {
        StringBuilder sb = new StringBuilder("ABCDEF");
        System.out.println(sb.capacity()); // 22

        sb.append("12345678901234567890"); // Increase capacity beyond 22 - recalculate capacity: (Current capacity (22) * 2) + 2
        System.out.println(sb.capacity()); // 46
    }

    private static void setLengthExample() {
        StringBuilder sb = new StringBuilder("12345678");
        sb.setLength(5); // "12345"
        sb.setLength(10); // "12345     "
        System.out.println(sb.length()); // 10
    }
}