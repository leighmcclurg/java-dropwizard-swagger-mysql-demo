package org.kainos.ea.client;

public class FailedToCreateProductException extends Throwable{
    @Override
    public String getMessage(){

        return "failed to create order";
    }

}
