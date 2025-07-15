package project;

public class Speaker extends Product {

    private String type;
    private String connectivity;

    public Speaker() {
        this(0, "", "", 0.0, null, null);
    }

    public Speaker(int productCode, String name, String brand, double price, String type, String connectivity) {
        super(productCode, name, brand, price);
        setType(type);
        setConnectivity(connectivity);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    @Override
    public final String ProductType() {
        return "Speaker";
    }

    @Override
    public final double calcPrice() {

        double price = getPrice();

        if (connectivity != "wired") {
            price += 150;
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s\n{ Type : %s  ||  Connectivity Technology : %s }", super.toString(), getType(), getConnectivity());
    }

}
