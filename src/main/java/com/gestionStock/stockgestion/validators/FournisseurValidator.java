package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.FournisseurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDTO fournisseurDTO){

        List<String> errors= new ArrayList<>();
        if(fournisseurDTO== null){
            Stream.of(
                    "Verifie the firstname of the fournisseur",
                    "Verifie the adress of the fournisseur",
                    "Verifie the telephone number of the fournisseur"
            ).forEach(error->{
                errors.add(error);
            });
        }
        if(!StringUtils.hasLength(fournisseurDTO.getFirstName())){
            errors.add("The firstname doesn't null");
        }
        if(fournisseurDTO.getAdress()== null){
            errors.add("The adress of the fournisseur doesn't null");
        }
        if(!StringUtils.hasLength(String.valueOf(fournisseurDTO.getTel()))){
            errors.add("The telephone number doesn't null");
        }

        return errors;
    }
}
