package com.example;

public class ItemAlreadyExistException extends Exception {

    public ItemAlreadyExistException(String msg) {
        super(msg);
    }
}
