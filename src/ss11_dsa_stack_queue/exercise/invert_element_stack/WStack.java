package ss11_dsa_stack_queue.exercise.invert_element_stack;

import java.util.Arrays;
import java.util.Stack;

public class WStack {
    public static void main(String[] args) {
        Stack<String> wStack = new Stack<>();

        String stringWord = "Nguyễn Hoàng Sang";

        String[] mWord = stringWord.split(" ");
        for (String item : mWord) {
            wStack.push(item);
        }

        System.out.println("chuỗi trước khi đảo ngược: ");
        System.out.println(stringWord);


        for (int i = 0; i < mWord.length; i++) {
            mWord[i] = wStack.pop();
        }

        System.out.println("chuỗi sau khi đảo ngược: ");
        for (int i = 0; i < mWord.length; i++) {
            System.out.print(mWord[i] + " ");
        }
    }
}
