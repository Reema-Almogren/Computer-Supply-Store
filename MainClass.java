package project;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MainClass {

    public static ArrayList<Product> products = new ArrayList<Product>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        fillList();

        System.out.println("Welcome to computer suply store :))");
        System.out.println("What would you like to do ? ");
        int Ch;
        Order order = null;
        try {

            do {
                menu();
                Ch = input.nextInt();

                switch (Ch) {

                    case 1: //to add products
                        System.out.println("1.Computer\n2.Monitor\n3.Keyboard\n4.Speaker");
                        System.out.println("---");
                        System.out.print("Select Product Type: ");
                        int ProductType = input.nextInt();
                        if (ProductType < 1 || ProductType > 4) {
                            System.out.println("Invalid Product !");
                            break;
                        }
                        System.out.print("Enter Product Code: ");
                        int ProductCode = input.nextInt();
                        System.out.print("Enter Product Name: ");
                        String name = input.next();
                        System.out.print("Enter Product Brand: ");
                        String brand = input.next();
                        System.out.print("Enter Product Price: ");
                        double price = input.nextDouble();

                        if (ProductType == 1) {//computer
                            System.out.print("Enter RAM capicity: ");
                            int ram = input.nextInt();
                            System.out.print("Enter The Processor Type: ");
                            String processor = input.next();
                            System.out.print("Enter The Cmputer's Storage: ");
                            int storage = input.nextInt();
                            System.out.print("Enter The Opreating System: ");
                            String opreatingSystem = input.next();

                            Product Computer = new Computer(ProductCode, name, brand, price, ram, processor, storage, opreatingSystem);
                            products.add(Computer);

                        } else if (ProductType == 2) {//monitor
                            System.out.print("Enter The Monitor Size: ");
                            double size = input.nextDouble();
                            System.out.print("Enter Monitor Resolution: ");
                            String resolution = input.next();
                            System.out.print("Enter true if it has touch false if it doesn't: ");
                            boolean MonitorTouch = input.nextBoolean();

                            Product Monitor = new Monitor(ProductCode, name, brand, price, size, resolution, MonitorTouch);
                            products.add(Monitor);

                        } else if (ProductType == 3) {//keyboard

                            System.out.print("Enter true if it has touch false if it dousn't: ");
                            boolean KeyboardTouch = input.nextBoolean();
                            System.out.print("Enter What Languges do you want: ");
                            String languge = input.next();

                            Product Keyboard = new Keyboard(ProductCode, name, brand, price, KeyboardTouch, languge);
                            products.add(Keyboard);
                        } else if (ProductType == 4) {//speaker

                            System.out.print("Enter Speaker's Type: ");
                            String type = input.next();
                            System.out.print("Enter connectivity: ");
                            String connectivity = input.next();

                            Product Speaker = new Speaker(ProductCode, name, brand, price, type, connectivity);
                            products.add(Speaker);
                        }
                        System.out.println("*** Product has been added ! ***");
                        break;
 
                    case 2: //to remove products
                        System.out.print("Enter Product Code: ");
                        int productCode = input.nextInt();
                        int index = -1;
                        for (int i = 0; i < products.size(); i++) {
                            if (products.get(i).getProductCode() == productCode) {
                                index = i;
                                break;
                            }
                        }
                        if (index == -1) {
                            System.out.println("Product with Code " + productCode + " is not found!");
                            break;
                        }
                        products.remove(index);
                        System.out.println("Product with Code " + productCode + " has been remove successfully!");
                        break;

                    case 3: //to show products
                        System.out.println("*** Product List ***");
                        for (Product pr : products) {
                            System.out.println(pr);
                            System.out.printf("Price: %.2f SAR\n", pr.calcPrice());
                            System.out.println("---------------------------------------------------");
                        }
                        break;

                    case 4: //to show computers
                        System.out.println("*** All Computers ***");
                        for (Product pr : products) {
                            if (pr instanceof Computer) {
                                System.out.println(pr);
                                System.out.printf("Price: %.2f SAR\n", pr.calcPrice());
                                System.out.println("-------------------------------------------------------");
                            }
                        }
                        break;

                    case 5: //to make orders
                        System.out.print("How many items? ");
                        int size = input.nextInt();

                        if (size <= 0) {
                            System.out.println("Invalid number!");
                            break;
                        }

                        Product[] orderProducts = new Product[size];
                        System.out.println("Enter " + size + " ProductCodes:");
                        int count = 0;
                        while (count < size) {
                            System.out.printf("Enter product #%d ProductCode: ", (count + 1));
                            productCode = input.nextInt();

                            boolean isFound = false;
                            for (Product p : products) {
                                if (p.getProductCode() == productCode) {
                                    orderProducts[count] = p;
                                    isFound = true;
                                    break;
                                }
                            }
                            if (!isFound) {
                                System.out.println("Invalid ProductCode");
                            } else {
                                count++;
                            }
                        }

                        System.out.print("Enter your first name: ");
                        name = input.next();
                        System.out.print("Email :");
                        String email = input.next();
                        System.out.println("Enter Order Date");
                        System.out.print("Year: ");
                        int year = input.nextInt();
                        System.out.print("Month: ");
                        int month = input.nextInt();
                        System.out.print("Day: ");
                        int day = input.nextInt();

                        Customer customer = new Customer(name, email);
                        Date date = new Date(day, month, year);
                        order = new Order(customer, orderProducts, date);

                        System.out.print("Confirm order? (Y/N): ");
                        char answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            order.setStatus("Confirmed");
                            order.print();
                            System.out.println("*** Your order has been confirmed! ***");
                        } else {
                            order = null;
                            System.out.println("Your order is cancelled succssfully!");
                        }
                        break;

                    case 6: //to show orders
                        if (order != null) {
                            order.print();
                        } else {
                            System.out.println("No current order yet");
                        }
                        break;

                    case 7: //to cancle orders
                        if (order != null) {
                            System.out.println("Are you sure you want to cancel your order ? (Y/N)");
                            answer = input.next().charAt(0);
                            if (answer == 'Y' || answer == 'y') {
                                order.setStatus("Cancelled");
                                order.print();
                                System.out.println("Your order has been cancelled");
                            } else {
                                System.out.println("Your order is not cancelled");
                            }
                        } else {
                            System.out.println("No current order yet");
                        }
                        break;

                    case 8: //to read files
                        ReadFiles read = new ReadFiles();

                        read.openTextFile("project.txt");
                        read.readFromFile();
                        read.closeFile();
                        break;

                    case 9: //to exit and data are saved to files

                        //write to text file
                        WriteFiles write = new WriteFiles();
                        write.openTextFile("project.txt");

                        for (Product e : products) {
                            write.writeToFile(e);
                        }

                        write.closeFile();
                        System.out.println("Data has been saved to project.txt file :)");

                        System.out.println("Thank you for using our services");
                        break;

                    default:
                        System.out.println("Invalid option");
                }
            } while (Ch != 9);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Enter the correct value!");
        } catch (NullPointerException e) {
            System.out.println("Invalid Object!");
        }
    }

    public static void menu() {
        System.out.print("\n1- Add Product\n2- Remove Product\n3- Show Product\n4- Show Computers\n"
                + "5- Make Order\n6- Show Order\n7- Cancel Order\n8- Read Text File\n9- Exit\n");
    }

    public static void fillList() {

        products.add(new Computer(101, "Apple Macbook Pro", "Apple", 12500.0, 16, "8-core", 512, "macOS Monterey"));
        products.add(new Monitor(102, "Large Monitor", "Samsung", 5000.0, 24.0, "HD", true));
        products.add(new Keyboard(111, "keyboardHD", "Apple", 2500.0, true, "English"));
        products.add(new Speaker(12, "sonos Roam", "Bose ", 200, "headphones", "Bluetooth"));

        System.out.println("executed!");
    }
}
