package _quan_ly_ho_so_hoc_sinh.utils;

import _quan_ly_ho_so_hoc_sinh.models.Certificated;
import _quan_ly_ho_so_hoc_sinh.models.Experience;
import _quan_ly_ho_so_hoc_sinh.models.Fresher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public static void readExperience(String pathFile, List<Experience> experienceList, List<Certificated> certificatedList) {
        readCertificated("src/_quan_ly_ho_so_hoc_sinh/data/certificated.csv", certificatedList);
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            for (Certificated certificated : certificatedList) {
                if (Objects.equals(item[9], String.valueOf(certificated.getCertificatedID()))) {
                    experienceList.add(new Experience(Integer.parseInt(item[0]), item[1], item[2], Integer.parseInt(item[3]), item[4], item[5], Integer.parseInt(item[6]), item[7], item[8], certificated));
                }
            }
        }
    }

    public static void writeExperience(String pathFile, List<Experience> experienceList) {
        List<String> stringList = new ArrayList<>();
        for (Experience item : experienceList) {
            stringList.add(item.getInfo());
        }

        String stringExperience = "";
        for (String item : stringList) {
            stringExperience += item + "\n";
        }

        writeFile(pathFile, stringExperience);
    }

    public static void readFresher(String pathFile, List<Fresher> fresherList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            fresherList.add(new Fresher(Integer.parseInt(item[0]), item[1], item[2], Integer.parseInt(item[3]), item[4], item[5], Integer.parseInt(item[6]), item[7], item[8], item[9]));
        }
    }

    public static void writeFresher(String pathFile, List<Fresher> fresherList) {
        List<String> stringList = new ArrayList<>();
        for (Fresher item : fresherList) {
            stringList.add(item.getInfo());
        }

        String stringFresher = "";
        for (String item : stringList) {
            stringFresher += item + "\n";
        }

        writeFile(pathFile, stringFresher);
    }

    public static void readCertificated(String pathFile, List<Certificated> certificatedList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            certificatedList.add(new Certificated(Integer.parseInt(item[0]), item[1], item[2], item[3]));
        }
    }

    public static void writeCertificated(String pathFile, List<Certificated> certificatedList) {
        List<String> stringList = new ArrayList<>();
        for (Certificated item : certificatedList) {
            stringList.add(item.getInfo());
        }

        String stringCertificated = "";
        for (String item : stringList) {
            stringCertificated += item + "\n";
        }

        writeFile(pathFile, stringCertificated);
    }
}
