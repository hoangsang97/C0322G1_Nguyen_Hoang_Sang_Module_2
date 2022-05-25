package ss12_java_collection_framework.test;


public class Product implements Comparable<Product> {

    private int id;
    private String nameProduct;
    private double price;
    private int amount;
    private String production ;

    public Product(int id, String nameProduct, double price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public Product(int id, String name, double price, int amount, String production) {
        this.id = id;
        this.nameProduct = name;
        this.price = price;
        this.amount = amount;
        this.production = production;
    }

    public Product() {
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj == null ){
            return false;
        } else {
            Product product = (Product) obj;
            if ( product.getId() == this.id ){
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int compareTo(Product o) {
        if (this.getId() > o.getId()){
            return 1;
        } else if (this.getId() < o.getId()){
            return -1;
        } else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + nameProduct + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", production='" + production + '\'' +
                '}';
    }

}
