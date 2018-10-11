package kyu6;

import java.util.StringTokenizer;

/**
 * Write a function that takes in a string of one or more words, and returns the same string, but with all five or more
 * letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces.
 * Spaces will be included only when more than one word is present.
 */
public class SpinWords
{
    public static void main(String[] args)
    {
        System.out.println(spinWords("Hey fellow warriors"));//=> returns "Hey wollef sroirraw"
        System.out.println(spinWords("This is a test"));//=> returns "This is a test"
        System.out.println(spinWords("This is another test"));//=> returns "This is rehtona test"
    }

    public static String spinWords(String sentence)
    {
        StringTokenizer stringTokenizer = new StringTokenizer(sentence, " ");
        StringBuilder result = new StringBuilder();

        while (stringTokenizer.hasMoreTokens())
        {
            String token = stringTokenizer.nextToken();

            if (token.length() >= 5)
            {
                token = new StringBuilder(token).reverse().toString();
            }

            result.append(token).append(" ");
        }

        return result.toString().trim();
    }
}