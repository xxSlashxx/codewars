package kyu8;

/**
 * Complete the solution so that it reverses the string value passed into it.
 */
public class ReversedStrings
{
    public static void main(String[] args)
    {
        System.out.println(reverse("world"));
    }

    public static String reverse(String text)
    {
        return new StringBuilder(text).reverse().toString();
    }
}