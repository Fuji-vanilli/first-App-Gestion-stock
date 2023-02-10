package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.ClientDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ClientValidator {

    public static List<String> validate(ClientDTO clientDTO){
        List<String> errors= new ArrayList<>();

        if(clientDTO== null) {
            Stream.of(
                    "Verifie the firstname",
                    "Verifie the lastname",
                    "Verifie the mail adress"
            ).forEach(error -> {
                errors.add(error);
            });
        }

        if(!StringUtils.hasLength(clientDTO.getFirstName())){
            errors.add("Please verifie the firstname, it's doesn't null!");
        }
        if(!StringUtils.hasLength(clientDTO.getEmail())){
            errors.add("Please verifie the email adress, it's doesn't null!");
        }

        return errors;
    }
}
