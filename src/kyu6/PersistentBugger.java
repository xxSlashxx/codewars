package kyu6;

/**
 * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
 * which is the number of times you must multiply the digits in num until you reach a single digit.
 */
public class PersistentBugger
{
    public static void main(String[] args)
    {
        System.out.println(persistence(39)); //== 3 // because 3*9 = 27, 2*7 = 14, 1*4=4 and 4 has only one digit
        System.out.println(persistence(999)); // because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2
        System.out.println(persistence(4)); // because 4 is already a one-digit number
    }

    public static int persistence(long n)
    {
        String value = String.valueOf(n);
        int counter = 0;

        while (value.length() > 1)
        {
            int newValue = 1;

            for (int i = 0; i < value.length(); i++)
            {
                newValue = newValue * Character.getNumericValue(value.charAt(i));
            }

            counter++;
            value = String.valueOf(newValue);
        }

        return counter;
    }
}