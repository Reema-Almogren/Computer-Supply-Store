package project;

public class Monitor extends Product {

    private double size;
    private String DisplayResolution; 
    private boolean touch; 

    public Monitor() {
        this(0, "", "", 0.0, 0.0, "", false);
    }

    public Monitor(int productCode, String name, String brand, double price, double size, String DisplayResolution, boolean touch) {
        super(productCode, name, brand, price);
        this.size = size;
        this.DisplayResolution = DisplayResolution;
        this.touch = touch;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setDisplayResolution(String DisplayResolution) {
        this.DisplayResolution = DisplayResolution;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    public double getSize() {
        return size;
    }

    public String getDisplayResolution() {
        return DisplayResolution;
    }

    public boolean isTouch() {
        return touch;
    }

    @Override
    public final String ProductType() {
        return "Monitor";
    }

    @Override
    public final double calcPrice() {

        double price = getPrice();

        if (getSize() == 14) {
            price += 150;
        } else if (getSize() == 28) {
            price += 300;
        } else if (isTouch() == true) {
            price += 1000;
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s\n{ The Monitor Size is: %.2f  ||  Resolution is: %s  ||  Touch Screen: %b }", super.toString(), getSize(), getDisplayResolution(), isTouch());
    }

}
