package _bai_thi.utils;

import _bai_thi.models.LongTerm;
import _bai_thi.models.ShortTermCoThoiHan;
import _bai_thi.models.ShortTermVoThoiHan;

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

    public static void readLongTerm(String pathFile, List<LongTerm> longTermList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
                longTermList.add(new LongTerm(item[0], Integer.parseInt(item[1]), item[2], item[3], Double.parseDouble(item[4]), Double.parseDouble(item[5]), item[6], item[7]));
        }
    }

    public static void writeLongTerm(String pathFile, List<LongTerm> longTermList) {
        List<String> stringList = new ArrayList<>();
        for (LongTerm item : longTermList) {
            stringList.add(item.getInfo());
        }

        String stringLongTerm = "";
        for (String item : stringList) {
            stringLongTerm += item + "\n";
        }

        writeFile(pathFile, stringLongTerm);
    }

    public static void readShortTermVoThoiHan(String pathFile, List<ShortTermVoThoiHan> shortTermVoThoiHanList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            shortTermVoThoiHanList.add(new ShortTermVoThoiHan(item[0], Integer.parseInt(item[1]), item[2], item[3], Double.parseDouble(item[4]), Double.parseDouble(item[5])));
        }
    }

    public static void writeShortTeamVoThoiHan(String pathFile, List<ShortTermVoThoiHan> shortTermVoThoiHanList) {
        List<String> stringList = new ArrayList<>();
        for (ShortTermVoThoiHan item : shortTermVoThoiHanList) {
            stringList.add(item.getInfo());
        }

        String stringShortTermVoThoiHan = "";
        for (String item : stringList) {
            stringShortTermVoThoiHan += item + "\n";
        }

        writeFile(pathFile, stringShortTermVoThoiHan);
    }

    public static void readShortTermCoThoiHan(String pathFile, List<ShortTermCoThoiHan> shortTermCoThoiHanList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            shortTermCoThoiHanList.add(new ShortTermCoThoiHan(item[0], Integer.parseInt(item[1]), item[2], item[3], Double.parseDouble(item[4]), Double.parseDouble(item[5]), item[6]));
        }
    }

    public static void writeShortTeamCoThoiHan(String pathFile, List<ShortTermCoThoiHan> shortTermList) {
        List<String> stringList = new ArrayList<>();
        for (ShortTermCoThoiHan item : shortTermList) {
            stringList.add(item.getInfo());
        }

        String stringShortTermCoThoiHan = "";
        for (String item : stringList) {
            stringShortTermCoThoiHan += item + "\n";
        }

        writeFile(pathFile, stringShortTermCoThoiHan);
    }
}
