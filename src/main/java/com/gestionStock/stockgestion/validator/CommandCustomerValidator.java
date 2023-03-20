package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.CommandCustomerRequest;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CommandCustomerValidator {


    public static List<String> validate(CommandCustomerRequest commandCustomerRequest){
        List<String> errors= new ArrayList<>();

        if(commandCustomerRequest== null)
            errors.add("command doesn't null \n command not valid");
        if(commandCustomerRequest.getCustomer()== null)
            errors.add("the customer is null \n command not valid");
        if(commandCustomerRequest.getCode()== null)
            errors.add("the code customer is null \n command not valid");
        return errors;
    }
}
