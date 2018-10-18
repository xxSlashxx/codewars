package kyu7;

/**
 * Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive.
 * The string can contain any char.
 */
public class XO
{
    public static void main(String[] args)
    {
        System.out.println(getXO("ooxx")); // => true
        System.out.println(getXO("xooxx")); // => false
        System.out.println(getXO("ooxXm")); // => true
        System.out.println(getXO("zpzpzpp")); // => true // when no 'x' and 'o' is present should return true
        System.out.println(getXO("zzoo")); // => false
    }

    public static boolean getXO(String str)
    {
        str = str.toLowerCase();
        int numberOfX = 0;
        int numberOfO = 0;

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == 'x')
            {
                numberOfX++;
            }
            else if (str.charAt(i) == 'o')
            {
                numberOfO++;
            }
        }

        return numberOfX == numberOfO;
    }
}