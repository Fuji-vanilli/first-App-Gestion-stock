package com.gestionStock.stockgestion.controllers.apiImplementation;

import com.gestionStock.stockgestion.DTOs.CategoryDTO;
import com.gestionStock.stockgestion.controllers.api.CategoryApi;
import com.gestionStock.stockgestion.services.servicesImplementation.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return categoryService.create(categoryDTO);
    }

    @Override
    public CategoryDTO getById(Integer id) {
        return categoryService.getById(id);
    }

    @Override
    public CategoryDTO getByCodeCategory(String code) {
        return categoryService.getByCodeCategory(code);
    }

    @Override
    public List<CategoryDTO> getAll() {
        return categoryService.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return categoryService.delete(id);
    }
}
