package _quan_ly_codegym.utils;

import _quan_ly_codegym.models.Student;
import _quan_ly_codegym.models.Teacher;

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

        List<String[]> stringList = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        String line = "";
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                stringList.add(arr);
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
        return stringList;
    }

    public static void writeStudent(String pathFile, List<Student> studentList) {
        List<String> stringList = new ArrayList<>();
        for (Student item : studentList) {
            stringList.add(item.getInfo());
        }

        String stringStudent = "";
        for (String item : stringList) {
            stringStudent += item + "\n";
        }

        writeFile(pathFile, stringStudent);
    }

    public static void readStudent(String pathFile, List<Student> studentList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            studentList.add(new Student(item[0], item[1], item[2], item[3], item[4], Integer.parseInt(item[5])));
        }
    }

    public static void writeTeacher(String pathFile, List<Teacher> teacherList) {
        List<String> stringList = new ArrayList<>();
        for (Teacher item : teacherList) {
            stringList.add(item.getInfo());
        }

        String stringTeacher = "";
        for (String item : stringList) {
            stringTeacher += item + "\n";
        }

        writeFile(pathFile, stringTeacher);
    }

    public static void readTeacher(String pathFile, List<Teacher> teacherList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            teacherList.add(new Teacher(item[0], item[1], item[2], item[3], item[4]));
        }
    }
}
