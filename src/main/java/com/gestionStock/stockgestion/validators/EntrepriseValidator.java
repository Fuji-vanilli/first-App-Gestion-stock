package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.EntrepriseDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDTO entrepriseDTO){
        List<String> errors= new ArrayList<>();

        if(entrepriseDTO== null){
            Stream.of(
                    "Verifie the name of the entreprise",
                    "Verifie the adress of the entreprise",
                    "Verifie the code fiscal of the entreprise"
            ).forEach(error->{
                errors.add(error);
            });
        }
        if(!StringUtils.hasLength(entrepriseDTO.getName())){
            errors.add("The name doesn't null");
        }
        if(!StringUtils.hasLength(entrepriseDTO.getCodeFiscal())){
            errors.add("The fiscal code doesn't null");
        }
        if(entrepriseDTO.getAdress()== null){
            errors.add("The Adress of the entreprise doesn't null");
        }

        return errors;
    }
}
