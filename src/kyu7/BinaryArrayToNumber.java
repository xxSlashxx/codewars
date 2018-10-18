package kyu7;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of one's and zero's convert the equivalent binary value to an integer.
 * Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
 */
public class BinaryArrayToNumber
{
    public static void main(String[] args)
    {
        System.out.println(ConvertBinaryArrayToInt(Arrays.asList(0, 0, 0, 1))); // => 1
        System.out.println(ConvertBinaryArrayToInt(Arrays.asList(0, 0, 1, 0))); // => 2
        System.out.println(ConvertBinaryArrayToInt(Arrays.asList(1, 1, 1, 1))); // => 15
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary)
    {
        int sum = 0;

        for (int i = 0; i < binary.size(); i++)
        {
            if (binary.get(i) == 1)
            {
                sum = (int) (sum + Math.pow(2, binary.size() - 1 - i));
            }
        }

        return sum;
    }
}