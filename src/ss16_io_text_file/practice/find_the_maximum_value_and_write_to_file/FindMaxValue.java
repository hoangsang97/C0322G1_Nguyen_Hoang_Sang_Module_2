package ss16_io_text_file.practice.find_the_maximum_value_and_write_to_file;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("/Users/hoangsangnguyen/Desktop/C0322G1/C0322G1_Nguyen_Hoang_Sang_Module_2/src/ss16_io_text_file/practice/find_the_maximum_value_and_write_to_file/numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("/Users/hoangsangnguyen/Desktop/C0322G1/C0322G1_Nguyen_Hoang_Sang_Module_2/src/ss16_io_text_file/practice/find_the_maximum_value_and_write_to_file/result.txt", maxValue);
        System.out.println(readAndWriteFile.readFile("/Users/hoangsangnguyen/Desktop/C0322G1/C0322G1_Nguyen_Hoang_Sang_Module_2/src/ss16_io_text_file/practice/find_the_maximum_value_and_write_to_file/numbers.txt"));
    }
}
