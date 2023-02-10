package com.gestionStock.stockgestion.services.servicesImplementation;

import com.gestionStock.stockgestion.DTOs.ArticleDTO;
import com.gestionStock.stockgestion.exceptions.EntityNotFoundException;
import com.gestionStock.stockgestion.exceptions.ErrorCode;
import com.gestionStock.stockgestion.exceptions.InvalidEntityException;
import com.gestionStock.stockgestion.models.Article;
import com.gestionStock.stockgestion.repositories.ArticleRepository;
import com.gestionStock.stockgestion.services.businessService.IArticleService;
import com.gestionStock.stockgestion.validators.ArticleValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ArticleDTO getById(Integer id) {
        if(id== null) {
            log.error("Id of the article is null!!!");
            return null;
        }

        Optional<Article> article= articleRepository.findById(id);

        return Optional.of(
                ArticleDTO.fromEntityArticle(article.get()))
                .orElseThrow(()->
                    new EntityNotFoundException(
                            "No article of an id= "+id+" on the database",
                            ErrorCode.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public ArticleDTO getByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Article code is null");
            return null;
        }

        Optional<Article> article= articleRepository.findByCodeArticle(code);

        return Optional.of(ArticleDTO.fromEntityArticle(article.get()))
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Article with code "+code+" is not in the database!",
                                ErrorCode.ARTICLE_NOT_FOUND)
                        );
    }

    @Override
    public ArticleDTO create(ArticleDTO articleDTO) {
        List<String> errors= ArticleValidator.validate(articleDTO);

        if(!errors.isEmpty()){
            log.error("Article isn't valid {} ", articleDTO);
            throw new InvalidEntityException("Article not valid", ErrorCode.ARTICLE_NOT_VALID, errors);
        }
        Article article= ArticleDTO.toEntityArticle(articleDTO);
        articleRepository.save(article);

        return ArticleDTO.fromEntityArticle(
                articleRepository.save(ArticleDTO.toEntityArticle(articleDTO))
        );
    }

    @Override
    public List<ArticleDTO> getAll() {

        return articleRepository.findAll()
                .stream().map(ArticleDTO::fromEntityArticle)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        if(id== null){
            log.error("The id of the article is null");
            return false;
        }
        articleRepository.deleteById(id);
        return true;
    }
}
