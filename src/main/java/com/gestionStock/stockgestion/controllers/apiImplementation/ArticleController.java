package com.gestionStock.stockgestion.controllers.apiImplementation;

import com.gestionStock.stockgestion.DTOs.ArticleDTO;
import com.gestionStock.stockgestion.controllers.api.ArticleApi;
import com.gestionStock.stockgestion.services.servicesImplementation.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;

    @Override
    public ArticleDTO create(ArticleDTO articleDTO) {
        return articleService.create(articleDTO);
    }

    @Override
    public ArticleDTO getById(Integer id) {
        return articleService.getById(id);
    }

    @Override
    public ArticleDTO getByCodeArticle(String code) {
        return articleService.getByCode(code);
    }

    @Override
    public List<ArticleDTO> getAll() {
        return articleService.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return articleService.delete(id);
    }
}
