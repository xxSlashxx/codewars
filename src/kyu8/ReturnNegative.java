package kyu8;

/**
 * In this simple assignment you are given a number and have to make it negative. But maybe the number is already negative?
 * Notes:
 * <p>
 * The number can be negative already, in which case no change is required.
 * Zero (0) is not checked for any specific sign. Negative zeros make no mathematical sense.
 */
public class ReturnNegative
{
    public static void main(String[] args)
    {
        System.out.println(makeNegative(1));
        System.out.println(makeNegative(-5));
        System.out.println(makeNegative(0));
    }

    public static int makeNegative(final int x)
    {
        return (x > 0) ? -x : x;
    }
}