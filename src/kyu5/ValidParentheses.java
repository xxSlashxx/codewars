package kyu5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid. The function should return true if the string is valid, and false if it's invalid.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(validParentheses("()"));//=> returns true
        System.out.println(validParentheses("())"));//=> returns false
        System.out.println(validParentheses("32423(sgsdg)"));//=> returns true
        System.out.println(validParentheses("(dsgdsg))2432"));//=> returns false
        System.out.println(validParentheses("adasdasfa"));//=> returns true
    }

    public static boolean validParentheses(String parens) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < parens.length(); i++) {
            if (parens.charAt(i) == '(') {
                stack.push(String.valueOf(parens.charAt(i)));
            } else if (parens.charAt(i) == ')') {
                if (stack.size() > 0 && stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    stack.push(String.valueOf(parens.charAt(i)));
                }
            }
        }

        return stack.size() == 0;
    }
}