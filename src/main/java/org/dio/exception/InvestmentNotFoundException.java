package org.dio.exception;

public class InvestmentNotFoundException extends RuntimeException{

    public InvestmentNotFoundException(String messege){
        super(messege);
    }
}
