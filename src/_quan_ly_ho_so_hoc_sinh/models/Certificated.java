package _quan_ly_ho_so_hoc_sinh.models;

public class Certificated {
    private int certificatedID;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;

    public Certificated() {
    }

    public Certificated(int certificatedID, String certificateName, String certificateRank, String certificatedDate) {
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }

    public int getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(int certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    @Override
    public String toString() {
        return "Certificated{" +
                "certificatedID=" + certificatedID +
                ", certificateName='" + certificateName + '\'' +
                ", certificateRank='" + certificateRank + '\'' +
                ", certificatedDate='" + certificatedDate + '\'' +
                '}';
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s",
                this.getCertificatedID(),
                this.getCertificateName(),
                this.getCertificateRank(),
                this.getCertificatedDate());
    }
}
