package com.gestionStock.stockgestion.validators;

import com.gestionStock.stockgestion.DTOs.CategoryDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CategoryValidator {

    public static List<String> validate(CategoryDTO categoryDTO){
        List<String> errors= new ArrayList<>();

        if(categoryDTO== null){
            Stream.of(
                    "verifier l'id du category!",
                    "Verifier la designation du category!"
            ).forEach(error->{
                errors.add(error);
            });

        }

        if(!StringUtils.hasLength(categoryDTO.getDesignation()))
            errors.add("Le designation ne doit pas etre null!");

        return errors;
    }
}
