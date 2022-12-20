package com.javatechie.k8s.exception;

public class StationNotFoundException extends RuntimeException{

    public StationNotFoundException(String message) {
        super(message);
    }
}

