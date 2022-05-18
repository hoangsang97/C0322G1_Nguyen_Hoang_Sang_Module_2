package ss11_dsa_stack_queue.exercise.invert_element_stack;

import java.util.Arrays;
import java.util.Stack;

public class WStack {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        stringStack.push("e");

        System.out.println("Mảng trước khi đảo ngược: ");
        for (String item : stringStack) {
            System.out.print(item + "\t");
        }
        System.out.println();
        System.out.println("Mảng sau khi đảo ngược: ");
        String[] string2Stack = new String[5];
        for (int i = 0; i < stringStack.toArray().length; i++) {
            string2Stack[i] = stringStack.get(stringStack.toArray().length - (i + 1));
        }
        System.out.println(Arrays.toString(string2Stack));
    }
}
