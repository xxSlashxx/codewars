package kyu6;

/**
 * In this kata, you must create a digital root function. A digital root is the recursive sum of all the digits in a
 * number. Given n, take the sum of the digits of n. If that value has two digits, continue reducing in this way until a
 * single-digit number is produced. This is only applicable to the natural numbers.
 */
public class DRoot
{
    public static void main(String[] args)
    {
        System.out.println(digital_root(16));//=> 1 + 6 => 7
        System.out.println(digital_root(942));//=> 9 + 4 + 2 => 15 => 1 + 5 => 6
        System.out.println(digital_root(132189));
        System.out.println(digital_root(493193));
    }

    public static int digital_root(int n)
    {
        String stringValue = String.valueOf(n);

        while (stringValue.length() > 1)
        {
            int result = 0;

            for (int i = 0; i < stringValue.length(); i++)
            {
                result = result + Integer.parseInt(String.valueOf(stringValue.charAt(i)));
            }

            stringValue = String.valueOf(result);
        }

        return Integer.valueOf(stringValue);
    }
}