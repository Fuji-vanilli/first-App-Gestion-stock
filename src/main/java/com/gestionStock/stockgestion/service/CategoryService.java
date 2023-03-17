package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.CategoryRequest;
import com.gestionStock.stockgestion.DTOs.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryRequest categoryRequest);
    CategoryResponse getById(String id);
    List<CategoryResponse> getAll();
    boolean deleteById(String id);
}
