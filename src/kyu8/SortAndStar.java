package kyu8;

import java.util.Arrays;

/**
 * You will be given a vector of strings. You must sort it alphabetically (case-sensitive, and based on the ASCII values of the chars) and then return the first value.
 *
 * The returned value must be a string, and have "***" between each of its letters.
 *
 * You should not remove or add elements from/to the array.
 */
public class SortAndStar {

    public static void main(String[] args) {
        System.out.println(twoSort(new String[]{"bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"}));
        System.out.println(twoSort(new String[]{"turns", "out", "random", "test", "cases", "are", "easier", "than", "writing", "out", "basic", "ones"}));
    }

    public static String twoSort(String[] s) {
        Arrays.sort(s);
        return s[0].replaceAll("(?<!^)(\\w)", "***$0");
    }
}