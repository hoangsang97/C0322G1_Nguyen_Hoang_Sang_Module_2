package _case_study.utils;

import _case_study.models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeFile(String pathFile, String data) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
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

    public static List<String[]> readFile(String pathFile) {
        File file = new File(pathFile);
        List<String[]> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
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

    public static void writeEmployee(String pathFile, List<Employee> employeeList){
        List<String> stringList = new ArrayList<>();
        for (Employee item : employeeList) {
            stringList.add(item.getInfo());
        }

        String str = "";
        for (String item : stringList) {
            str += item + "\n";
        }

        writeFile(pathFile, str);
    }

    public static void readEmployee(String pathFile, List<Employee> employeeList) {
        List<String[]> list = readFile(pathFile);
        for (String[] item: list) {
            Employee employee = new Employee(Integer.parseInt(item[0]), item[1], item[2], item[3], item[4], item[5], item[6], item[7], Integer.parseInt(item[8]));
            employeeList.add(employee);
        }
    }
}
