package org.kainos.ea.client;

public class FailedToDeleteOrderException extends Exception {


    @Override
    public String getMessage(){

        return "failed to delete order";
    }

}
