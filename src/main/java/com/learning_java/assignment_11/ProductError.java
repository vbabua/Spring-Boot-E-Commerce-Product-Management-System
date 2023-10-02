package com.learning_java.assignment_11;

public class ProductError extends Exception{
    private String errorMessage;
    public ProductError(String errorMessage) {
        super(errorMessage);
    }

    /*public ProductError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }*/
}
