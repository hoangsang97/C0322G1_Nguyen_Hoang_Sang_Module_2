package exercise.practice_on_array_arrayList_linkedList_map.model;

public class DailyWorker extends Staff{
    private int numberOfWorkdays;

    public DailyWorker() {
    }

    @Override
    public int employeeSalary() {
        return this.numberOfWorkdays * 120000;
    }

    public DailyWorker(String fullName, int yearOfBirth, String address, int numberOfWorkdays) {
        super(fullName, yearOfBirth, address);
        this.numberOfWorkdays = numberOfWorkdays;
    }

    public int getNumberOfWorkdays() {
        return numberOfWorkdays;
    }

    public void setNumberOfWorkdays(int numberOfWorkdays) {
        this.numberOfWorkdays = numberOfWorkdays;
    }

    @Override
    public String toString() {
        return "DailyWorker{" + super.toString() +
                "numberOfWorkdays=" + numberOfWorkdays +
                '}';
    }
}
