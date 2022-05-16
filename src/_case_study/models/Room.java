package _case_study.models;

public class Room extends Facility{
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(String serviceName, int usableArea, double rentalCosts, int maximumNumberOfPeople, String rentalType, String freeServiceIncluded) {
        super(serviceName, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }
}
