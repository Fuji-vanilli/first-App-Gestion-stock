package com.gestionServer.gestionServer.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.gestionServer.gestionServer.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Integer id;

    private String code;

    private String designation;

    @JsonIgnore
    private List<ArticleDTO> articles;

    public static CategoryDTO fromEntityCategory(Category category){
        if(category== null)
            return null;

        return CategoryDTO.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public static Category toEntityCategory(CategoryDTO categoryDTO){
        if(categoryDTO== null)
            return null;

        Category category= new Category();
        category.setId(categoryDTO.getId());
        category.setCode(categoryDTO.getCode());
        category.setDesignation(category.getDesignation());

        return category;

    }
}
