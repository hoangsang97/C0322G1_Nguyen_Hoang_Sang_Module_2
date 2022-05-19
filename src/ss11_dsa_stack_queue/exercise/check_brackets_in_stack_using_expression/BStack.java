package ss11_dsa_stack_queue.exercise.check_brackets_in_stack_using_expression;

import java.util.Stack;

public class BStack {
    public static boolean balancedParenthensies(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char Character = str.charAt(i);
            if (Character == '[' || Character == '(' || Character == '{') {
                stack.push(Character);
            } else if (Character == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (Character == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (Character == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balancedParenthensies("{s * (s – a) * (s – b) * (s – c)  }"));
        System.out.println(balancedParenthensies("s * (s – a) * s – b) * (s – c) "));
        System.out.println(balancedParenthensies("(– b + (b^2 – 4*a*c)^(0.5/ 2*a) "));
    }
}
