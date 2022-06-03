package _quan_ly_tien_dien.models.customer;

public class CustomerNg extends Customer{
    private String nationality;

    public CustomerNg() {
    }

    public CustomerNg(String id, String name, String nationality) {
        super(id, name);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "CustomerNg{" + super.toString() +
                "nationality='" + nationality + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s",
                super.getId(),
                super.getName(),
                this.getNationality());
    }
}
