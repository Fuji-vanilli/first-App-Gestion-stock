package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.CategoryDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Category;
import com.gestionStock.stockgestion.repositories.CategoryRepository;
import com.gestionStock.stockgestion.services.businessService.ICategoryService;
import com.gestionStock.stockgestion.validators.CategoryValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        List<String> errors= CategoryValidator.validate(categoryDTO);

        if(!errors.isEmpty()){
            log.error("Category is not valid {} ", categoryDTO);
            throw new InvalidEntityException("Category not valid", ErrorCode.CATEGORY_NOT_VALID, errors);
        }

        return CategoryDTO.fromEntityCategory(
                categoryRepository.save(CategoryDTO.toEntityCategory(categoryDTO))
        );
    }

    @Override
    public CategoryDTO getById(Integer id) {
        if(id== null){
            log.error("The id is null");
            return null;
        }

        Optional<Category> category= categoryRepository.findById(id);

        return Optional.of(
                CategoryDTO.fromEntityCategory(category.get()))
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "The category with the id "+id+" not exist in the database",
                                ErrorCode.CATEGORY_NOT_FOUND)
                        );
    }

    @Override
    public CategoryDTO getByCodeCategory(String code) {

        if(code== null){
            log.error("the code is null!");
            return null;
        }

        Optional<Category> category= categoryRepository.findByCode(code);

        return Optional.of(
                CategoryDTO.fromEntityCategory(category.get()))
                        .orElseThrow(()->
                                new EntityNotFoundException(
                                        "The category with the code "+code+" doesn't exist in the database",
                                        ErrorCode.CATEGORY_NOT_FOUND
                                )
        );
    }

    @Override
    public List<CategoryDTO> getAll() {

        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::fromEntityCategory)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {

        if(id== null){
            log.error("The id is null");
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }
}
