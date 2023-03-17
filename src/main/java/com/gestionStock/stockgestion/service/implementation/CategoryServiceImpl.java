package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.CategoryMapping;
import com.gestionStock.stockgestion.DTOs.request.CategoryRequest;
import com.gestionStock.stockgestion.DTOs.response.CategoryResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.models.Category;
import com.gestionStock.stockgestion.repositories.CategoryRepository;
import com.gestionStock.stockgestion.service.CategoryService;
import com.gestionStock.stockgestion.validator.ArticleValidator;
import com.gestionStock.stockgestion.validator.CategoryValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapping categoryMapping;

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        List<String> errors= CategoryValidator.validate(categoryRequest);

        if(!errors.isEmpty()){
            log.error("the category doesn't valid");
            throw new InvalidEntityException("Category invalid", ErrorCode.CATEGORY_NOT_VALID, errors);
        }

        Category category= categoryMapping.categoryRequestToCategory(categoryRequest);
        category.setId(UUID.randomUUID().toString());

        return categoryMapping.categoryToCategoryResponse(
                categoryRepository.save(category)
        );
    }

    @Override
    public CategoryResponse getById(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return null;
        }

        Optional<Category> category= categoryRepository.findById(id);

        CategoryResponse categoryResponse= categoryMapping.categoryToCategoryResponse(category.get());

        return Optional.of(categoryResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "category with id: "+id+" doesn't exist in the database",
                        ErrorCode.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public List<CategoryResponse> getAll() {

        return categoryRepository.findAll()
                .stream()
                .map(category -> categoryMapping.categoryToCategoryResponse(category))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }
}
