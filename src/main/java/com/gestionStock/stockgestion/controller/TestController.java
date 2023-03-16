package com.gestionStock.stockgestion.controller;

import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
@RequiredArgsConstructor
public class TestController {

    private final ArticleService articleService;

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody ArticleRequest articleRequest){
        articleService.create(articleRequest);

        return new ResponseEntity<>("request ok", HttpStatus.CREATED);
    }

}
