package kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Input
 *
 * a string strng of n positive numbers (n = 0 or n >= 2)
 * Let us call weight of a number the sum of its digits. For example 99 will have "weight" 18, 100 will have "weight" 1.
 *
 * Two numbers are "close" if the difference of their weights is small.
 *
 * Task:
 * For each number in strng calculate its "weight" and then find two numbers of strng that have:
 *
 * the smallest difference of weights ie that are the closest
 * with the smallest weights
 * and with the smallest indices (or ranks, numbered from 0) in strng
 * Output:
 *
 * an array of two arrays, each subarray in the following format:
 * [number-weight, index in strng of the corresponding number, original corresponding number instrng]
 *
 * or a pair of two subarrays (Haskell, Clojure, FSharp) or an array of tuples (Elixir, C++)
 *
 * or a (char*) in C mimicking an array of two subarrays or a string
 *
 * or a matrix in R (2 rows, 3 columns, no columns names)
 *
 * The two subarrays are sorted in ascending order by their number weights if these weights are different, by their indexes in the string if they have the same weights.
 *
 * Examples:
 * Let us call that function closest
 *
 * strng = "103 123 4444 99 2000"
 * the weights are 4, 6, 16, 18, 2 (ie 2, 4, 6, 16, 18)
 *
 * closest should return [[2, 4, 2000], [4, 0, 103]] (or ([2, 4, 2000], [4, 0, 103])
 * or [{2, 4, 2000}, {4, 0, 103}] or ... depending on the language)
 * because 2000 and 103 have for weight 2 and 4, ther indexes in strng are 4 and 0.
 * The smallest difference is 2.
 * 4 (for 103) and 6 (for 123) have a difference of 2 too but they are not
 * the smallest ones with a difference of 2 between their weights.
 */
public class ClosestWeight
{
    public static void main(String[] args)
    {
        System.out.println(closest("103 123 4444 99 2000"));
        System.out.println(closest("80 71 62 53"));
        System.out.println(closest("444 2000 445 544"));
    }

    public static int[][] closest(String strng)
    {
        if(strng.isEmpty())
        {
            return new int[][]{};
        }

        String[] values = strng.split("\\s");
        List<ClosestWeightObject> closestWeightObjects = new ArrayList<>();

        for (int i = 0; i < values.length; i++)
        {
            closestWeightObjects.add(new ClosestWeightObject(calculateNumberWeight(values[i]), i, values[i]));
        }

        for (ClosestWeightObject closestWeightObjectOuter : closestWeightObjects)
        {
            Integer smallestDifference = null;

            for (ClosestWeightObject closestWeightObjectInner : closestWeightObjects)
            {
                if (closestWeightObjectOuter != closestWeightObjectInner)
                {
                    int tempDifference;

                    if (closestWeightObjectOuter.getNumberWeight() > closestWeightObjectInner.getNumberWeight())
                    {
                        tempDifference = closestWeightObjectOuter.getNumberWeight() - closestWeightObjectInner.getNumberWeight();
                    }
                    else
                    {
                        tempDifference = closestWeightObjectInner.getNumberWeight() - closestWeightObjectOuter.getNumberWeight();
                    }

                    if (smallestDifference == null || tempDifference < smallestDifference)
                    {
                        smallestDifference = tempDifference;
                    }
                }
            }

            closestWeightObjectOuter.setSmallestDifference(smallestDifference);
        }

        closestWeightObjects.sort(Comparator.comparing(ClosestWeightObject::getSmallestDifference).thenComparing(ClosestWeightObject::getNumberWeight).thenComparing(ClosestWeightObject::getIndex));

        return new int[][]{closestWeightObjects.get(0).toIntArray(), closestWeightObjects.get(1).toIntArray()};
    }

    private static int calculateNumberWeight(String value)
    {
        int numberWeight = 0;
        String[] digits = value.split("");

        for (String digit : digits)
        {
            numberWeight = numberWeight + Integer.valueOf(digit);
        }

        return numberWeight;
    }

    private static class ClosestWeightObject
    {
        private int numberWeight;
        private int index;
        private String originalNumber;
        private int smallestDifference;

        public ClosestWeightObject(int numberWeight, int index, String originalNumber)
        {
            this.numberWeight = numberWeight;
            this.index = index;
            this.originalNumber = originalNumber;
        }

        public int getNumberWeight()
        {
            return numberWeight;
        }

        public int getIndex()
        {
            return index;
        }

        public int getSmallestDifference()
        {
            return smallestDifference;
        }

        public void setSmallestDifference(int smallestDifference)
        {
            this.smallestDifference = smallestDifference;
        }

        public int[] toIntArray()
        {
            return new int[]{numberWeight, index, Integer.valueOf(originalNumber)};
        }
    }
}