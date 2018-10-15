package kyu8;

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