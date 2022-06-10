package _quan_ly_ho_so_hoc_sinh.models;

public abstract class Candidate {
    private int candidateID;
    private String fullName;
    private String birthDay;
    private int phone;
    private String email;
    private String candidateType;
    private int candidateCount;

    public Candidate() {
    }

    public Candidate(int candidateID, String fullName, String birthDay, int phone, String email, String candidate_type, int candidate_count) {
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        candidateType = candidate_type;
        candidateCount = candidate_count;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    public int getCandidateCount() {
        return candidateCount;
    }

    public void setCandidateCount(int candidateCount) {
        this.candidateCount = candidateCount;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "CandidateID=" + candidateID +
                ", FullName='" + fullName + '\'' +
                ", BirthDay='" + birthDay + '\'' +
                ", Phone=" + phone +
                ", Email='" + email + '\'' +
                ", Candidate_type='" + candidateType + '\'' +
                ", Candidate_count='" + candidateCount + '\'' +
                '}';
    }

    public abstract String getInfo();
}
