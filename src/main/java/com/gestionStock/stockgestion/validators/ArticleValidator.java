package com.gestionServer.gestionServer.validators;

import com.gestionServer.gestionServer.DTOs.ArticleDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDTO articleDTO){
        List<String> errors= new ArrayList<>();

        if(articleDTO== null){
            errors.add("Veuillez verifier le code de l'article!");
            errors.add("Veuillez vertifier le prix unitaire hors taxe de l'article");
            errors.add("Veuillez vertifier le categorie de l'article");
        }
        if(!StringUtils.hasLength(articleDTO.getCodeArticle()))
            errors.add("Verifiez le code de l'article svp!");

        if(!StringUtils.hasLength(articleDTO.getCategoryDTO().getCode()))
            errors.add("Verifiez le categorie de l'article");
        return errors;
    }
}
