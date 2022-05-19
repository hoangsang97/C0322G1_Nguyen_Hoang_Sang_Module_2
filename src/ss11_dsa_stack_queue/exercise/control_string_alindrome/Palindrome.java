package ss11_dsa_stack_queue.exercise.control_string_alindrome;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        String str = "Able was";
        String[] arr = str.split("");
        String strSPush = "";
        for (int i = 0; i < arr.length; i++) {
            strSPush = stringStack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
             stringStack.pop();
        }

        String strQPoll = "";
        Queue<String> stringQueue = new LinkedList<>(Arrays.asList(arr));
        for (int i = 0; i < arr.length; i++) {
            strQPoll = stringQueue.poll();
        }

        if (strSPush.equals(strQPoll)) {
            System.out.println("là chuỗi Palindrome");
        } else {
            System.out.println("không phải là chuỗi Palindrome");
        }
    }
}
