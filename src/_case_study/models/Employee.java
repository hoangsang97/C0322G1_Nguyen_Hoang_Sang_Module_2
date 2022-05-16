package _case_study.models;

import java.util.Scanner;

public class Employee extends Person{
    private int employeeCode;
    private String fullName;
    private int dateOfBirth;
    private boolean gender;
    private int idNumber;
    private int phoneNumber;
    private String email;
    private int Level;
    private int location;
    private double basicSalary;

    public Employee() {
    }

    public Employee(int employeeCode, String fullName, int dateOfBirth, boolean gender, int idNumber, int phoneNumber, String email, int level, int location, double basicSalary) {
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        Level = level;
        this.location = location;
        this.basicSalary = basicSalary;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int iDNumber) {
        this.idNumber = iDNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void checkLevel() {
        switch (this.getLevel()) {
            case 1:
                System.out.println("Trung cấp");
                break;
            case 2:
                System.out.println("Cao đẳng");
                break;
            case 3:
                System.out.println("Đại học");
                break;
            case 4:
                System.out.println("sau đại học");
                break;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode=" + employeeCode +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", idNumber=" + idNumber +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", Level=" + Level +
                ", location=" + location +
                ", basicSalary=" + basicSalary +
                '}';
    }
}
