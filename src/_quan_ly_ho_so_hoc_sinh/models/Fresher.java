package _quan_ly_ho_so_hoc_sinh.models;

import java.util.ArrayList;
import java.util.List;

public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;
    private List<Certificated> certificated;

    public Fresher() {
    }

    public Fresher(int candidateID, String fullName, String birthDay, int phone, String email, String candidate_type, int candidate_count, String graduation_date, String graduation_rank, String education) {
        super(candidateID, fullName, birthDay, phone, email, candidate_type, candidate_count);
        graduationDate = graduation_date;
        graduationRank = graduation_rank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" + super.toString() +
                "Graduation_date='" + graduationDate + '\'' +
                ", Graduation_rank='" + graduationRank + '\'' +
                ", Education='" + education + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                super.getCandidateID(),
                super.getFullName(),
                super.getBirthDay(),
                super.getPhone(),
                super.getEmail(),
                super.getCandidateType(),
                super.getCandidateCount(),
                this.getGraduationDate(),
                this.getGraduationRank(),
                this.getEducation());
    }
}
