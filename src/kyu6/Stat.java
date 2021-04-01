package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You are the "computer expert" of a local Athletic Association (C.A.A.). Many teams of runners come to compete. Each time you get a string of all race results of every team who has run. For example here is a string showing the individual results of a team of 5 runners:
 *
 * "01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"
 *
 * Each part of the string is of the form: h|m|s where h, m, s (h for hour, m for minutes, s for seconds) are positive or null integer (represented as strings) with one or two digits. There are no traps in this format.
 *
 * To compare the results of the teams you are asked for giving three statistics; range, average and median.
 *
 * Range : difference between the lowest and highest values. In {4, 6, 9, 3, 7} the lowest value is 3, and the highest is 9, so the range is 9 − 3 = 6.
 *
 * Mean or Average : To calculate mean, add together all of the numbers in a set and then divide the sum by the total count of numbers.
 *
 * Median : In statistics, the median is the number separating the higher half of a data sample from the lower half. The median of a finite list of numbers can be found by arranging all the observations from lowest value to highest value and picking the middle one (e.g., the median of {3, 3, 5, 9, 11} is 5) when there is an odd number of observations. If there is an even number of observations, then there is no single middle value; the median is then defined to be the mean of the two middle values (the median of {3, 5, 6, 9} is (5 + 6) / 2 = 5.5).
 *
 * Your task is to return a string giving these 3 values. For the example given above, the string result will be
 *
 * "Range: 00|47|18 Average: 01|35|15 Median: 01|32|34"
 *
 * of the form: "Range: hh|mm|ss Average: hh|mm|ss Median: hh|mm|ss"`
 *
 * where hh, mm, ss are integers (represented by strings) with each 2 digits.
 */
public class Stat {

    public static void main(String[] args) {
        System.out.println(stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));//=> "Range: 01|01|18 Average: 01|38|05 Median: 01|32|34"
        System.out.println(stat("02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41"));//=> "Range: 00|31|17 Average: 02|26|18 Median: 02|22|00"
    }

    public static String stat(String strg) {
        List<Integer> raceResultsInSeconds = new ArrayList<>();
        String[] raceResults = strg.split(", ");
        Arrays.stream(raceResults).forEach(s -> raceResultsInSeconds.add(calculateSecondsFromRaceResult(s)));
        raceResultsInSeconds.sort(Comparator.comparingInt(Integer::intValue));
        String range = calculateRange(raceResultsInSeconds);
        String average = calculateAverage(raceResultsInSeconds);
        String median = calculateMedian(raceResultsInSeconds);
        return "Range: " + range + " Average: " + average + " Median: " + median;
    }

    private static String calculateRange(List<Integer> raceResultsInSeconds) {
        Integer min = raceResultsInSeconds.get(0);
        Integer max = raceResultsInSeconds.get(raceResultsInSeconds.size() - 1);
        return calculateRaceResultFromSeconds(max - min);
    }

    private static String calculateAverage(List<Integer> raceResultsInSeconds) {
        double averageAsDouble = raceResultsInSeconds.stream().mapToInt(Integer::intValue).average().getAsDouble();
        return calculateRaceResultFromSeconds((int) averageAsDouble);
    }

    private static String calculateMedian(List<Integer> raceResultsInSeconds) {
        if (raceResultsInSeconds.size() % 2 == 0) {
            Integer medianRaceResultInSeconds1 = raceResultsInSeconds.get((raceResultsInSeconds.size() / 2) - 1);
            Integer medianRaceResultInSeconds2 = raceResultsInSeconds.get(raceResultsInSeconds.size() / 2);
            return calculateRaceResultFromSeconds((medianRaceResultInSeconds1 + medianRaceResultInSeconds2) / 2);
        } else {
            Integer medianRaceResultInSeconds = raceResultsInSeconds.get((raceResultsInSeconds.size() / 2));
            return calculateRaceResultFromSeconds(medianRaceResultInSeconds);
        }
    }

    private static int calculateSecondsFromRaceResult(String raceResult) {
        String[] split = raceResult.split("\\|");
        return (Integer.parseInt(split[0]) * 60 * 60) + (Integer.parseInt(split[1]) * 60) + (Integer.parseInt(split[2]));
    }

    private static String calculateRaceResultFromSeconds(Integer totalSeconds) {
        int hours = totalSeconds / 60 / 60;
        int minutes = (totalSeconds - (hours * 60 * 60)) / 60;
        int seconds = totalSeconds - (hours * 60 * 60) - (minutes * 60);
        return String.format("%02d", hours) + "|" + String.format("%02d", minutes) + "|" + String.format("%02d", seconds);
    }
}