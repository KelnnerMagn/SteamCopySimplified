package com.example;

public class ItemDoesNotExistException extends Exception {

    public ItemDoesNotExistException(String msg) {
        super(msg);
    }
}
