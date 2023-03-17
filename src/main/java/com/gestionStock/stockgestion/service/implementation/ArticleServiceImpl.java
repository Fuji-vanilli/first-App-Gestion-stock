package com.gestionStock.stockgestion.service.implementation;

import com.gestionStock.stockgestion.DTOs.mapper.ArticleMapping;
import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.DTOs.response.ArticleResponse;
import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.ErrorCode;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.repositories.ArticleRepository;
import com.gestionStock.stockgestion.service.ArticleService;
import com.gestionStock.stockgestion.validator.ArticleValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
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
        List<String> errors= ArticleValidator.validate(articleRequest);

        if(!errors.isEmpty()){
            log.error("Article is not valid");
            throw new InvalidEntityException("Article not valid", ErrorCode.ARTICLE_NOT_VALID, errors);
        }
        Articles article= articleMapping.articleRequestToArticle(articleRequest);

        article.setId(UUID.randomUUID().toString());
        article.setDateCreated(Instant.now());

        return articleMapping.articleToArticleResponse(articleRepository.save(article));
    }

    @Override
    public ArticleResponse getById(String id) {

        if(!StringUtils.hasLength(id)){
            log.error("id of article doesn't null");
            return null;
        }

        Optional<Articles> articles= articleRepository.findById(id);

        ArticleResponse articleResponse= articleMapping.articleToArticleResponse(articles.get());

        return Optional.of(articleResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "article doesn't exist in the database",
                        ErrorCode.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleResponse getByCodeArticle(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("code doesn't null");
            return null;
        }

        Optional<Articles> articles= articleRepository.findByCodeArticle(code);

        ArticleResponse articleResponse= articleMapping.articleToArticleResponse(articles.get());

        return Optional.of(articleResponse).orElseThrow(
                ()-> new EntityNotFoundException(
                        "Article with code: "+code+" doesn't exist in database",
                        ErrorCode.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleResponse> getAll() {

        return articleRepository.findAll()
                .stream()
                .map(articles -> articleMapping.articleToArticleResponse(articles))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(String id) {
        if(!StringUtils.hasLength(id)){
            log.error("id doesn't null");
            return false;
        }
        articleRepository.deleteById(id);
        return true;
    }
}
