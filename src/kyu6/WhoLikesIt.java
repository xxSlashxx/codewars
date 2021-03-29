package kyu6;

/**
 * You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.
 */
public class WhoLikesIt {

    public static void main(String[] args) {
        System.out.println(whoLikesIt());//=> returns "no one likes this"
        System.out.println(whoLikesIt("Peter"));//=> returns "Peter likes this"
        System.out.println(whoLikesIt("Jacob", "Alex"));//=> returns "Jacob and Alex like this"
        System.out.println(whoLikesIt("Max", "John", "Mark"));//=> returns "Max, John and Mark like this"
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));//=> returns "Alex, Jacob and 2 others like this"
    }

    public static String whoLikesIt(String... names) {
        if (names.length < 2) {
            return String.format("%s likes this", names.length == 0 ? "no one" : names[0]);
        }

        if (names.length == 2) {
            return String.format("%s and %s like this", names[0], names[1]);
        }

        return String.format("%s, %s and %s like this", names[0], names[1], names.length > 3 ? names.length - 2 + " others" : names[2]);
    }
}