package ss16_io_text_file.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadAndWrite {
    public static void main(String[] args) {
        Write("src/ss16_io_text_file/test/product.csv", "HELLO word");

        List<String[]> listStr = read("src/ss16_io_text_file/test/product.csv");

        for (String[] item: listStr) {
            System.out.println(Arrays.toString(item));
        }
    }
    public static  void Write(String pathFile, String data) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
//
//        if (!file.exists()) {
//            try {
//                throw new MyException("File không tồn tại");
//            } catch (MyException e) {
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                throw new MyException("File đã tồn tại");
//            } catch (MyException e) {
//                e.printStackTrace();
//            }
//        }

        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String[]> read(String pathFile) {
        File file = new File(pathFile);
        List<String[]> list = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((line  =  bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(arr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
