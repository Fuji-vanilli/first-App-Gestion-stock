package com.gestionStock.stockgestion.controllers.api;

import com.gestionStock.stockgestion.DTOs.ArticleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.*;
import java.util.List;

import static com.gestionStock.stockgestion.utils.Constants.APP_ROOT;

@Api(value = APP_ROOT+ "articles")
public interface ArticleApi {

    @ApiOperation(value = "Create a new articles", notes= "This methodes create a new artciles on the database", response = ArticleApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "create with success")
    })
    @PostMapping(value = APP_ROOT+ "article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO create(@RequestBody ArticleDTO articleDTO);

    @ApiOperation(value = "Get articles by Id", notes= "This methodes getting artciles by Id", response = ArticleApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "create with success"),
            @ApiResponse(code = 300, message = "bad request"
            )
    })
    @GetMapping(value = APP_ROOT+ "article/get/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO getById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT+ "article/get/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO getByCodeArticle(@PathVariable("codeArticle") String code);

    @GetMapping(value = APP_ROOT+ "article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDTO> getAll();

    @DeleteMapping(value = APP_ROOT+ "article/delete/{id}")
    boolean delete(@PathVariable Integer id);
}
