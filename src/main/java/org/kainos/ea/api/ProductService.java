package org.kainos.ea.api;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.cli.Product;
import org.kainos.ea.core.ProductValidator;
import org.kainos.ea.db.ProductDao;

import java.sql.SQLException;
import java.util.*;

public class ProductService {
    private ProductDao productDao = new ProductDao();
    private ProductValidator productValidator = new ProductValidator();

    public List<Product> getAllProducts() throws FailedToGetProductsException {

        try {
            List<Product> productList = productDao.getAllProducts();
            return productList;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        throw new FailedToGetProductsException();

        //   Product product = productList.get(10000);
        // }catch (IndexOutOfBoundsException e) {
        //      System.err.println(e.getMessage());
        //   }

        //  System.out.println(productList);

        // for loop to get total price
        //for (int i = 0; i< productList.size(); i++) {
        //totalPriceOfProduct += productList.get(i).getPrice();

        //while loop for total price of products

        //  Iterator<Product> productIterator = productList.iterator();

        //   while(productIterator.hasNext()) {
        //     Product product = productIterator.next();
        // totalPriceOfProduct += product.getPrice();

        //do while loop to get total price
        //     Iterator<Product> productIterator = productList.iterator();
        //do {
        //     Product product = productIterator.next();
        //    totalPriceOfProduct += product.getPrice();
        // } while (productIterator.hasNext());

        //stream to find total price

        // totalPriceOfProduct =productList.stream().mapToDouble(product -> product.getPrice()).sum();

        //foreachloop for products under 100
        ////totalPriceOfCheapProduct += productList.get(i).getPrice();
        //  for(Product product : productList) {
        //    if (product.getPrice() < 100){
        //      totalPriceOfCheapProduct +=product.getPrice();
        // }
        //}

        //for each loop to print total price of all products that cost less than £100
        //and total of products >=£100

        //  double totalPriceOfCheapProduct=0;
        //double totalPriceOfExpensiveProduct=0;

        //for (Product product : productList){
        //  if (product.getPrice() < 100) {
        //    totalPriceOfCheapProduct += product.getPrice();
        //}else{
        //  totalPriceOfExpensiveProduct +=product.getPrice();
        //}
        //}

        //for each loop to print the price of specific products
        //for (Product product : productList){
        //  switch (product.getName()){
        //    case ("HEATER"):
        //      System.out.println("This is the heater price £"  +product.getPrice());
        //    break;
        //case ("LIGHTBULB"):
        //  System.out.println("This is the lightbulb price £"  +product.getPrice());
        // break;
        //case ("CHAIR"):
        //  System.out.println("This is the chair price £"  +product.getPrice());
        // break;
        //default:
        //      System.out.println("This is the other price £"  +product.getPrice());
        // }
        //}

        //create a list of integers with one duplciated value
        //List<Integer> intList = Arrays.asList(1,2,2,4,5);
        //intList.stream().forEach(System.out::println);

        //Create a set of integers and assign it the values from the
        //list created above and print out the set
        //Notice the difference between the values in the list and the values in the set.
        //A set only can be used to store unique values.

        // List<Integer> intList = Arrays.asList(1,2,2,4,5);
        // Set<Integer> intSet = new HashSet<>(intList);
        //intSet.stream().forEach(System.out::println);

// Try and sort your list and print the list out. Notice you get an error,
// that is because we haven't told our code how to sort the Product class
        //  Collections.sort(productList);
        //  productList.stream().forEach(System.out::println);

        //in your `ProductService` class update your code to only print
        //the minimum item in the list

        //print out min price in list
        // System.out.println(Collections.min(productList));

        //print out max price in list
        //System.out.println(Collections.max(productList));

        //print products higher than £10
        //productList.stream().filter(product -> product.getPrice() > 10).forEach(System.out::println);

        //System.out.println("Total price of cheap products £" + totalPriceOfCheapProduct);
        //System.out.println("Total price of cheap products £" + totalPriceOfExpensiveProduct);
        //System.out.println("Total price of products: £" + totalPriceOfProduct);
        //return productList;
    }

    public Product getProductsById(int id) throws FailedToGetProductsException, ProductDoesNotExistException {
        try {
            Product product = productDao.getProductById(id);
            if (product == null) {
                throw new ProductDoesNotExistException();
            }
            return product;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetProductsException();
        }
    }


    public int createProduct(ProductRequest product) throws FailedToCreateProductException, InvalidProductException {
        try {

            String validation = productValidator.isValidProduct(product);

            if (validation != null) {
                throw new InvalidProductException(validation);
            }

            int id = productDao.createProduct(product);
            if (id == -1) {

                throw new FailedToCreateProductException();

            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateProductException();
        }

    }

    public void updateProduct(int id, ProductRequest product) throws InvalidProductException, ProductDoesNotExistException, FailedToUpdateProductException {
        try {
            String validation = productValidator.isValidProduct(product);

            if (validation != null) {
                throw new InvalidProductException(validation);
            }
            Product productToUpdate = productDao.getProductById(id);

            if (productToUpdate == null) {
                throw new ProductDoesNotExistException();
            }
            productDao.updateProduct(id, product);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProductException();
        }
    }

    public void deleteProduct(int id) throws ProductDoesNotExistException, FailedToDeleteProductException {

        try {
            Product productToDelete = productDao.getProductById(id);

            if (productToDelete == null) {

                throw new ProductDoesNotExistException();
            }
            productDao.deleteProduct(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteProductException();
        }

    }


}



