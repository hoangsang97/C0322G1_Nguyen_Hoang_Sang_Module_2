package _case_study.utils;

import _case_study.models.booking.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate starDate1 = LocalDate.parse(o1.getStarDate(), dateTimeFormatter);
        LocalDate starDate2 = LocalDate.parse(o2.getStarDate(), dateTimeFormatter);
        LocalDate endDate1 = LocalDate.parse(o2.getEndDate(), dateTimeFormatter);
        LocalDate endDate2 = LocalDate.parse(o2.getEndDate(), dateTimeFormatter);

        if (starDate1.compareTo(starDate2) > 0) {
            return 1;
        } else if (starDate1.compareTo(starDate2) < 0) {
            return -1;
        } else {
            if (endDate1.compareTo(endDate2) > 0) {
                return 1;
            } else if (endDate1.compareTo(endDate2) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
