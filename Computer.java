package project;

public class Computer extends Product {

    private int ramCapacity;
    private String CPUType;
    private int storage;
    private String OperatingSystem;

    public Computer() {
        this(0, "", "", 0.0, 0, "", 0, "");
    }

    public Computer(int productCode, String name, String brand, double price, int ramCapacity, String CPUType, int storage, String OperatingSystem) {
        super(productCode, name, brand, price);
        this.ramCapacity = ramCapacity;
        this.CPUType = CPUType;
        this.storage = storage;
        this.OperatingSystem = OperatingSystem;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public void setCPUType(String CPU) {
        this.CPUType = CPUType;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setOperatingSystem(String OperatingSystem) {
        this.OperatingSystem = OperatingSystem;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public String getCPUType() {
        return CPUType;
    }

    public int getStorage() {
        return storage;
    }

    public String getOperatingSystem() {
        return OperatingSystem;
    }

    @Override
    public final String ProductType() {
        return "Computer";
    }

    @Override
    public final double calcPrice() {

        double price = getPrice();

        if (getRamCapacity() > 4) {
            price += 100;
        }

        if (getStorage() > 250) {
            price += 300;
        }

        return price;
    }

    @Override
    public String toString() {
        return String.format("%s\n{ RAM Capacity: %dGB  ||  CPU Type: %s  ||  Storage: %dGB  ||  Operating System: %s }", super.toString(), getRamCapacity(), getCPUType(), getStorage(), getOperatingSystem());
    }
}
