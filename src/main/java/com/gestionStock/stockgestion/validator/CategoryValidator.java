package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.CategoryRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryRequest categoryRequest){
        List<String> errors= new ArrayList<>();

        if(categoryRequest == null || !StringUtils.hasLength(categoryRequest.getCode())){
            errors.add("category doesn't empty and code category is required");
        }
        if(!StringUtils.hasLength(categoryRequest.getName())) {
            errors.add("Designation is required");
        }
        return errors;
    }
}
