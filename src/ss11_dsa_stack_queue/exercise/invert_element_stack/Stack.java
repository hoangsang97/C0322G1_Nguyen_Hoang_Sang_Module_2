package ss11_dsa_stack_queue.exercise.invert_element_stack;

import java.util.Arrays;

public class Stack<N> {
    public static void main(String[] args) {
        java.util.Stack<Number> numberStack = new java.util.Stack<>();
        numberStack.push(1);
        numberStack.push(2);
        numberStack.push(3);
        numberStack.push(4);
        numberStack.push(5);

        System.out.println("Mảng trước khi đảo ngược: ");
        for (Number item : numberStack) {
            System.out.print(item + "\t");
        }
        System.out.println();
        System.out.println("Mảng sau khi đảo ngược: ");
        Number[] number2Stack = new Number[5];
        for (int i = 0; i < numberStack.toArray().length; i++) {
            number2Stack[i] = numberStack.get(numberStack.toArray().length - (i + 1));
        }
        System.out.println(Arrays.toString(number2Stack));
    }
}
