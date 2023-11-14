package interview;

import java.util.Stack;

/**
 * 给定一个只包括括号字符的字符串，例如：“(){}[]”,
 * 我们需要判断这个字符串中的括号是否匹配。即，对于每一个左括号，必须有一个相应的右括号与之对应，且左括号和右括号之间不能有其他类型的括号嵌套。
 */
public class Solution001 {
    public static boolean validate(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({})[]";
        System.out.println(validate(s));
    }
}
