package kyu6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given an array, find the int that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 */
public class FindOdd
{
    public static void main(String[] args)
    {
        System.out.println(findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        System.out.println(findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        System.out.println(findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
    }

    public static int findIt(int[] a)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int odd = 0;

        for (int i = 0; i < a.length; i++)
        {
            if (map.containsKey(a[i]))
            {
                Integer oldValue = map.get(a[i]);
                oldValue++;
                map.put(a[i], oldValue);
            }
            else
            {
                map.put(a[i], 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> next = iterator.next();

            if (next.getValue() % 2 != 0)
            {
                odd = next.getKey();
                break;
            }
        }

        return odd;
    }
}