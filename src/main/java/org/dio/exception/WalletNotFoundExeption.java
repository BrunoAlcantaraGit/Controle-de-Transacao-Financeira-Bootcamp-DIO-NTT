package org.dio.exception;

public class WalletNotFoundExeption extends RuntimeException{

    public WalletNotFoundExeption(String messege){
        super(messege);
    }
}
