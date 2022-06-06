package _quan_ly_nhan_vien.utils;

import _quan_ly_codegym.models.Student;
import _quan_ly_codegym.models.Teacher;
import _quan_ly_nhan_vien.models.ManagementStaff;
import _quan_ly_nhan_vien.models.ProductionStaff;

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

    public static void writeManagementStaff(String pathFile, List<ManagementStaff> managementStaffList) {
        List<String> stringList = new ArrayList<>();
        for (ManagementStaff item : managementStaffList) {
            stringList.add(item.getInfo());
        }

        String stringManagementStaff = "";
        for (String item : stringList) {
            stringManagementStaff += item + "\n";
        }

        writeFile(pathFile, stringManagementStaff);
    }

    public static void readManagementStaff(String pathFile, List<ManagementStaff> managementStaffList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            managementStaffList.add(new ManagementStaff(Integer.parseInt(item[0]), item[1], item[2], item[3], Double.parseDouble(item[4]), Double.parseDouble(item[5])));
        }
    }

    public static void writeProductionStaff(String pathFile, List<ProductionStaff> productionStaffList) {
        List<String> stringList = new ArrayList<>();
        for (ProductionStaff item : productionStaffList) {
            stringList.add(item.getInfo());
        }

        String stringProductionStaff = "";
        for (String item : stringList) {
            stringProductionStaff += item + "\n";
        }

        writeFile(pathFile, stringProductionStaff);
    }

    public static void readProductionStaff(String pathFile, List<ProductionStaff> productionStaffList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            productionStaffList.add(new ProductionStaff(Integer.parseInt(item[0]), item[1], item[2], item[3], Integer.parseInt(item[4]), Double.parseDouble(item[5])));
        }
    }
}
