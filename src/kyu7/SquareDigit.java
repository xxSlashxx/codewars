package kyu7;

/**
 * Welcome. In this kata, you are asked to square every digit of a number.
 * For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.
 * Note: The function accepts an integer and returns an integer
 */
public class SquareDigit
{
    public static void main(String[] args)
    {
        System.out.println(squareDigits(9119)); //should return 811181
    }


    public static int squareDigits(int n)
    {
        char[] chars = String.valueOf(n).toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++)
        {
            int square = (int) Math.pow(Character.getNumericValue(chars[i]), 2);
            result.append(square);
        }

        return Integer.parseInt(result.toString());
    }
}