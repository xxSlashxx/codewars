package kyu4;

import java.util.ArrayList;
import java.util.List;

/**
 * In this kata you have to create all permutations of an input string and remove duplicates, if present. This means, you have to shuffle all letters from the input in all possible orders.
 * The order of the permutations doesn't matter.
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println(singlePermutations("a"));//=> ["a"]
        System.out.println(singlePermutations("ab"));//=> ["ab", "ba"]
        System.out.println(singlePermutations("aabb"));//=> ["aabb","abab","abba","baab","baba","bbaa"]
    }

    public static List<String> singlePermutations(String s) {
        List<String> result = new ArrayList<>();
        permutation("", s, result);
        return result;
    }

    private static void permutation(String prefix, String s, List<String> result) {
        int length = s.length();

        if (length == 0) {
            if (!result.contains(prefix)) {
                result.add(prefix);
            }
        } else {
            for (int i = 0; i < length; i++) {
                String newPrefix = prefix + s.charAt(i);
                String newStringPrefix = s.substring(0, i);
                String newStringSuffix = s.substring(i + 1, length);
                permutation(newPrefix, newStringPrefix + newStringSuffix, result);
            }
        }
    }
}