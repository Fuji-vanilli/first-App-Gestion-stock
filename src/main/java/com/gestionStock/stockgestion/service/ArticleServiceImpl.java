package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.mapper.ArticleMapping;
import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.DTOs.response.ArticleResponse;
import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapping articleMapping;

    @Override
    public ArticleResponse create(ArticleRequest articleRequest) {
        Articles article= articleMapping.articleRequestToArticle(articleRequest);

        article.setId(UUID.randomUUID().toString());
        article.setDateCreated(Instant.now());

        return articleMapping.articleToArticleResponse(articleRepository.save(article));
    }

    @Override
    public ArticleResponse getById(String id) {

        return articleMapping.articleToArticleResponse(
                articleRepository.findById(id).get()
        );
    }

    @Override
    public List<ArticleResponse> getAll() {

        return articleRepository.findAll()
                .stream()
                .map(articles -> articleMapping.articleToArticleResponse(articles))
                .collect(Collectors.toList());
    }
}
