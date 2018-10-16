package kyu7;

/**
 * In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
 * <p>
 * Notes:
 * <p>
 * All numbers are valid Int32, no need to validate them.
 * There will always be at least one number in the input string.
 * Output string must be two numbers separated by a single space, and highest number is first.
 */
public class HighestAndLowest
{
    public static void main(String[] args)
    {
        System.out.println(HighAndLow("1 2 3 4 5")); // return "5 1"
        System.out.println(HighAndLow("1 2 -3 4 5")); // return "5 -3"
        System.out.println(HighAndLow("1 9 3 4 -5")); // return "9 -5"
    }

    public static String HighAndLow(String numbersString)
    {
        String[] numbers = numbersString.split(" ");

        int max = Integer.parseInt(numbers[0]);
        int min = Integer.parseInt(numbers[0]);

        for (int i = 1; i < numbers.length; i++)
        {
            int currentNumber = Integer.parseInt(numbers[i]);

            if (currentNumber > max)
            {
                max = currentNumber;
            }
            else if (currentNumber < min)
            {
                min = currentNumber;
            }
        }

        return new StringBuilder().append(max).append(" ").append(min).toString();
    }
}
