package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.UserRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserRequest userRequest){
        List<String> errors= new ArrayList<>();

        if(userRequest == null || !StringUtils.hasLength(userRequest.getEmail())){
            errors.add("user doesn't empty and email is required");
        }
        if(userRequest.getEntreprise()== null){
            errors.add("entreprise is required");
        }
        if(userRequest.getRoles()== null){
            errors.add("roles is required!");
        }

        return errors;
    }
}
