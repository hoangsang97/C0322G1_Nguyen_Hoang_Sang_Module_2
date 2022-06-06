package _quan_ly_nhan_vien.models;

public class ProductionStaff extends Staff{
    private int product;
    private double price;

    public ProductionStaff() {
    }

    public ProductionStaff(int id, String name, String dateOfBirth, String address, int product, double price) {
        super(id, name, dateOfBirth, address);
        this.product = product;
        this.price = price;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductionStaff{" + super.toString() +
                "product=" + product +
                ", price=" + price +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getName(),
                super.getDateOfBirth(),
                super.getAddress(),
                this.getProduct(),
                this.getPrice(),
                "Sản xuất");
    }
}
