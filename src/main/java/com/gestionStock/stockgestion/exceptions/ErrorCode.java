package com.gestionStock.stockgestion.exceptions;

public enum ErrorCode {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),

    ADRESS_NOT_FOUND(2000),
    ADRESS_NO_VALID(2001),

    CATEGORY_NOT_FOUND(3000),
    CATEGORY_NOT_VALID(3001),

    CLIENT_NOT_FOUND(4000),
    CLIENT_NOT_VALID(4001),

    COMMAND_CLIENT_NOT_FOUND(5000),
    COMMAND_CLIENT_NOT_VALID(5001),

    ENTREPRISE_NOT_FOUND(6000),
    ENTREPRISE_NOT_VALID(6001),

    FOURNISSEUR_NOT_FOUND(7000),
    FOURNISSEUR_NOT_VALID(7001),

    LIGNE_COMMAND_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMAND_CLIENT_NOT_VALID(8001),

    LIGNE_COMMAND_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_COMMAND_FOURNISSEUR_NOT_VALID(9001),

    LIGNE_VENTE_NOT_FOUND(10000),
    LIGNE_VENTE_NOT_VALID(10001),

    ROLES_NOT_FOUND(11000),
    ROLES_NOT_VALID(11001),

    MVMT_STOCK_NOT_FOUND(12000),
    MVMT_STOCK_NOT_VALID(12001),

    USER_NOT_FOUND(13000),
    USER_NOT_VALID(13001),

    VENTE_NOT_FOUND(14000),
    VENTE_NOT_VALID(14001),

    COMMAND_FOURNISSEUR_NOT_FOUND(15000),
    COMMAND_FOURNISSEUR_NOT_VALID(15000);

    private int code;

    ErrorCode(int code){
        this.code= code;
    }
}
