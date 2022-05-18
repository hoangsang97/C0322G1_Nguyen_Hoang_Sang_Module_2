package ss11_dsa_stack_queue.exercise.move_decimal_system;

import java.util.Stack;

public class DecimalToBinaryExample {
    public void convertBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        int decimalNumber = 123456789;
        System.out.print("Hệ nhị phân của " + decimalNumber + " là :");
        new DecimalToBinaryExample().convertBinary(decimalNumber);
    }
}
