package kyu6;

/**
 * Count the number of Duplicates
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
 * that occur more than once in the input string.
 * The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
 */
public class CountingDuplicates
{
    public static void main(String[] args)
    {
        System.out.println(duplicateCount("abcde")); // -> 0 # no characters repeats more than once
        System.out.println(duplicateCount("aabbcde")); // -> 2 # 'a' and 'b'
        System.out.println(duplicateCount("aabBcde")); // -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
        System.out.println(duplicateCount("indivisibility")); // -> 1 # 'i' occurs six times
        System.out.println(duplicateCount("Indivisibilities")); // -> 2 # 'i' occurs seven times and 's' occurs twice
        System.out.println(duplicateCount("aA11")); // -> 2 # 'a' and '1'
    }

    public static int duplicateCount(String text)
    {
        char[] chars = text.toLowerCase().toCharArray();
        int[] count = new int[128];
        int result = 0;

        for (char item : chars)
        {
            count[item]++;
        }

        for (int i = 0; i < count.length; i++)
        {
            if (count[i] > 1)
            {
                result++;
            }
        }

        return result;
    }
}