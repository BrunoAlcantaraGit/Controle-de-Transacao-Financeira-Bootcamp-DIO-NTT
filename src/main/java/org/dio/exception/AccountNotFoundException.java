package org.dio.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String messege){
        super(messege);
    }
}
