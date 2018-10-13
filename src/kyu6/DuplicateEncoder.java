package kyu6;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder
{
    public static void main(String[] args)
    {
        System.out.println(encode("Prespecialized")); // =>  )()())()(()()(
        System.out.println(encode("   ()(   ")); // =>  ))))())))
    }

    public static String encode(String word)
    {
        word = word.toLowerCase();
        Map<Integer, Integer> occurrenceMap = createOccurrenceMap(word);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++)
        {
            Integer currentChar = (int) word.charAt(i);

            if (occurrenceMap.get(currentChar) > 1)
            {
                result.append(")");
            }
            else
            {
                result.append("(");
            }
        }

        return result.toString();
    }

    public static  Map<Integer, Integer> createOccurrenceMap(String word)
    {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++)
        {
            Integer currentChar = (int) word.charAt(i);

            if (occurrenceMap.containsKey(currentChar))
            {
                Integer counter = occurrenceMap.get(currentChar);
                counter++;
                occurrenceMap.put(currentChar, counter);
            }
            else
            {
                occurrenceMap.put(currentChar, 1);
            }
        }

        return occurrenceMap;
    }
}