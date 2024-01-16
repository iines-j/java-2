package inheritance.webshop;

/**
 * This class represents vehicles in a webshop application. Vehicles are
 * products, but they have some additional properties that other products do not
 * have, such as the manufacturer, the model and the year.
 *
 * In this exercise, you need to make the Vehicle class inherit the Product
 * class. Here, you will need to use the `extends` keyword. You also need to add
 * the following private instance variables to the class: manufacturer (string),
 * model (string) and year (int) and getters for each of them.
 *
 * The constructor of the Vehicle class is already present, but you will need to
 * complete its implementation.
 *
 * Also, create a toString() method that returns a string representation of the
 * vehicle. You can decide yourself how the string should look like, but it must
 * contain both the product properties and the vehicle properties.
 *
 * Read more at https://dev.java/learn/inheritance/
 */
public class Vehicle extends Product {

    private String manufacturer = "";
    private String model = "";
    private int year = 0;

    public Vehicle(String title, String description, double price, String manufacturer, String model, int year) {
        super(title, description, price);

        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        String x = super.toString() + ", manufacturer: " + this.manufacturer + ", model: " + this.model + ", year: "
                + this.year;
        return x;
    }

}
