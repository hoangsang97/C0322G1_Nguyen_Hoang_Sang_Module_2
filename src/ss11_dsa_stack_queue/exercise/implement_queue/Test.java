package ss11_dsa_stack_queue.exercise.implement_queue;

public class Test {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.setFront(null);
        q.setRear(null);

        Solution.enQueue(q, 14);
        Solution.enQueue(q, 22);
        Solution.enQueue(q, 6);

        Solution.displayQueue(q);
        System.out.println();
        System.out.printf("Deleted value = % d ", Solution.deQueue(q));
        System.out.println();
        System.out.printf("Deleted value = % d ", Solution.deQueue(q));
        System.out.println();
        Solution.displayQueue(q);

        Solution.enQueue(q, 9);
        Solution.enQueue(q, 20);
        System.out.println();
        Solution.displayQueue(q);
    }
}
