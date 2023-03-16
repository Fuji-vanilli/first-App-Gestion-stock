package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.ProviderRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProviderValidator {

    public List<String> validate(ProviderRequest providerRequest){
        List<String> errors= new ArrayList<>();

        if(providerRequest == null || (!StringUtils.hasLength(providerRequest.getEmail()) && !StringUtils.hasLength(providerRequest.getName()))){
            errors.add("provider doesn't empty and email is required");
        }
        if(providerRequest.getCommandFournisseurs()== null){
            errors.add("command fournisseur is required");
        }
        if(providerRequest.getAdress()== null){
            errors.add("adress is required!");
        }

        return errors;
    }
}
