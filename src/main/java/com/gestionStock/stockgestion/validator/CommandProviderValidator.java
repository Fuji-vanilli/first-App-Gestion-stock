package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.CommandProviderRequest;

import java.util.ArrayList;
import java.util.List;

public class CommandProviderValidator {

    public static List<String> validate(CommandProviderRequest commandProviderRequest){
        List<String> errors= new ArrayList<>();

        if(commandProviderRequest== null)
            errors.add("command provider is null");
        if(commandProviderRequest.getCode()== null)
            errors.add("the code of command is null");
        if(commandProviderRequest.getProvider()== null)
            errors.add("the provider is null");

        return errors;
    }
}
