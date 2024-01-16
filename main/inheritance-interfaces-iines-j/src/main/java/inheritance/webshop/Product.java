package inheritance.webshop;

import interfaces.markdown.MarkdownExport;

/**
 * This class represents products in a webshop application. The class will be
 * used as a base class for various product types in the next parts of the
 * exercise.
 *
 * You will need to add the following private instance variables to the class:
 * title (string), description (string) and price (double). The class already
 * has a constructor that takes the values as arguments, but you need to
 * complete its implementation.
 *
 * Also, create getter methods getTitle(), getDescription() and getPrice() to
 * return the values of the instance variables.
 *
 * Finally, create a toString() method that returns a string representation of
 * the product. You can decide yourself how the string should look like, but it
 * must contain the title, description and price of the product.
 *
 * Note that this class itself does not utilize inheritance, but it will
 * extended by other classes in the exercise.
 */
public class Product implements MarkdownExport {

    private String title = "";
    private String description = "";
    private double price = 0.0;

    public Product(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String x = "Title: " + this.title + ", description: " + this.description + ", price: " + this.price;
        return x;
    }

    public String exportMarkdown() {
        String x = "<pre>\n" + "# " + this.title + "\n" + "\nDescription:\n" + this.description;
        x += "\nPrice: " + this.price + "\n</pre>";

        return x;
    }

}
