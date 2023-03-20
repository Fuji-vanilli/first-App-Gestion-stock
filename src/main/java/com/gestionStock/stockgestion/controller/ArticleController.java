package com.gestionStock.stockgestion.controller;

import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.DTOs.response.ArticleResponse;
import com.gestionStock.stockgestion.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.gestionStock.stockgestion.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/article")
@RequiredArgsConstructor
public class ArticleController implements ArticleApi{

    private final ArticleService articleService;

    @Override
    public ArticleResponse create(ArticleRequest articleRequest) {
        return articleService.create(articleRequest);
    }

    @Override
    public ArticleResponse getById(String id) {
        return articleService.getById(id);
    }

    @Override
    public ArticleResponse getByCodeArticle(String code) {
        return articleService.getByCodeArticle(code);
    }

    @Override
    public List<ArticleResponse> getAll() {
        return articleService.getAll();
    }

    @Override
    public boolean deleteById(String id) {
        return articleService.deleteById(id);
    }
}
