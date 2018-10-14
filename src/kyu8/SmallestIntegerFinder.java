package kyu8;

/**
 * Given an array of integers your solution should find the smallest integer.
 */
public class SmallestIntegerFinder
{
    public static void main(String[] args)
    {
        System.out.println(findSmallestInt(new int[]{78, 56, 232, 12, 11, 43})); //11
        System.out.println(findSmallestInt(new int[]{34, 15, 88, 2})); //2
        System.out.println(findSmallestInt(new int[]{34, -345, -1, 100})); //-345
    }

    public static int findSmallestInt(int[] args)
    {
        int smallestInt = 0;

        for (int i = 0; i < args.length; i++)
        {
            if (i == 0 || args[i] < smallestInt)
            {
                smallestInt = args[i];
            }
        }

        return smallestInt;
    }
}