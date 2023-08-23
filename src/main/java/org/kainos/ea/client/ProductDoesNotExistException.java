package org.kainos.ea.client;

public class ProductDoesNotExistException extends Throwable {


    @Override
    public String getMessage() {

        return "product does not exist";
    }
}