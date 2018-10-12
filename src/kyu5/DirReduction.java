package kyu5;

import java.util.*;

/**
 * Once upon a time, on a way through the old wild west,… … a man was given directions to go from one point to another.
 * The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST"
 * too. Going to one direction and coming back the opposite direction is a needless effort. Since this is the wild west,
 * with dreadfull weather and not much water, it's important to save yourself some energy, otherwise you might die of
 * thirst!
 * <p>
 * How I crossed the desert the smart way. The directions given to the man are, for example, the following:
 * <p>
 * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
 * <p>
 * You can immediatly see that going "NORTH" and then "SOUTH" is not reasonable, better stay to the same place! So the
 * task is to give to the man a simplified version of the plan. A better plan in this case is simply:
 * <p>
 * ["WEST"]
 * <p>
 * Other examples: In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back
 * right away. What a waste of time! Better to do nothing.
 * <p>
 * The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is []
 * (nil in Clojure).
 * <p>
 * In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become
 * directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
 * <p>
 * Task Write a function dirReduc which will take an array of strings and returns an array of strings with the needless
 * directions removed (W<->E or S<->N side by side).
 * <p>
 * Examples dirReduc(@[@"NORTH", @"SOUTH", @"SOUTH", @"EAST", @"WEST", @"NORTH", @"WEST"]); // => @[@"WEST"]
 * dirReduc(@[@"NORTH", @"SOUTH", @"SOUTH", @"EAST", @"WEST", @"NORTH"]); // => @[] See more examples in "Example Tests"
 * Note Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. "NORTH" and
 * "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other and can't become such. Hence
 * the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
 */
public class DirReduction
{
    public static final String DIRECTION_NORTH = "NORTH";
    public static final String DIRECTION_SOUTH = "SOUTH";
    public static final String DIRECTION_EAST = "EAST";
    public static final String DIRECTION_WEST = "WEST";

    public static void main(String[] args)
    {
        System.out.println(
                Arrays.asList(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
        System.out.println(Arrays.asList(dirReduc(new String[]{"NORTH", "SOUTH", "EAST", "WEST"})));
        System.out.println(Arrays.asList(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"})));
        System.out.println(Arrays.asList(dirReduc(
                new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"})));
    }

    public static String[] dirReduc(String[] arr)
    {
        Stack<String> stack = new Stack<>();

        for (String direction : arr)
        {
            if (stack.isEmpty() || !isOpposite(direction, stack.peek()))
            {
                stack.push(direction);
            }
            else
            {
                stack.pop();
            }
        }

        return stack.toArray(new String[0]);
    }

    public static boolean isOpposite(String direction, String predecessor)
    {
        return DIRECTION_NORTH.equals(direction) && DIRECTION_SOUTH.equals(predecessor) ||
                DIRECTION_SOUTH.equals(direction) && DIRECTION_NORTH.equals(predecessor) ||
                DIRECTION_WEST.equals(direction) && DIRECTION_EAST.equals(predecessor) ||
                DIRECTION_EAST.equals(direction) && DIRECTION_WEST.equals(predecessor);
    }
}