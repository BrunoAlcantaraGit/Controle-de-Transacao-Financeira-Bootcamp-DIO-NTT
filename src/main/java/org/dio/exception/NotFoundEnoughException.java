package org.dio.exception;

public class NotFoundEnoughException extends RuntimeException{
    public NotFoundEnoughException(String messeg){
        super(messeg);
    }
}
