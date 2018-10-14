package kyu8;

/**
 * Write a function called repeatStr which repeats the given string string exactly n times.
 */
public class StringRepeat
{
    public static void main(String[] args)
    {
        System.out.println(repeatStr(4, "a"));
        System.out.println(repeatStr(6, "I"));
        System.out.println(repeatStr(5, "Hello"));
    }

    public static String repeatStr(final int repeat, final String string)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < repeat; i++)
        {
            result.append(string);
        }

        return result.toString();
    }
}