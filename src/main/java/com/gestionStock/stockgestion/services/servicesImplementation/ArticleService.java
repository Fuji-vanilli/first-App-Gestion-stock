package com.gestionServer.gestionServer.services.servicesImplementation;

import com.gestionServer.gestionServer.DTOs.ArticleDTO;
import com.gestionServer.gestionServer.exceptions.EntityNotFoundException;
import com.gestionServer.gestionServer.exceptions.ErrorCode;
import com.gestionServer.gestionServer.exceptions.InvalidEntityException;
import com.gestionServer.gestionServer.models.Article;
import com.gestionServer.gestionServer.repositories.ArticleRepository;
import com.gestionServer.gestionServer.services.IArticleService;
import com.gestionServer.gestionServer.validators.ArticleValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

        Optional<Article> article= articleRepository.findByArticleByCode(code);

        return Optional.of(ArticleDTO.fromEntityArticle(article.get()))
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Article with code "+code+" is not in the database!",
                                ErrorCode.ARTICLE_NOT_FOUND)
                        );
    }

    @Override
    public ArticleDTO save(ArticleDTO articleDTO) {
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
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
