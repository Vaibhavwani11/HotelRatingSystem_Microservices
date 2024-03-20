package com.microservices.hotel.HotelService.Exceptions;

//Creating a Custom Exception
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException(){
        super("Resource not found (Created Custom Exception without msg)");
    }
}
