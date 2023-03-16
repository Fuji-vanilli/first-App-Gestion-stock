package com.gestionStock.stockgestion.exception;

public enum ErrorCode {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),

    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),

    COMMAND_CUSTOMER_NOT_FOUND(3000),
    COMMAND_CUSTOMER_NOT_VALID(3001),

    COMMAND_PROVIDER_NOT_FOUND(4000),
    COMMAND_PROVIDER_NOT_VALID(4001),

    CUSTOMER_NOT_FOUND(5000),
    CUSTOMER_NOT_VALID(5001),

    ENTREPRISE_NOT_FOUND(6000),
    ENTREPRISE_NOT_VALID(6001),

    LINE_COMMAND_CUSTOMER_NOT_FOUND(7000),
    LINE_COMMAND_CUSTOMER_NOT_VALID(7001),

    LINE_COMMAND_PROVIDER_NOT_FOUND(8000),
    LINE_COMMAND_PROVIDER_NOT_VALID(8001),

    LINE_SALE_NOT_FOUND(9000),
    LINE_SALE_NOT_VALID(9001),

    MVT_STOCK_NOT_FOUND(10000),
    MVT_STOCK_NOT_VALID(10001),

    PROVIDER_NOT_FOUND(20000),
    PROVIDER_NOT_VALID(20001),

    ROLES_NOT_FOUND(30000),
    ROLES_NOT_VALID(30001),

    USER_NOT_FOUND(40000),
    USER_NOT_VALID(40001);
    private int code;

    ErrorCode(int code){
        this.code= code;
    }

    public int getCode(){
        return this.code;
    }
}