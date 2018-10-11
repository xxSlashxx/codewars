package kyu7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Return the number (count) of vowels in the given string. We will consider a, e, i, o, and u as vowels for this Kata.
 * The input string will only consist of lower case letters and/or spaces.
 */
public class Vowels
{
    public static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args)
    {
        System.out.println(getCount("abracadabra"));
    }

    public static int getCount(String str)
    {
        int vowelsCount = 0;
        char[] inputArray = str.toCharArray();

        for (int i = 0; i < inputArray.length; i++)
        {
            if (vowels.contains(inputArray[i]))
            {
                vowelsCount++;
            }
        }

        return vowelsCount;
    }
}
