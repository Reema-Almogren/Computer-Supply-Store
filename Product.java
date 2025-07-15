package project;

public abstract class Product {

    private final int productCode;
    private String name;
    private String brand;
    private double price;

    public Product() {
        this(0, "", "", 0.0);

    }

    public Product(int productCode, String name, String brand, double price) {
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getProductCode() {

        return productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String Brand) {
        this.brand = Brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double Price) {
        if (Price < 0) {

            System.out.println("Invalid price");

        } else {
            this.price = Price;
        }
    }

    public abstract String ProductType(); //the sub classes are forced to implements this method and it should return the product type

    public abstract double calcPrice(); //the sub classes are forced to implements this method and it should return the product ptice

    @Override
    public String toString() {

        return String.format("{ ProductCode: %d  ||  Name: %s  ||  Brand: %s  ||  Price: %s }", getProductCode(), getName(), getBrand(), getPrice());

    }
}
