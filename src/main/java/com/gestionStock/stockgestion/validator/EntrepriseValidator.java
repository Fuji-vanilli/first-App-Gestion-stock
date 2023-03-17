package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.DTOs.request.EntrepriseRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class EntrepriseValidator {

    public static List<String> validate(EntrepriseRequest entrepriseRequest){
        List<String> errors= new ArrayList<>();

        if(entrepriseRequest == null || !StringUtils.hasLength(entrepriseRequest.getName())){
            errors.add("entreprise doesn't empty and name of the entreprise is required");
        }
        if(!StringUtils.hasLength(entrepriseRequest.getEmail())){
            errors.add("email is required");
        }
        if(entrepriseRequest.getAdress()== null){
            errors.add("adress is required!");
        }
        if(entrepriseRequest.getTel()== null){
            errors.add("tel is required!");
        }
        if(entrepriseRequest.getCodeFiscal()== null){
            errors.add("code fiscal is required!");
        }

        return errors;
    }
}
