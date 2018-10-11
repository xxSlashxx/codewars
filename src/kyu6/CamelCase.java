package kyu6;

import java.util.StringTokenizer;

/**
 * Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word
 * within the output should be capitalized only if the original word was capitalized.
 */
public class CamelCase
{
    public static void main(String[] args)
    {
        System.out.println(toCamelCase("the-stealth-warrior")); // returns "theStealthWarrior"
        System.out.println(toCamelCase("The_Stealth_Warrior")); // returns "TheStealthWarrior"
    }

    public static String toCamelCase(String s)
    {
        StringTokenizer stringTokenizer = new StringTokenizer(s, "_|-");
        StringBuilder result = new StringBuilder();

        for (int i = 0; stringTokenizer.hasMoreTokens(); i++)
        {
            String token = stringTokenizer.nextToken();

            if (i > 0)
            {
                token = token.substring(0, 1).toUpperCase() + token.substring(1);
            }

            result.append(token);
        }

        return result.toString();
    }
}