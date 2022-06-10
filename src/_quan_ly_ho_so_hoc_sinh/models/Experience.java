package _quan_ly_ho_so_hoc_sinh.models;

import java.util.List;

public class Experience extends Candidate {
    private String expInYear;
    private String proSkill;
    private Certificated certificated;

    public Experience() {
    }

    public Experience(int candidateID, String fullName, String birthDay, int phone, String email, String candidate_type, int candidate_count, String expInYear, String proSkill, Certificated certificated) {
        super(candidateID, fullName, birthDay, phone, email, candidate_type, candidate_count);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
        this.certificated = certificated;
    }

    public String getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(String expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public Certificated getCertificated() {
        return certificated;
    }

    public void setCertificated(Certificated certificated) {
        this.certificated = certificated;
    }

    @Override
    public String toString() {
        return "Experience{" + super.toString() +
                "expInYear='" + expInYear + '\'' +
                ", proSkill='" + proSkill + '\'' +
                ", certificated=" + certificated +
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
                this.getExpInYear(),
                this.getProSkill(),
                certificated.getCertificatedID());
    }
}
