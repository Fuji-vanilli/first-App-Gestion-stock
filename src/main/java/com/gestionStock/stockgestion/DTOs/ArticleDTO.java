package com.gestionServer.gestionServer.DTOs;

import com.gestionServer.gestionServer.models.Article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal TVA;

    private BigDecimal prixUnitaireTTC;

    private String photo;

    private CategoryDTO categoryDTO;

    public static ArticleDTO fromEntityArticle(Article article){
        if(article== null)
            return null;

        return ArticleDTO.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .TVA(article.getTVA())
                .prixUnitaireTTC(article.getPrixUnitaireTTC())
                .photo(article.getPhoto())
                .categoryDTO(CategoryDTO.fromEntityCategory(article.getCategory()))
                .build();
    }

    public static Article toEntityArticle(ArticleDTO articleDTO){
        if(articleDTO== null)
            return null;

        Article article= new Article();
        article.setId(articleDTO.getId());
        article.setCodeArticle(articleDTO.getCodeArticle());
        article.setDesignation(articleDTO.getDesignation());
        article.setPrixUnitaireHt(articleDTO.getPrixUnitaireHt());
        article.setTVA(articleDTO.getTVA());
        article.setPrixUnitaireTTC(articleDTO.getPrixUnitaireTTC());
        article.setPhoto(articleDTO.getPhoto());
        article.setCategory(CategoryDTO.toEntityCategory(articleDTO.getCategoryDTO()));

        return article;
    }

}
