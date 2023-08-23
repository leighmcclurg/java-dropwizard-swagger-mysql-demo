package org.kainos.ea.client;

public class FailedToGetProductsException extends Throwable {
    @Override

    public String getMessage(){

        return "failed to get products from database";
    }
}
