package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.CategoryDTO;
import com.gestionStock.stockgestion.DTOs.ClientDTO;

import java.util.List;

public interface ICategoryService {

    CategoryDTO create(CategoryDTO categoryDTO);
    CategoryDTO getById(Integer id);
    CategoryDTO getByCodeCategory(String code);
    List<CategoryDTO> getAll();
    boolean delete(Integer id);


}
