package project;

public class Customer {

    private String name;
    private String Email;

    public Customer() {
        this("", "");
    }

    public Customer(String name, String Email) {
        this.name = name;
        this.Email = Email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {

        return String.format("name :" + getName() + "\nEmail :" + getEmail());
    }
}
