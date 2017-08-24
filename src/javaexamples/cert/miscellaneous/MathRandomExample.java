package javaexamples.cert.miscellaneous;

public class MathRandomExample {

    public static void main(String[] args){
        System.out.println(Math.random()); // number between 0-1 - returns a double
        // To get a random number between 0 and 6, we would need to do the following:
        // Cast it to an int since it is a double.
        // Multiply by 6 to get a value between 0 and 6
        // Add 1 to get a value between 1 and 6
        int randomNumber = (int)(Math.random() * 6) + 1;
        System.out.println(randomNumber);
    }
}
