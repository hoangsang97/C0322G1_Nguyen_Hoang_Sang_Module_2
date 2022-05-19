package ss11_dsa_stack_queue.exercise.count_the_number_of_occurrences;

import java.util.HashMap;
import java.util.Set;

public class TreeMap {
    public static void main(String[] args) {
        String str = "dong dong dong";
        str = str.replaceAll(",", "");
        String[] arr = str.split(" ");
        String key = "";
        Integer value;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.remove(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }

        Set<String> set = map.keySet();

        for (String s : set) {
            key = s;
            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
        }
    }
}
