package org.kainos.ea.cli;
import java.util.Date;

//Update your `Product` class to implement the `Comparable` interfact,
public class Product implements Comparable<Product>{
    private int productId;
    private String name;
    private double price;


    public Product(int productId, String name, String description, double price) {
        setProductId(productId);
        setName(name);
        setDescription(description);
        setPrice(price);
    }

    private String description;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Update the `compareTo` method to compare the name of the product object with the product passed in via parameter.
    //This is the method that the sort method will call in your `ProductService` class.
    //Notice the output in the console when you try and print the objects in the product list.
    //As we haven't told our code how to print a Product object it simply prints the object reference which isn't very useful
   // @Override
    //public int compareTo(Product product) {
    //    return this.getName().compareTo(product.getName());
   // }

//Update the `compareTo` method to compare the price of the products rather than the name.
//Notice your list is now printed in order of price

    @Override
    public int compareTo(Product product) {
        return Double.compare(this.getPrice(), product.getPrice());
    }
    //In order to print a user friendly message from our product
    //objects we need to override the `toString` method in the `Product` class.
    @Override
    public String toString(){
        return "Product name:" + this.getName() + " Product price: £" + this.getPrice();

    }
}