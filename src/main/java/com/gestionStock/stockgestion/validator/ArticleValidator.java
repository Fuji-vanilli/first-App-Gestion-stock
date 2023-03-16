package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
public class ArticleValidator {

    public List<String> validate(ArticleRequest articleRequest){
        List<String> errors= new ArrayList<>();

        if(articleRequest == null || !StringUtils.hasLength(articleRequest.getCodeArticle())){
            errors.add("article doesn't empty and code article is required");
        }
        if(!StringUtils.hasLength(articleRequest.getDesignation())){
            errors.add("Designation is required");
        }
        if(articleRequest.getPriceUnitHT()== null){
            errors.add("Price is required!");
        }

        return errors;
    }
}
