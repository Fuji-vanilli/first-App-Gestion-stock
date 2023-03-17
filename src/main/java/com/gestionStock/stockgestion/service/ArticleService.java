package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.DTOs.response.ArticleResponse;
import com.gestionStock.stockgestion.repositories.ArticleRepository;

import java.util.List;

public interface ArticleService {
    ArticleResponse create(ArticleRequest articleRequest);
    ArticleResponse getById(String id);
    ArticleResponse getByCodeArticle(String code);
    List<ArticleResponse> getAll();
    boolean deleteById(String id);

}
