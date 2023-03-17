package com.gestionStock.stockgestion.validator;


import com.gestionStock.stockgestion.DTOs.request.CustomerRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public static List<String> validate(CustomerRequest customerRequest){
        List<String> errors= new ArrayList<>();

        if(customerRequest == null || (!StringUtils.hasLength(customerRequest.getFirstName()) && !StringUtils.hasLength(customerRequest.getLastName()))){
            errors.add("customer doesn't empty and firstname, lastname are required");
        }
        if(customerRequest.getAdress()== null){
            errors.add("adress is required");
        }
        if(customerRequest.getCommandClient()== null){
            errors.add("command is required is required!");
        }

        return errors;
    }
}
