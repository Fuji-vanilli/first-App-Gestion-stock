package com.gestionStock.stockgestion.controllers.api;

import com.gestionStock.stockgestion.DTOs.CategoryDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestionStock.stockgestion.utils.Constants.APP_ROOT;

public interface CategoryApi {

    @PostMapping(value = APP_ROOT+ "category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO create(@RequestBody CategoryDTO categoryDTO);

    @GetMapping(value = APP_ROOT+ "category/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO getById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+ "category/get/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO getByCodeCategory(@PathVariable String code);

    @GetMapping(value = APP_ROOT+ "category/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDTO> getAll();

    @DeleteMapping(value = "category/delete/{id}")
    boolean delete(@PathVariable Integer id);
}
