package ss11_dsa_stack_queue.test.generic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainTest {
    public static void main(String[] args) {
        TestGeneric<Integer, String> testGeneric = new TestGeneric<>(1, "a");
        System.out.println(testGeneric.getValue());
        System.out.println(testGeneric.getKey());

//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.add(3);
////        System.out.println(stack.pop());
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        Queue<Integer> integerQueue = new LinkedList<>();
        System.out.println(integerQueue.offer(2));
//        integerQueue.offer(2);
        System.out.println(integerQueue.offer(3));
//        integerQueue.add(4);
        System.out.println(integerQueue.peek());
//        System.out.println(integerQueue.remove());
        System.out.println(integerQueue.element());
        System.out.println(integerQueue.peek());
    }
}
