package kyu8;

/**
 * Very simple, given a number, find its opposite.
 */
public class OppositeNumber
{
    public static void main(String[] args)
    {
        System.out.println(opposite(1)); //-1
        System.out.println(opposite(14)); //-14
        System.out.println(opposite(-34)); //34
    }

    public static int opposite(int number)
    {
        return -number;
    }
}