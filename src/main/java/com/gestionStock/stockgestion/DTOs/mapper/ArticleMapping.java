package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.DTOs.response.ArticleResponse;
import com.gestionStock.stockgestion.models.Articles;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapping {

    Articles articleRequestToArticle(ArticleRequest articleRequest);
    ArticleResponse articleToArticleResponse(Articles articles);
}
