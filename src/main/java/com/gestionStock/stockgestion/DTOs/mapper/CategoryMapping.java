package com.gestionStock.stockgestion.DTOs.mapper;


import com.gestionStock.stockgestion.DTOs.request.CategoryRequest;
import com.gestionStock.stockgestion.DTOs.response.CategoryResponse;
import com.gestionStock.stockgestion.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapping {

    Category categoryRequestToCategory(CategoryRequest categoryRequest);
    CategoryResponse categoryToCategoryResponse(Category category);
}
