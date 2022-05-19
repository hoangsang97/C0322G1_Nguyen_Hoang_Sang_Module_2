package ss11_dsa_stack_queue.exercise.demerging_use_queue;

public class Demerging implements Comparable<Demerging> {
    private String name;
    private boolean gender;
    private int birth;

    public Demerging(String name, boolean gender, int birth) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public Demerging() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }

    @Override
    public int compareTo(Demerging o) {
        if (this.getBirth() > o.getBirth()) {
            return 1;
        } else if (this.getBirth() < o.getBirth()) {
            return -1;
        } else {
            return 1;
        }
    }
}
