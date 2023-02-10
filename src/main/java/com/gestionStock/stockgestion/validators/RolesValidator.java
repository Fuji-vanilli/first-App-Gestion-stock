package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.RolesDTO;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validate(RolesDTO rolesDTO){
        List<String> errors= new ArrayList<>();

        if(rolesDTO== null){
            errors.add("Verifie the roles");
            throw new InvalidEntityException(
                    "The roles name doesn't exist",
                    ErrorCode.ROLES_NOT_VALID,
                    errors
            );
        }
        if(!StringUtils.hasLength(rolesDTO.getName())){
            errors.add("The roles name is null");
        }
        
        return errors;
    }
}
