package com.example.OnlineShop.exception;


public class UnsafeNewPassword extends RuntimeException {

    public UnsafeNewPassword(String exceptionMessage){
        super(exceptionMessage);
    }
}
