package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.ArticleDTO;

import java.util.List;

public interface IArticleService {

    ArticleDTO getById(Integer id);
    ArticleDTO getByCode(String code);
    ArticleDTO create(ArticleDTO articleDTO);
    List<ArticleDTO> getAll();
    boolean delete(Integer id);

}
