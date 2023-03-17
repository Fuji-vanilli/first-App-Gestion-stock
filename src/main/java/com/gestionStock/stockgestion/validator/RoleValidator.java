package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.DTOs.request.RoleRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {

    public static List<String> validate(RoleRequest roleRequest){
        List<String> errors= new ArrayList<>();

        if(roleRequest == null || !StringUtils.hasLength(roleRequest.getName())){
            errors.add("role doesn't empty and role name is required");
        }
        if(roleRequest.getUser()== null){
            errors.add("user is required!");
        }

        return errors;
    }
}
