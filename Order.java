package project;

public class Order implements Printable {

    private int ProductCode;
    private String status;
    private Customer customer;
    private Product[] product;
    private Date date;
    private static int count;

    public Order() {
        this(null, null, null);
    }

    public Order(Customer customer, Product[] product, Date date) {
        this.ProductCode = ++count;
        this.status = "New";
        this.customer = customer;
        this.product = product;
        this.date = date;
        this.count = count;
    }

    public void setID(int ProductCode) {
        this.ProductCode = ProductCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProducts(Product[] product) {
        this.product = product;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public int getProductCode() {
        return ProductCode;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product[] getProduct() {
        return product;
    }

    public Date getDate() {
        return date;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {

        return String.format("ProductCode is: " + getProductCode() + "status: " + getStatus() + "customer: " + getCustomer()
                + "product: " + getProduct() + "date: " + getDate()
                + "count: " + getCount());
    }

    @Override
    public void print() {

        System.out.println("Order: " + getProductCode());
        System.out.println("Status: " + getStatus());
        System.out.println("Customer: " + getCustomer());
        System.out.println("Date: " + getDate());
        System.out.println("Products: ");

        double total = 0;

        try {
            for (Product product : product) {

                System.out.println(product);
                System.out.println("----------------------");
                total += product.calcPrice();
            }
            total += total * Printable.VAT;
            System.out.printf("Total Price with Tax is : %.2f SAR\n", total);
        } catch (NullPointerException e) {
            System.out.println("Invalid object!");
        }
    }
    
}
