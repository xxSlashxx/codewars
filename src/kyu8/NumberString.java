package kyu8;

/**
 * We need a function that can transform a number into a string.
 */
public class NumberString
{
    public static void main(String[] args)
    {
        System.out.println(numberToString(123));
        System.out.println(numberToString(999));
    }

    public static String numberToString(int num)
    {
        return String.valueOf(num);
    }
}