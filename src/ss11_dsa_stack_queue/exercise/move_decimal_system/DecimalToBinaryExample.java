package ss11_dsa_stack_queue.exercise.move_decimal_system;

import java.util.Stack;

public class DecimalToBinaryExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int decimalNumber = 111;
        while (decimalNumber != 0) {
            int d = decimalNumber % 2;
            stack.push(d);
            decimalNumber /= 2;
        }
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
    }
}
