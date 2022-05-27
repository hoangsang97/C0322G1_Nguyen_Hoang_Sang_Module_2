package ss17_io_binarifile_and_serialization.exercise.product_manager_saves;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String Name;
    private String production;
    private int price;

    public Product() {
    }

    public Product(int id, String name, String production, int price) {
        this.id = id;
        Name = name;
        this.production = production;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", production='" + production + '\'' +
                ", price=" + price +
                '}';
    }
}
