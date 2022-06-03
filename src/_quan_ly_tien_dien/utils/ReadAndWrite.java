package _quan_ly_tien_dien.utils;

import _quan_ly_tien_dien.models.bill.Bill;
import _quan_ly_tien_dien.models.customer.Customer;
import _quan_ly_tien_dien.models.customer.CustomerNg;
import _quan_ly_tien_dien.models.customer.CustomerVn;

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

    public static void writeCustomerVn(String pathFile, List<CustomerVn> customerVnList) {
        List<String> stringList = new ArrayList<>();
        for (CustomerVn item : customerVnList) {
            stringList.add(item.getInfo());
        }

        String stringCustomerVn = "";
        for (String item : stringList) {
            stringCustomerVn += item + "\n";
        }

        writeFile(pathFile, stringCustomerVn);
    }

    public static void readCustomerVn(String pathFile, List<CustomerVn> customerVnList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            customerVnList.add(new CustomerVn(item[0], item[1], item[2], Double.parseDouble(item[3])));
        }
    }

    public static void writeCustomerNg(String pathFile, List<CustomerNg> customerNgList) {
        List<String> stringList = new ArrayList<>();
        for (CustomerNg item : customerNgList) {
            stringList.add(item.getInfo());
        }

        String stringCustomerNg = "";
        for (String item : stringList) {
            stringCustomerNg += item + "\n";
        }

        writeFile(pathFile, stringCustomerNg);
    }

    public static void readCustomerNg(String pathFile, List<CustomerNg> customerNgList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            customerNgList.add(new CustomerNg(item[0], item[1], item[2]));
        }
    }

    public static void writeBill(String pathFile, List<Bill> billList) {
        List<String> stringList = new ArrayList<>();
        for (Bill item : billList) {
            stringList.add(item.getInfo());
        }

        String stringBill = "";
        for (String item : stringList) {
            stringBill += item + "\n";
        }

        writeFile(pathFile, stringBill);
    }

    public static void readBill(String pathFile, List<Bill> billList) {
        List<String[]> strings = readFile(pathFile);
        for (String[] item : strings) {
            billList.add(new Bill(item[0], item[1], item[2], item[3], Double.parseDouble(item[4]), Double.parseDouble(item[5]), Double.parseDouble(item[6])));
        }
    }

    public static void readCustomer(List<Customer> customerList) {
        List<CustomerVn> customerVnList = new ArrayList<>();

        List<CustomerNg> customerNgList = new ArrayList<>();

        List<String[]> CustomerVnList = readFile("src/_quan_ly_tien_dien/data/customerVN.csv");

        for (String[] item: CustomerVnList) {
            customerVnList.add(new CustomerVn(item[0], item[1], item[2], Double.parseDouble(item[3])));
        }

        List<String[]> CustomerNgList = readFile("src/_quan_ly_tien_dien/data/customerVN.csv");

        for (String[] item: CustomerNgList) {
            customerNgList.add(new CustomerNg(item[0], item[1], item[2]));
        }

        customerList.addAll(customerVnList);
        customerList.addAll(customerNgList);
    }
}
