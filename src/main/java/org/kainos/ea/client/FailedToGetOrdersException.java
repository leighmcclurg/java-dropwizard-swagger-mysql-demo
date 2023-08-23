package org.kainos.ea.client;

public class FailedToGetOrdersException extends Throwable {
    @Override
    public String getMessage(){

        return "failed to get orders from database";
    }
}



