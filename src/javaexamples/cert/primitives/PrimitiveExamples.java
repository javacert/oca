package javaexamples.cert.primitives;


// An implicit narrowing primitive conversion may be used if all of the following conditions are satisfied:
// 1. The expression is a compile time constant expression of type byte, char, short, or int.
// 2. The type of the variable is byte, short, or char.
// 3. The value of the expression (which is known at compile time, because it is a constant expression) is
// representable in the type of the variable.
// Note that implicit narrowing conversion does not apply to long or double.
// So, char ch = 30L; will fail even though 30 is representable in char.

// Important to remember the following:
// Why can I assign an integer literal to a short type variable but not to a short type method parameter?
// In order to understand why the assignment type-conversion works whilst the invocation one is rejected,
// one has to refer to the Java Language Specification topic for both narrowing primitive conversions and
// the context of that conversion: assignment context and invocation context.
// According to the JLS, the narrowing primitive conversion is allowed in assignment context if:
// 'A narrowing primitive conversion may be used if the type of the variable is byte, short, or char,
// and the value of the constant expression is representable in the type of the variable.'
// No such narrowing primitive conversion is allowed in the invocation context.
// But why if the compiler knows I'm passing a constant that a short can hold (as in the assignment) it doesn't
// let it compile? I mean, what is the difference between them?
// The JLS must not have wanted to burden compilers with this additional logic.
// In the invocation case, the argument which is type-matched to the formal parameter is an expression -
// the compiler already has to determine the type, but it shouldn't need to also check if the expression's
// value can also safely be narrowed. In this case, being a constant, it is clear to us that it can be,
// but in execution context the compiler is allowed to not bother with that check, and is in-fact correct to disallow it.
// It should be fairly clear that when expressions are allowed, it would be much easier for bugs to creep in where
// narrowing cannot be done without losing precision, so the JLS and compilers just disallow it in all cases.
// The same is true in numeric context, so the declaration:
// short a = 5; short b = a * 5;
// ... is similarly not allowed, despite being clearly comprised of constants which narrow correctly.
public class PrimitiveExamples {

    // Capacities:
    // byte = 128.0 - 127.0,
    // long = 9.223372036854776E18 - 9.223372036854776E18,
    // int = 2.147483648E9 - 2.147483647E9,
    // char = 65535.0,
    // short = 32768.0 - 32767.0

    public static void main(String[] args){
        byteExamples();
        shortExamples();
        charExamples();
        floatExamples();
        doubleExamples();
        longExamples();

        // passIntToByteMethod((short)10);
        // passIntToByteMethod(10);
        // passIntToByteMethod((char)10);
        passIntToByteMethod((byte)10);

        // passIntToCharMethod((short)10);
        // passIntToCharMethod(10);
        // passIntToCharMethod((byte)10);
        passIntToCharMethod((char)10);

        // passIntToShortMethod((char)10);
        // passIntToShortMethod(10);
        passIntToShortMethod((byte)10);
        passIntToShortMethod((short)10);

        passIntToIntMethod((byte)10);
        passIntToIntMethod((short)10);
        passIntToIntMethod((char)10);
        passIntToIntMethod(10);

        passIntToLongMethod((byte)10);
        passIntToLongMethod((short)10);
        passIntToLongMethod((char)10);
        passIntToLongMethod(10); // Both work fine since long can hold a short and an int

        passIntToFloatMethod(10);
        passIntToFloatMethod((short)10);
        passIntToFloatMethod(1.1f);
        // passIntToFloatMethod(1.1d);

        passIntToDoubleMethod((byte)10);
        passIntToDoubleMethod((short)10);
        passIntToDoubleMethod((char)10);
        passIntToDoubleMethod(10);
        passIntToDoubleMethod((long)10);
        passIntToDoubleMethod((float)10);
        passIntToDoubleMethod(1.1f);

        double someIntReturnA = returnShortFromIntMethod();
        double someDoubleReturnA = returnShortFromDoubleMethod();
        double someDoubleReturnB = returnIntFromDoubleMethod();
    }

    private static void floatExamples() {
        float a = 1.1F;
        float b = 1.1f; // You can have lower or upper case, both are the same
        System.out.println(a); // 1.1
        System.out.println(b); // 1.1

        // float c = 43e1; // Does not compile - 43e1 is a double with value 430.0
    }

    private static void shortExamples() {
        short a = 10;
        //short b = 99999; // Cannot fit this int value
    }

    // Although it is not required for the exam to know the integral values of characters, it is good to know that all
    // English letters (upper case as well as lower case) as well as 0-9 are below 127 and so are assignable to byte.
    private static void charExamples() {
        //char a = 'BF'; // char can only have one letter
        char a = 'B';
        char b = 65535;
        //char c = 65536; // Incompatible types, found int, requires char

        // Watch what happens when we increment, decrement a char
        System.out.println(a++); // B
        System.out.println(a++); // C
        System.out.println(a++); // D
        System.out.println(a--); // E
        System.out.println(a--); // D
        System.out.println(a); // C

        // Primitive char type is int-compatible and it will change its ASCII value by 1 (see table below)
        char d = 65; // 65 is letter A
        System.out.println(d); // A
        System.out.println(d++); // A
        System.out.println(d++); // B
        System.out.println(d++); // C
        System.out.println(d--); // D
        System.out.println(d--); // C
        System.out.println(d); // B
    }

    private static void doubleExamples() {
        double a = 1.1d;
        double b = 1.1D; // You can have lower or upper case, both are the same
        double c = 43e1; // 430.0 - watch for this one!
        double d = 290e2; // 29000.0 - watch for this one as well!
        double e = .75; // You don't require the leading zero!
        System.out.println(a); // 1.1
        System.out.println(b); // 1.1
        System.out.println(c); // 1.1
        System.out.println(d); // 1.1
        System.out.println(e); // 0.75
    }

    private static void byteExamples() {
        // -128 to 127
        // byte a = -129; // Incompatible types, found int, requires byte
        byte a = -128;
        byte b = 10;
        byte c = 99;
        byte d = 127;
        // byte e = 128;
        // byte f = 200; // Incompatible types, found int, requires byte
    }

    private static void longExamples() {
        long l1 = 3; // gets wider implicitly
        long l2 = 0x99ffC;
        System.out.println(l2); // 630780
        long l3 = 0x99ffCL; // L is for long here
        System.out.println(l3); // 630780
        long l4 = 012; // Octals can be assigned to longs
        System.out.println(l4); // 10
        System.out.println(2L * 2l * 2); // 8 - public void println(long x)
    }

    private static void passIntToByteMethod(byte x) {
    }

    private static void passIntToCharMethod(char x) {
    }

    private static void passIntToShortMethod(short x) {
    }

    private static void passIntToIntMethod(int x) {
    }

    private static void passIntToLongMethod(long x) {
    }

    private static void passIntToFloatMethod(float x) {
    }

    private static void passIntToDoubleMethod(double x) {
    }

    private static int returnShortFromIntMethod() {
        // You can return an short since we are assigning a short to an int
        // return (long)(10 * Math.random()); // This doesn't compile
        return (short)(10 * Math.random());
    }

    private static double returnShortFromDoubleMethod() {
        // You can return an short since we are assigning a short to a double
        return (short)(10 * Math.random());
    }

    private static double returnIntFromDoubleMethod() {
        // You can return an int since we are assigning an int to a double
        return 10 * Math.random();
    }
}

/*      Dec  Char                         Dec  Char     Dec  Char     Dec  Char
        ---------                         ---------     ---------     ----------
        0  NUL (null)                      32  SPACE     64  @         96  `
        1  SOH (start of heading)          33  !         65  A         97  a
        2  STX (start of text)             34  "         66  B         98  b
        3  ETX (end of text)               35  #         67  C         99  c
        4  EOT (end of transmission)       36  $         68  D        100  d
        5  ENQ (enquiry)                   37  %         69  E        101  e
        6  ACK (acknowledge)               38  &         70  F        102  f
        7  BEL (bell)                      39  '         71  G        103  g
        8  BS  (backspace)                 40  (         72  H        104  h
        9  TAB (horizontal tab)            41  )         73  I        105  i
        10  LF  (NL line feed, new line)    42  *         74  J        106  j
        11  VT  (vertical tab)              43  +         75  K        107  k
        12  FF  (NP form feed, new page)    44  ,         76  L        108  l
        13  CR  (carriage return)           45  -         77  M        109  m
        14  SO  (shift out)                 46  .         78  N        110  n
        15  SI  (shift in)                  47  /         79  O        111  o
        16  DLE (data link escape)          48  0         80  P        112  p
        17  DC1 (device control 1)          49  1         81  Q        113  q
        18  DC2 (device control 2)          50  2         82  R        114  r
        19  DC3 (device control 3)          51  3         83  S        115  s
        20  DC4 (device control 4)          52  4         84  T        116  t
        21  NAK (negative acknowledge)      53  5         85  U        117  u
        22  SYN (synchronous idle)          54  6         86  V        118  v
        23  ETB (end of trans. block)       55  7         87  W        119  w
        24  CAN (cancel)                    56  8         88  X        120  x
        25  EM  (end of medium)             57  9         89  Y        121  y
        26  SUB (substitute)                58  :         90  Z        122  z
        27  ESC (escape)                    59  ;         91  [        123  {
        28  FS  (file separator)            60  <         92  \        124  |
        29  GS  (group separator)           61  =         93  ]        125  }
        30  RS  (record separator)          62  >         94  ^        126  ~
        31  US  (unit separator)            63  ?         95  _        127  DEL */
