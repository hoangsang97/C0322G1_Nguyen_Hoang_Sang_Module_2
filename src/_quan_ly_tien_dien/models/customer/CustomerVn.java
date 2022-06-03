package _quan_ly_tien_dien.models.customer;

public class CustomerVn extends Customer {
    private String type;
    private double consume;

    public CustomerVn() {
    }

    public CustomerVn(String id, String name, String type, double consume) {
        super(id, name);
        this.type = type;
        this.consume = consume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getConsume() {
        return consume;
    }

    public void setConsume(double consume) {
        this.consume = consume;
    }

    @Override
    public String toString() {
        return "CustomerVn{" + super.toString() +
                "type='" + type + '\'' +
                ", consume=" + consume +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s",
                super.getId(),
                super.getName(),
                this.getType(),
                this.getConsume());
    }
}
