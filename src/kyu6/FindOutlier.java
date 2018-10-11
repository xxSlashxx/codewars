package kyu6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers. The
 * array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer
 * N. Write a method that takes the array as an argument and returns this "outlier" N.
 */
public class FindOutlier
{
    public static void main(String[] args)
    {
        //Should return: 11 (the only odd number)
        System.out.println(find(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));

        //Should return: 160 (the only even number)
        System.out.println(find(new int[]{160, 3, 1719, 19, 11, 13, -21}));
    }

    static int find(int[] integers)
    {
        Map<String, List<Integer>> values = new HashMap<>();
        values.put("Even", new ArrayList<>());
        values.put("Odd", new ArrayList<>());

        for (int i = 0; i < integers.length; i++)
        {
            if (integers[i] % 2 == 0)
            {
                values.get("Even").add(integers[i]);
            }
            else
            {
                values.get("Odd").add(integers[i]);
            }
        }

        return values.get("Even").size() == 1 ? values.get("Even").get(0) : values.get("Odd").get(0);
    }
}