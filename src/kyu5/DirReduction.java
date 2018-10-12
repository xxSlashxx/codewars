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
            boolean push = false;

            if (stack.isEmpty() /*stack.peek() == null*/)
            {
                push = true;
            }
            else if (DIRECTION_NORTH.equals(direction))
            {
                push = !DIRECTION_SOUTH.equals(stack.peek());
            }
            else if (DIRECTION_SOUTH.equals(direction))
            {
                push = !DIRECTION_NORTH.equals(stack.peek());
            }
            else if (DIRECTION_WEST.equals(direction))
            {
                push = !DIRECTION_EAST.equals(stack.peek());
            }
            else if (DIRECTION_EAST.equals(direction))
            {
                push = !DIRECTION_WEST.equals(stack.peek());
            }

            if (push)
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
}