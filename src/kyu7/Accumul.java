package kyu7;

/**
 * This time no story, no theory. The examples below show you how to write function accum:
 * <p>
 * Examples:
 * <p>
 * Accumul.accum("abcd");    // "A-Bb-Ccc-Dddd"
 * Accumul.accum("RqaEzty"); // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
 * Accumul.accum("cwAt");    // "C-Ww-Aaa-Tttt"
 * The parameter of accum is a string which includes only letters from a..z and A..Z.
 */
public class Accumul
{
    public static void main(String[] args)
    {
        System.out.println(accum("abcd")); // "A-Bb-Ccc-Dddd"
        System.out.println(accum("RqaEzty")); // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(accum("cwAt")); // "C-Ww-Aaa-Tttt"
    }

    public static String accum(String s)
    {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            if (i > 0)
            {
                result.append("-");
            }

            result.append(Character.toUpperCase(chars[i]));

            for (int j = 0; j <= i; j++)
            {
                result.append(Character.toLowerCase(chars[i]));
            }
        }

        return result.toString();
    }
}