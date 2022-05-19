package ss11_dsa_stack_queue.exercise.demerging_use_queue;

import java.util.*;

public class TestDemerging {
    public static void main(String[] args) {
        List<Demerging> studentList = new ArrayList<>();

        studentList.add(new Demerging("tran van a", true, 2000));
        studentList.add(new Demerging("tran van b", true, 1999));
        studentList.add(new Demerging("tran van c", false, 2001));
        studentList.add(new Demerging("tran van d", true, 2002));
        studentList.add(new Demerging("tran van e", false, 2003));

        Collections.sort(studentList);

        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }

        Queue<Demerging> girlQueue = new LinkedList<>();
        Queue<Demerging> boyQueue = new LinkedList<>();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).isGender()) {
                girlQueue.add(studentList.get(i));
            } else {
                boyQueue.add(studentList.get(i));
            }
        }

        System.out.println("List Girl");
        while (!girlQueue.isEmpty()) {
            System.out.println(girlQueue.poll());
        }
        System.out.println("List Boy");
        while (!boyQueue.isEmpty()) {
            System.out.println(boyQueue.poll());
        }
    }
}
