package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.UserDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserValidator {

    public static List<String> validate(UserDTO userDTO){
        List<String> errors= new ArrayList<>();

        if(userDTO== null){
            Stream.of(
                    "Verifie the firstname",
                    "Verifie the password",
                    "Verifie the email"
            ).forEach(error->{
                errors.add(error);
            });
        }
        if(!StringUtils.hasLength(userDTO.getFirstName())){
            errors.add("The firstname doesn't null");
        }
        if(!StringUtils.hasLength(userDTO.getEmail())){
            errors.add("The email doesn't null");
        }
        if(userDTO.getAdress()== null){
            errors.add("The Adress doesn't null");
        }

        return errors;
    }
}
