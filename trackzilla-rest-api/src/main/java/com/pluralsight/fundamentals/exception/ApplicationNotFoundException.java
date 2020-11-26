package com.pluralsight.fundamentals.exception;

public class ApplicationNotFoundException extends  RuntimeException{
    public ApplicationNotFoundException(String exception){
        super(exception);
    }
}
