package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.LineCommandCustomerRequest;

import java.util.ArrayList;
import java.util.List;

public class LineCommandCustomerValidator {

    public static List<String> validate(LineCommandCustomerRequest lineCommandCustomerRequest){
        List<String> errors= new ArrayList<>();

        if(lineCommandCustomerRequest== null)
            errors.add("line of command is null");
        if(lineCommandCustomerRequest.getArticle()== null)
            errors.add("article is null");
        return errors;
    }
}
