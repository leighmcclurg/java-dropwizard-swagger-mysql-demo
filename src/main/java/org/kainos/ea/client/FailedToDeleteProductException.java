package org.kainos.ea.client;

public class FailedToDeleteProductException extends Exception {


    @Override
    public String getMessage(){

        return "failed to delete product";
    }

}


