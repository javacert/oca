package javaexamples.cert.wrappers;

// 1. Boolean class has two constructors - Boolean(String) and Boolean(boolean) The String constructor allocates a
// Boolean object representing the value true if the string argument is not null and is equal, ignoring case, to the
// string "true". Otherwise, allocate a Boolean object representing the value false. Examples: new Boolean("True")
// produces a Boolean object that represents true. new Boolean("yes") produces a Boolean object that represents false.

// 2. Boolean class has two static helper methods for creating booleans - parseBoolean and valueOf.
// Boolean.parseBoolean(String ) method returns a primitive boolean and not a Boolean object (Note - Same is with the
// case with other parseXXX methods such as Integer.parseInt - they return primitives and not objects).
// The boolean returned represents the value true if the string argument is not null and is equal, ignoring case,
// to the string "true". Boolean.valueOf(String ) and its overloaded Boolean.valueOf(boolean ) version, on the other
// hand, work similarly but return a reference to either Boolean.TRUE or Boolean.FALSE wrapper objects. Observe that
// they dont create a new Boolean object but just return the static constants TRUE or FALSE defined in Boolean class.

// 3. When you use the equality operator ( == ) with booleans, if exactly one of the operands is a Boolean wrapper,
// it is first unboxed into a boolean primitive and then the two are compared (JLS 15.21.2). If both are Boolean
// wrappers, then their references are compared just like in the case of other objects. Thus,
// new Boolean("true") == new Boolean("true") is false, but new Boolean("true") == Boolean.parseBoolean("true") is true.
public class BooleanWrapperExamples {

    public static void main(String[] args){

        System.out.println(Boolean.parseBoolean("true") == true); // true - remember parseBoolean returns a primitive
        System.out.println(Boolean.parseBoolean("TrUe") == new Boolean(null)); // false - primitive compared to a wrapper object containing false
        System.out.println(new Boolean("TrUe") == new Boolean(true)); // false - even though both a wrapper containing true, they are not the same object
        // System.out.println(new Boolean() == false); // Boolean does not have a no-arg constructor
        System.out.println(new Boolean("true") == Boolean.TRUE); // false - both are wrapper objects containing true, but they are not the same objects
        System.out.println(new Boolean("no") == false); // true - boolean unboxed to false primitive (see rule 3)
    }
}
