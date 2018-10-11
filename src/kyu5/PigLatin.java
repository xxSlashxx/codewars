package kyu5;

import java.util.StringTokenizer;

/**
 * Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks
 * untouched.
 */
public class PigLatin
{
    public static void main(String[] args)
    {
        System.out.println(pigIt("Pig latin is cool")); // igPay atinlay siay oolcay
        System.out.println(pigIt("Hello world !"));     // elloHay orldway !
    }

    public static String pigIt(String str)
    {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
        StringBuilder stringBuilder = new StringBuilder();

        while (stringTokenizer.hasMoreTokens())
        {
            String token = stringTokenizer.nextToken();
            String newToken;

            if (token.length() == 1 && token.matches("\\W"))
            {
                newToken = token;
            }
            else
            {
                newToken = token.substring(1) + String.valueOf(token.charAt(0)) + "ay ";
            }

            stringBuilder.append(newToken);
        }

        return stringBuilder.toString().trim();
    }
}