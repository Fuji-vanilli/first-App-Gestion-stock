package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.AdressRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdressValidator {

    public List<String> validate(AdressRequest adressRequest){
        List<String> errors= new ArrayList<>();

        if(adressRequest == null || !StringUtils.hasLength(adressRequest.getAdress1())){
            errors.add("adress doesn't empty and adress1 is required");
        }
        if(!StringUtils.hasLength(adressRequest.getCodePostale())){
            errors.add("code postal is required");
        }
        if(!StringUtils.hasLength(adressRequest.getCity())){
            errors.add("city is required!");
        }

        return errors;
    }
}
