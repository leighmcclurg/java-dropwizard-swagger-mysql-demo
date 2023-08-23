package org.kainos.ea.client;

//sets the message to the string being passed in as a parameter.
public class InvalidProductException extends Throwable {
   public InvalidProductException(String error) {
       super(error);
   }

}
