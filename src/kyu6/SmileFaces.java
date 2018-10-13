package kyu6;

import java.util.Arrays;
import java.util.List;

public class SmileFaces
{
    public static void main(String[] args)
    {
        System.out.println(
                countSmileys(Arrays.asList(new String[]{":)", ";(", ";}", ":-D"})));       // should return 2;
        System.out.println(
                countSmileys(Arrays.asList(new String[]{";D", ":-(", ":-)", ";~)"})));     // should return 3;
        System.out.println(
                countSmileys(Arrays.asList(new String[]{";]", ":[", ";*", ":$", ";-D"}))); // should return 1;
    }

    public static int countSmileys(List<String> arr)
    {
        int counter = 0;

        for (String smiley : arr)
        {
            if (smiley.matches("^[:|;][-|~]?[\\)|D]$"))
            {
                counter++;
            }
        }

        return counter;
    }
}
