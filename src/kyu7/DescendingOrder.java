package kyu7;

import java.util.Arrays;
import java.util.Collections;

/**
 * Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in
 * descending order. Essentially, rearrange the digits to create the highest possible number.
 */
public class DescendingOrder
{
    public static void main(String[] args)
    {
        System.out.println(sortDesc(21445)); //should return 54421
        System.out.println(sortDesc(145263)); //should return 654321
        System.out.println(sortDesc(987654321)); //should return 123456789
    }

    public static int sortDesc(final int num)
    {
        String[] list = String.valueOf(num).split("");
        Arrays.sort(list, Collections.reverseOrder());
        return Integer.parseInt(String.join("", list));
    }
}