package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.VenteDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> valdiate(VenteDTO venteDTO){
        List<String> errors= new ArrayList<>();

        if(venteDTO== null){
            errors.add("Verifie the vente code");
            errors.add("Verifie the vente id");
        }
        if(!StringUtils.hasLength(venteDTO.getCode())){
            errors.add("The code of the vente doesn't null");
        }

        return errors;
    }
}
