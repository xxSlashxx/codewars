package kyu5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In this kata, you will write a function that returns the positions and the values of the "peaks" (or local maxima) of a numeric array.
 *
 * For example, the array arr = [0, 1, 2, 5, 1, 0] has a peak at position 3 with a value of 5 (since arr[3] equals 5).
 *
 * The output will be returned as a ``Map<String,List>with two key-value pairs:"pos"and"peaks". If there is no peak in the given array, simply return {"pos" => [], "peaks" => []}`.
 *
 * Example: pickPeaks([3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3]) should return {pos: [3, 7], peaks: [6, 3]} (or equivalent in other languages)
 *
 * All input arrays will be valid integer arrays (although it could still be empty), so you won't need to validate the input.
 *
 * The first and last elements of the array will not be considered as peaks (in the context of a mathematical function, we don't know what is after and before and therefore, we don't know if it is a peak or not).
 *
 * Also, beware of plateaus !!! [1, 2, 2, 2, 1] has a peak while [1, 2, 2, 2, 3] and [1, 2, 2, 2, 2] do not. In case of a plateau-peak, please only return the position and value of the beginning of the plateau. For example: pickPeaks([1, 2, 2, 2, 1]) returns {pos: [1], peaks: [2]} (or equivalent in other languages)
 *
 * Have fun!
 */
public class PickPeaks {

    public static void main(String[] args) {
        System.out.println(getPeaks(new int[]{1, 2, 3, 6, 4, 1, 2, 3, 2, 1}));//=> {pos=[3, 7], peaks=[6, 3]}
        System.out.println(getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3}));//=> {pos=[3, 7], peaks=[6, 3]}
        System.out.println(getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1}));//=> {pos=[3, 7, 10], peaks=[6, 3, 2]}
        System.out.println(getPeaks(new int[]{2, 1, 3, 1, 2, 2, 2, 2, 1}));//=> {pos=[2, 4], peaks=[3, 2]}
        System.out.println(getPeaks(new int[]{2, 1, 3, 1, 2, 2, 2, 2}));//=> {pos=[2], peaks=[3]}
        System.out.println(getPeaks(new int[]{8, 18, 7, 11, -4, 2, 17, 17, 11, -4, 3, 2, 4}));//=> {pos=[1, 3, 6, 10], peaks=[18, 11, 17, 3]}
        System.out.println(getPeaks(new int[]{9, 0, 7, 7, 16, 11, 11, -3, -5, 15, -4, -1, 16, 0}));//=> {pos=[4, 9, 12], peaks=[16, 15, 16]}
    }

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> peaks = new HashMap<>();
        peaks.put("pos", new ArrayList<>());
        peaks.put("peaks", new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && i != arr.length - 1) {
                int current = arr[i];
                int predecessor = arr[i - 1];
                int successor = arr[i + 1];

                if (predecessor < current) {
                    if (current > successor) {
                        peaks.get("pos").add(i);
                        peaks.get("peaks").add(arr[i]);
                    } else if (current == successor) {
                        for (int j = i + 1; j < arr.length; j++) {
                            if (arr[j] > current || (j == arr.length - 1 && arr[j] == current)) {
                                break;
                            } else if (arr[j] < current) {
                                peaks.get("pos").add(i);
                                peaks.get("peaks").add(current);
                                i = j;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return peaks;
    }
}
