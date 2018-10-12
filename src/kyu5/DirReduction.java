package kyu5;

import java.util.*;

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