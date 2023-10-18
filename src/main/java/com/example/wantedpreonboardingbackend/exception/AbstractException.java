package com.example.wantedpreonboardingbackend.exception;

public abstract class AbstractException extends RuntimeException {

    abstract public int getStatusCode();

    abstract public String getData();

}
