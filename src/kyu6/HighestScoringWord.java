package kyu6;

/**
 * Given a string of words, you need to find the highest scoring word.
 * Each letter of a word scores points according to it's position in the alphabet: a = 1, b = 2, c = 3 etc.
 * You need to return the highest scoring word as a string.
 * If two words score the same, return the word that appears earliest in the original string.
 * All letters will be lowercase and all inputs will be valid.
 */
public class HighestScoringWord
{
    public static void main(String[] args)
    {
        System.out.println(high("man i need a taxi up to ubud")); // -> taxi
        System.out.println(high("what time are we climbing up to the volcano")); // -> volcano
        System.out.println(high("take me to semynak")); // -> semynak
    }

    public static String high(String text)
    {
        String[] words = text.split(" ");
        String highestScoringWord = "";
        int highestScore = 0;

        for (String word : words)
        {
            char[] charArray = word.toCharArray();
            int score = 0;

            for (char charValue : charArray)
            {
                score = score + charValue - 'a';
            }

            if (score > highestScore)
            {
                highestScore = score;
                highestScoringWord = word;
            }
        }

        return highestScoringWord;
    }
}