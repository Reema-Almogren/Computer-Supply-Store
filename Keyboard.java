package project;

public class Keyboard extends Product {

    private boolean touch;
    private String language;

    public Keyboard() {
        this(0, "", "", 0.0, false, null);
    }

    public Keyboard(int productCode, String name, String brand, double price, boolean touch, String language) {
        super(productCode, name, brand, price);
        setTouch(touch);
        setLanguage(language);
    }

    public boolean getTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public final String ProductType() {
        return "Keyboard";
    }

    @Override
    public final double calcPrice() {

        double price = getPrice();

        if (language != "English") {
            price += 50;
        }
        if (touch == true) {
            price += 100;
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s\n{ Touch : %s  ||  Language : %s }", super.toString(), getTouch(), getLanguage());
    }

}
