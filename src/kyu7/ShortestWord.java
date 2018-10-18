package kyu7;

/**
 * Simple, given a string of words, return the length of the shortest word(s).
 * String will never be empty and you do not need to account for different data types.
 */
public class ShortestWord
{
    public static void main(String[] args)
    {
        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps")); // => 3
        System.out.println(findShort("turns out random test cases are easier than writing out basic ones")); // => 3
    }

    public static int findShort(String s)
    {
        String[] words = s.split(" ");
        int shortestLength = words[0].length();

        for (int i = 1; i < words.length; i++)
        {
            String currentWord = words[i];

            if (currentWord.length() < shortestLength)
            {
                shortestLength = currentWord.length();
            }
        }

        return shortestLength;
    }
}